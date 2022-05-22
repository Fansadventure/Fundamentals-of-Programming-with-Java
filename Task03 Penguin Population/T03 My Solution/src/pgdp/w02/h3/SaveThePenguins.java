package pgdp.w02.h3;

import java.util.ArrayList;
import java.util.Scanner;

public class SaveThePenguins extends MiniJava {
  public static void main(String[] args) {
    Scanner scann = new Scanner(System.in);
    System.out.println("Bitte Geben Sie die Anzahl an Zeitschritten ein (>= 1):");
    int k = scann.nextInt();
    ArrayList<Integer> junge = new ArrayList<>(k+1);
    ArrayList<Integer> jungeErwaschsene = new ArrayList<>(k+1);
    ArrayList<Integer> Erwachsene = new ArrayList<>(k+1);
    ArrayList<Integer> alteErwachsene = new ArrayList<>(k+1);
    ArrayList<Integer> Weise = new ArrayList<>(k+1);
    ArrayList<Integer> supply = new ArrayList<>(k+1); // food supply

    if(k<1){
      System.out.println("Zeitschritte >= 1 erforderlich");
    } else { //collect user input to intialize the arraylists for each age groups
      System.out.println("Startpopulation Jungtiere");
      junge.add(0, scann.nextInt());
      System.out.println("Startpopulation Junge Erwachsene");
      jungeErwaschsene.add(0, scann.nextInt());
      System.out.println("Startpopulation Erwachsene");
      Erwachsene.add(0, scann.nextInt());
      System.out.println("Startpopulation Alte Erwachsene");
      alteErwachsene.add(0, scann.nextInt());
      System.out.println("Startpopulation Weise");
      Weise.add(0, scann.nextInt());

      // simulate the population
      for (int i=0; i<k; i++) {
        // food supply
        supply.add(i,(jungeErwaschsene.get(i) * 3 + Erwachsene.get(i) * 2));
        // compute population
        if (supply.get(i) >= junge.get(i)) {
          jungeErwaschsene.add(i+1, junge.get(i));
          if (supply.get(i) - junge.get(i) >= jungeErwaschsene.get(i)) {
            Erwachsene.add(i+1, jungeErwaschsene.get(i));
            if (supply.get(i) - junge.get(i) - jungeErwaschsene.get(i) >= Erwachsene.get(i)) {
              alteErwachsene.add(i+1, Erwachsene.get(i));
              if (supply.get(i)-junge.get(i)-jungeErwaschsene.get(i)-Erwachsene.get(i) >= alteErwachsene.get(i)) {
                Weise.add(i+1,alteErwachsene.get(i));
                junge.add(i+1, (jungeErwaschsene.get(i)/4+Erwachsene.get(i)/2+alteErwachsene.get(i)/3));
              } else {
                Weise.add(i+1,(supply.get(i)-junge.get(i)-jungeErwaschsene.get(i)-Erwachsene.get(i)));
                junge.add(i+1,(jungeErwaschsene.get(i)/4+Erwachsene.get(i)/2+(supply.get(i)-junge.get(i)-jungeErwaschsene.get(i)-Erwachsene.get(i))/3));
              }
            }  else {
              alteErwachsene.add(i+1,(supply.get(i) - junge.get(i) - jungeErwaschsene.get(i)));
              junge.add(i+1,(jungeErwaschsene.get(i)/4 + (supply.get(i)-junge.get(i)-jungeErwaschsene.get(i))/2));
              Weise.add(i+1, 0);
            }
          } else {
            Erwachsene.add(i+1, (supply.get(i) - junge.get(i)));
            junge.add(i+1,((supply.get(i)-junge.get(i))/4));
            alteErwachsene.add(i+1, 0);
            Weise.add(i+1, 0);
          }

        } else {
          jungeErwaschsene.add(i+1, supply.get(i));
          junge.add(i+1, 0);
          Erwachsene.add(i+1,0);
          alteErwachsene.add(i+1,0);
          Weise.add(i+1,0);
        }
      }
      System.out.println("Anzahl Jungtiere:\n" + junge.get(n1));
      System.out.println("Anzahl Junge Erwachsene:\n" + jungeErwaschsene.get(n1));
      System.out.println("Anzahl Erwachsene:\n" + Erwachsene.get(n1));
      System.out.println("Anzahl Alte Erwachsene:\n" + alteErwachsene.get(n1));
      System.out.println("Anzahl Weise:\n" + Weise.get(n1));
    }
  }
}