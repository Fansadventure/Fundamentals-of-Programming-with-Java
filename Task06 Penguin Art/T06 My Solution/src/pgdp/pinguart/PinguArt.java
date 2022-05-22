package pgdp.pinguart;

import static pgdp.MiniJava.*;

public class PinguArt {

	public static void main(String[] args) {
		// ask for input:
		int i=0;
		int [] arr = new int [8];
		while(i<8){
			arr[i] = readInt("Bitte geben Sie eine Pingu-Art-Zahl ein:");
			i++;
		}
		// draw the picture:
		write("+---[PinguArt]---+");
		for(i =0; i<arr.length;i++){
			int n = arr[i];
			int j=0;
			if(i%2==0) writeConsole("|");
			while(j<8){
				switch(n%10){
					case 0: writeConsole(" ");
							break;
					case 1: writeConsole("-");
							break;
					case 2: writeConsole("~");
							break;
					case 3: writeConsole("P");
							break;
				}
				n = n/10;
				j++;
			}
			if(i%2==1){
				writeConsole("|");
				writeLineConsole();
			}
		}
		write("+----------------+");
	}
}
