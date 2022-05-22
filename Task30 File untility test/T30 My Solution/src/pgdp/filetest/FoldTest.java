package pgdp.filetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pgdp.file.DummyFold;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FoldTest {
    //DO NOT CHANGE THE SIGNATURE OF THIS ATTRIBUTE!
    //ALWAYS USE THIS ATTRIBUTE TO CALL THE MAIN METHOD OF THE FOLD IMPLEMENTATION
    //You can, however, change the initial value of this attribute here to other Fold implementations
    //But do not change this value anywhere else, only right here!
    //And before submitting to artemis, make sure to change this back to DummyFold::main or just don't set any value!
    public static FoldImplementation fold = DummyFold::main;

    //TODO: Write good tests...

    @BeforeEach
    public void clearSandbox() {
        deleteAllInSandbox();
        copyAllFromVaultToSandbox();
    }

    // test for 1-input-file case
    @Test
    public void correctOutputTest1() throws IOException {
        String[] argsActual = {"sandbox/pingu.txt", "-w=10", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/pingu.txt", "-w=10", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:

        Path actualPath = Path.of("sandbox/actual.txt");
        String actualStr = Files.readString(actualPath);

        Path expectedPath = Path.of("sandbox/correct.txt");
        String expectedStr = Files.readString(expectedPath);

        assertEquals(expectedStr, actualStr);
    }

    @Test
    public void correctOutputTest2() {
        String[] argsActual = {"sandbox/pingu.txt", "-w=10", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        // if implementation is correct, actual.txt should then be created, so no IOException
        assertDoesNotThrow(() -> Files.readString(Path.of("sandbox/actual.txt")));
    }

    // test for 3-input-file case, order matters:
    @Test
    public void correctOutputTest3() throws IOException {
        String[] argsActual = {"sandbox/hello.txt", "sandbox/pingu.txt",
                               "sandbox/lists/shoppinglist.txt", "-w=15", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/hello.txt", "sandbox/pingu.txt",
                                "sandbox/lists/shoppinglist.txt", "-w=15", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:
        Path actualPath = Path.of("sandbox/actual.txt");
        String actualStr = Files.readString(actualPath);

        Path expectedPath = Path.of("sandbox/correct.txt");
        String expectedStr = Files.readString(expectedPath);

        assertEquals(expectedStr, actualStr);
    }

    // test for width = 2:
    @Test
    public void widthTest1() throws IOException {
        String[] argsActual = {"sandbox/hello.txt", "-w=2", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/hello.txt", "-w=2", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:
        Path actualPath = Path.of("sandbox/actual.txt");
        String actualStr = Files.readString(actualPath);

        Path expectedPath = Path.of("sandbox/correct.txt");
        String expectedStr = Files.readString(expectedPath);

        assertEquals(expectedStr, actualStr);
    }

    // test for width = 5
    @Test
    public void widthTest2() throws IOException {

        String[] argsActual = {"sandbox/table.txt", "-w=5", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/table.txt", "-w=5", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:
        Path actualPath = Path.of("sandbox/actual.txt");
        String actualStr = Files.readString(actualPath);

        Path expectedPath = Path.of("sandbox/correct.txt");
        String expectedStr = Files.readString(expectedPath);

        assertEquals(expectedStr, actualStr);
    }

    // test for default width = 80
    @Test
    public void widthTest3() throws IOException {
        String[] argsActual = {"sandbox/table.txt", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/table.txt", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:
        Path actualPath = Path.of("sandbox/actual.txt");
        String actualStr = Files.readString(actualPath);

        Path expectedPath = Path.of("sandbox/correct.txt");
        String expectedStr = Files.readString(expectedPath);

        assertEquals(expectedStr, actualStr);
    }

    // test for invalid commandline arguments: width = 0/-10/some string
    @Test
    public void widthTest4() {
        String[] argsActual1 = {"sandbox/table.txt", "-w=0", "-o=sandbox/actual1.txt"};
        String[] argsActual2 = {"sandbox/table.txt", "-w=-10", "-o=sandbox/actual2.txt"};
        String[] argsActual3 = {"sandbox/table.txt", "-w=Pinguin", "-o=sandbox/actual3.txt"};
        fold.main(argsActual1);
        fold.main(argsActual2);
        fold.main(argsActual3);

        // the fold implementation should't create the output file,
        assertAll(()-> assertFalse(Files.exists(Path.of("sandbox/actual1.txt"))),
                ()-> assertFalse(Files.exists(Path.of("sandbox/actual2.txt"))),
                ()-> assertFalse(Files.exists(Path.of("sandbox/actual3.txt"))));
    }

    // test for the option order -o, ..., -w and -w, ... , -o
    // order of option does not matter, the results should be the same
    @Test
    public void independentFromOptionOrderTest() throws IOException {
        String[] argsActual1 = {"sandbox/pingu.txt", "-w=3", "sandbox/table.txt", "-o=sandbox/actual1.txt"};
        fold.main(argsActual1);
        String[] argsActual2 = {"sandbox/pingu.txt", "-o=sandbox/actual2.txt", "sandbox/table.txt", "-w=3"};
        fold.main(argsActual2);

        String[] argsCorrect = {"-o=sandbox/correct.txt", "sandbox/pingu.txt", "sandbox/table.txt", "-w=3"};
        correctFold.main(argsCorrect);

        // compare actual outputs with correct.txt:
        // the above two should be the same with each other and also same with the correct output
        String actualStr1 = Files.readString(Path.of("sandbox/actual1.txt"));
        String actualStr2 = Files.readString(Path.of("sandbox/actual2.txt"));
        String expectedStr = Files.readString(Path.of("sandbox/correct.txt"));

        assertAll(()->assertEquals(actualStr1, actualStr2),
                ()-> assertEquals(expectedStr, actualStr1),
                ()-> assertEquals(expectedStr, actualStr2));
    }

    // test for one of 3 input files is missing:
    @Test
    public void missingInputFileTest() throws IOException {
        // love.txt is not in sandbox
        String[] argsActual = {"sandbox/love.txt", "sandbox/pingu.txt", "sandbox/table.txt",
                                "-w=3", "-o=sandbox/actual.txt"};
        fold.main(argsActual);

        String[] argsCorrect = {"sandbox/love.txt", "sandbox/pingu.txt", "sandbox/table.txt",
                                "-w=3", "-o=sandbox/correct.txt"};
        correctFold.main(argsCorrect);

        // compare actual.txt with correct.txt:
        String actualStr = Files.readString(Path.of("sandbox/actual.txt"));
        String expectedStr = Files.readString(Path.of("sandbox/correct.txt"));
        assertEquals(expectedStr, actualStr);
    }


    //Helper Methods
    //this methods recursively deletes everything in the directory
    private static void deleteAllInSandbox() {
        //traverse the sandbox directory in reverse order (to delete deepest first)
        try (Stream<Path> stream = Files.walk(Path.of("sandbox"))) {
            stream.skip(1) //don't delete the sandbox folder itself
                    .sorted(Comparator.reverseOrder())
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                            throw new TestSetupFailedException("Error trying to delete test file: " + e);
                        }
                    });
        } catch (IOException | UncheckedIOException e) {
            throw new TestSetupFailedException("Error trying to clean up the sandbox: " + e);
        }
    }

    //this method copies everything inside the file_vault into the sandbox recursively
    private static void copyAllFromVaultToSandbox() {
        Path source = Path.of("file_vault"), destination = Path.of("sandbox");
        //traverse the directory and copy every file and folder within it
        try (Stream<Path> stream = Files.walk(source)) {
            stream.skip(1) //don't copy the files folder itself
                    .forEach(file -> {
                        try {
                            Files.copy(file, destination.resolve(source.relativize(file)));
                        } catch (IOException e) {
                            throw new TestSetupFailedException("Error trying to copy test file: " + e);
                        }
                    });
        } catch (IOException | UncheckedIOException e) {
            throw new TestSetupFailedException("Error trying to walk over test files: " + e);
        }
    }
}
