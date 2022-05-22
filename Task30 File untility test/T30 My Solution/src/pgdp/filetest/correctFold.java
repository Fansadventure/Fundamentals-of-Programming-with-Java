package pgdp.filetest;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class correctFold {

    public static void main(String[] args) {
        try {
            new correctFold(args).applyToAll();
        } catch (InvalidCommandLineArgumentException e) {
            System.err.println("Error: " + beautify(e));
        }
    }
    // Attributes:
    private final int width;
    private final List<Path> inputPaths;
    private final Path outputFile;
    // Constructor:
    public correctFold(String[] args) throws InvalidCommandLineArgumentException {
        //parse all input paths
        try {
            inputPaths = Arrays.stream(args)
                    .filter(arg -> !arg.startsWith("-"))
                    .map(Path::of).collect(Collectors.toList());
        } catch (InvalidPathException e) {
            throw new InvalidCommandLineArgumentException("Could not parse an input file: " + beautify(e));
        }

        //parse the output path if it exists
        String outputPath = parseOption(args, "o", null);
        if (outputPath != null) {
            try {
                outputFile = Path.of(outputPath);
            } catch (InvalidPathException e) {
                throw new InvalidCommandLineArgumentException("Could not parse the output file " + outputPath);
            }
        } else
            outputFile = null;

        //parse width
        try {
            width = Integer.parseInt(parseOption(args, "w", "80"));
        } catch (NumberFormatException e) {
            throw new InvalidCommandLineArgumentException("Width could not be parsed!");
        }
        //make sure width is valid
        if (width <= 0)
            throw new InvalidCommandLineArgumentException("Width must be positive!");
    }

    public static String parseOption(String[] args, String option, String defaultValue) {
        return Arrays.stream(args)
                .filter(flag -> flag.startsWith("-" + option + "="))
                .map(flag -> (flag.substring(2 + option.length())))
                .findFirst().orElse(defaultValue);
    }

    public void applyToAll() {
        StringBuilder result = new StringBuilder();

        for (Path path : inputPaths) {
            if ( Files.exists(path) && Files.isRegularFile(path)) {
                result.append(applyToFile(path));
            }
            /*else if (Files.isDirectory(path)) {
                try (Stream<Path> stream = Files.walk(path)) {
                    stream.filter(Files::isRegularFile)
                            .map(this::applyToFile)
                            .forEach(result::append);
                } catch (IOException | UncheckedIOException e) {
                    System.err.println("Error while crawling directory " + path + ": " + beautify(e));
                }
            } else {
                System.err.println("Error: Path " + path + " either does not exist, or is not a file or a directory.");
            }*/
        }

        output(result.toString());
    }

    public void output(String str) {
        if (outputFile == null) {
            System.out.print(str);
        } else {
            try {
                Files.writeString(outputFile, str);
            } catch (IOException e) {
                System.err.println("Error while writing output to file " + outputFile + ": " + beautify(e));
            }
        }
    }

    public String applyToFile(Path file) {
        try (Stream<String> lines = Files.lines(file)) {
            return "Fold on file " + file + ":" + System.lineSeparator() + lines
                    .map(line -> wrapLine(line) + System.lineSeparator())
                    .collect(Collectors.joining());
        } catch (IOException | UncheckedIOException e) {
            System.err.println("Error while applying Fold on file " + file + ": " + beautify(e));
            return "";
        }
    }
    // helper method
    private String wrapLine(String line) {
        StringBuilder result = new StringBuilder();
        //x is the current position of the "cursor"
        int x = 0;
        for (char c : line.toCharArray()) {
            if (x == width) {
                x = 0;
                result.append(System.lineSeparator());
            }
            result.append(c);
            x++;
        }
        return result.toString();
    }


    //helper method, kinda ugly for a method called "beautify", but that's what it takes to achieve beauty
    //this is not necessary, you can just output the "ugly" exception too!
    protected static String beautify(Exception e) {
        if (e instanceof UncheckedIOException)
            e = ((UncheckedIOException) e).getCause();

        return e.getClass().getSimpleName()
                .replaceAll("([A-Z][a-z]+)", " $1")
                .replaceAll("Exception", "")
                .trim()
                + ": " + e.getLocalizedMessage();
    }

    //helper method that ensures that the string ends with a line ending
    protected static String endWithEOL(String str) {
        return str.endsWith(System.lineSeparator()) ? str : str + System.lineSeparator();
    }
}
