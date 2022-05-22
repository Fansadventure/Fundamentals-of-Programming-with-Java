package pgdp.w02.h02;

import java.util.Arrays;
import java.util.Scanner;

public class TwoMaximums extends MiniJava {
  public static void main(String[] args) {
    Scanner scann = new Scanner(System.in);
    System.out.println("Bitte Anzahl eingeben:");
    int k = scann.nextInt();
    int i;

    if (k >= 2) {  // create an integer array from user inputs
      int[] array = new int[k];
      for (i = 0; i < k; i++) {
        System.out.println("Bitte Zahlen eingeben:");
        array[i] = scann.nextInt();
      }
      scann.close();
      // find the largest and second largest numbers in the array
      Arrays.sort(array);
      System.out.println("Erster: \n" + array[k - 1]);
      System.out.println("Zweiter: \n" + array[k - 2]);

    } else{
      System.out.println("Fehler: Anzahl >= 2 erwartet!");
    }
  }
}
