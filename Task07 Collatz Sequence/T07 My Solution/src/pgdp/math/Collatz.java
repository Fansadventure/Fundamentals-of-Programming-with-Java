package pgdp.math;

import static pgdp.MiniJava.*;

public class Collatz {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");

		if (n <= 0) {
			writeLineConsole("Fehler: n>0 erwartet!");
		}else{
			int length;
			int count =0;
			writeConsole(n);
			while(n!=1){
				writeConsole(" ");
				if(n%2==0) n=n/2;
				else n = 3*n+1;
				writeConsole(n);
				count ++;
			}
 			length = count +1;
			writeLineConsole();
			writeLineConsole("Länge: "+length);
		}
	}
}
