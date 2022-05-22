package pgdp.pinguracing;

import static pgdp.MiniJava.*; //Diesen Import nicht löschen! Do not delete this import!

public class PinguRacing {
    public static void main(String[] args) {
        // Ask for inputs:
        int PositionA = readInt("Alan Startposition:");
        int PositionB = readInt("Bjarne Startposition:");
        int Duration = readInt("Renndauer:");
        while(Duration<0){
            Duration = readInt("Bitte keine negative Zahl eingeben:");
        }
        // Calculate Position & Speed:
        int i = 0;
        int Speed_A = 0;
        int Speed_B = 0;
        while(i < Duration){
            // first half:
            if(i<Duration/2){
                // Calculate speed for A:
                if(PositionA%10 == 4){
                    Speed_A = Speed_A/2 + 1;
                }else{
                    Speed_A = Speed_A + 7;
                }
                // Calculate speed for B:
                if(PositionB % 13 == 0){
                    Speed_B = Speed_B *2 +1;
                }else{
                    Speed_B = Speed_B +3;
                }
            }else{ // second half:
                // calculate speed for A:
                if(i==3*Duration/5 || i==4*Duration/5){
                    Speed_A = Speed_A / 4;
                }else{
                    Speed_A = Speed_A +1;
                }
                // calculate speed for B:
                if(i>= Duration-13){
                    Speed_B = Speed_B /2;
                }else{
                    Speed_B = Speed_B -1;
                }
            }
            // check if the speed in the range [0,128]:
            if(Speed_A>128) Speed_A = 128;
            if(Speed_A<0) Speed_A =0;
            if(Speed_B>128) Speed_B = 128;
            if(Speed_B<0) Speed_B =0;
            // Calculate positions for both:
            PositionA += Speed_A;
            PositionB += Speed_B;
            // print the results:
            write("t = " +i);
            write("Alan Position = "+PositionA +"; " + "Geschwindigkeit = " + Speed_A);
            write("Bjarne Position = "+PositionB +"; " + "Geschwindigkeit = " + Speed_B);
            i++;
        }
        // print the final winner:
        if(PositionA>PositionB) write("Alan gewinnt!");
        if(PositionA<PositionB) write("Bjarne gewinnt!");
        if(PositionA==PositionB) write("Unentschieden!");
    }
}
