package pgdp.math;

import static pgdp.MiniJava.*;

public class Fib {
	public static void main(String[] args) {
		int i = readInt();

		long start, end, result;

		start = System.nanoTime();
		result = fibRec(i);
		end = System.nanoTime();
		System.out.println("Rec: " + result + " in " + (end - start) + "ns");

		start = System.nanoTime();
		result = fibMemo(i);
		end = System.nanoTime();
		System.out.println("Memo: " + result + " in " + (end - start) + "ns");

		start = System.nanoTime();
		result = fibIt(i);
		end = System.nanoTime();
		System.out.println("It: " + result + " in " + (end - start) + "ns");
	}

	public static long fibRec(int i) {
		if(i==0) return 0;
		if(i==1) return 1;
		return fibRec(i-2 ) + fibRec(i-1);
	}

	public static long fibMemo(int i) {
		long [] a= new long[i+1];
		for(int k=0;k<i+1;k++){
			if(k==0 || k==1) a[k] =k;
			else a[k] = a[k-2] + a[k-1];
		}
		return a[i];
	}

	public static long fibIt(int i) {
		if(i==0) return 0;
		if(i==1) return 1;
		long result = 0;
		long a=0;
		long b=1;
		for(int j =1; j<i;j++){
			result = a+b;
			a = b;
			b = result;
		}
		return result;
	}
}
