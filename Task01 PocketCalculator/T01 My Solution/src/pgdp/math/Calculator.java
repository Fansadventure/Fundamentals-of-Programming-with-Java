package pgdp.math;
import java.util.Scanner;
public class Calculator extends MiniJava {
    public static void main(String[] args) {
// create a scanner to store the user input into variables
        Scanner input = new Scanner(System.in);
        System.out.println("Wählen Sie eine Operation:\n1) +\n2) -\n3) *\n4) /\n5) %\n6) Programm beenden");
        int i, a, b, result;
        i = input.nextInt();

        while (true) {
            if (1 <= i && i<= 5) {
                System.out.println("Ersten Operand eingeben:");
                a = input.nextInt();
                System.out.println("Zweiten Operand eingeben:");
                b = input.nextInt();
                if (i == 4 && b == 0) {
                    System.out.println("Fehler: Division durch 0!");
                } else if (i == 5 && b == 0) {
                    System.out.println("Fehler: Division durch 0!");
                } else { // do the calculation
                    result = 0;
                    switch (i) {
                        case 1:
                            result = a + b;
                            break;
                        case 2:
                            result = a - b;
                            break;
                        case 3:
                            result = a * b;
                            break;
                        case 4:
                            result = a / b;
                            break;
                        case 5:
                            result = a % b;
                            break;
                    }
                    System.out.println(result);
                }
                System.out.println("Wählen Sie eine Operation:\n1) +\n2) -\n3) *\n4) /\n5) %\n6) Programm beenden");
            }

            if(i == 6){
                System.out.println();break;
            }
            if(i<=0 || i>=7){
                System.out.println("Wählen Sie eine Operation:\n1) +\n2) -\n3) *\n4) /\n5) %\n6) Programm beenden");
            } i = input.nextInt();
        }
    }
}
