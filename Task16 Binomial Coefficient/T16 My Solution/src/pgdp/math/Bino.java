package pgdp.math;

import static pgdp.MiniJava.*;
public class Bino {
    public static int bino(int n, int k) {
        // TODO
        int result =0;
        if(k==n ||k==0) result =1;
        else result = bino(n-1, k-1) + bino(n-1,k);
        return result;
    }
    
    public static void main(String[] args) {
        int n = readInt("n:");
        int k = readInt("k:");
        if(n>= k && k>=0) write(bino(n,k));
        else write("Invalide Eingabe");
    }
}
