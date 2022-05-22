package pgdp.math;

import static pgdp.MiniJava.*;

public class ThreeAndSeven {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");
		int i = 0;
		int sum = 0;
		if(n<0) {write("Fehler: n>=0 erwartet!");
		} else {
			while (i <= n) {
				if (i % 3 == 0 || i % 7 == 0) sum += i;
				i++;
			}
			write(sum);
		}
	}
}
