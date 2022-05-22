package pgdp.math;

import static pgdp.MiniJava.*;

public class PrimeFactors {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");

		if (n <= 1) {
			writeLineConsole("Fehler: n>1 erwartet!");
		}else{
			while(n!=1){
				int k = 2;
				while(k<=n){
					if(n%k==0) {
						writeConsole(k);
						if(k!=n) writeConsole(" ");
						else writeLineConsole();
						break;
					}else{k++;}
				}
				n = n/k;
			}
		}
	}
}
