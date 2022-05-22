package pgdp.math;
import static pgdp.MiniJava.*;
public class Meiern {
	public static void main(String[] args) {
		int activeplayer =2;
		boolean bigger= true;
		int a,b, number;
		int [] arr = new int [2]; // store the old and current number

		while(bigger){
			// change active player: 1 for player and 2 for computer
			if(activeplayer==1) activeplayer =2;
			else activeplayer =1;
			// dice:
			a = dice();
			b = dice();
			if(a>=b) number = a*10+b;
			else number = b*10+a;
			arr[1] = number;
			if(activeplayer==1) write("Der Spieler würfelt: "+number);
			else write("Der Computer würfelt: "+number);
			// compare the current number with the old number:
			if(arr[1]== 21){
				write("Meier!");
				if(activeplayer==1) write("Der Spieler gewinnt!");
				if(activeplayer==2) write("Der Computer gewinnt!");
				bigger = false;
			}else if(arr[1]%10 == arr[1]/10 && arr[0]%10 != arr[0]/10) {
				write("Überboten!");
				arr[0] = arr[1];
			}else if(arr[1]%10 != arr[1]/10 && arr[0]%10 == arr[0]/10 && arr[0]!=0){
				write("Nicht überboten!");
				if(activeplayer==1) write("Der Computer gewinnt!");
				if(activeplayer==2) write("Der Spieler gewinnt!");
				bigger = false;
			}else{
				if(arr[1]>arr[0]){
					write("Überboten!");
					arr[0] = arr[1];
				}else{
					write("Nicht überboten!");
					if(activeplayer==1) write("Der Computer gewinnt!");
					if(activeplayer==2) write("Der Spieler gewinnt!");
					bigger = false;
				}
			}
		}
	}
}
