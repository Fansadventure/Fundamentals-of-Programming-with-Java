package pgdp.math;

import static pgdp.MiniJava.*;

public class RabbitPopulation {
	public static void main(String[] args) {
		int  n = readInt("Bitte Zahl eingeben:");
		int sum;
		int [] arr = new int [3];
		arr[0] = 1;
		int month = 1;
		while(month < n){
			int i =0;
			int k=0;
			while(i<3){
				k += arr[i];
				i++;
			}
			arr[2] = arr[1];
			arr[1] = arr[0];
			arr[0] = k;
			month++;
		}
		sum = arr[0] +arr[1] +arr[2];
		write(sum);
	}
}