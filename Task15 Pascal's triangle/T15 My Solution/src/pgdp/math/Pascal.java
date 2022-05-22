package pgdp.math;
import static pgdp.MiniJava.*;
class Pascal {
    public static int[][] pascalTriangle(int n) {
        // TODO
        int [][] arr = new int [n][];
        for(int i=0;i<n;i++){
            arr[i] = new int[i+1];
            for(int j=0;j<i+1;j++){
                if(j==0||j==i) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // TODO
        int n = readInt("Gib die Zeilenzahl an:");
        int [][] arr = pascalTriangle(n);
        for(int i=0;i<arr.length;i++){
            writeConsole("n="+i);
            for(int j=0;j<arr[i].length;j++){
                writeConsole("\t"+ arr[i][j]);
            }
            write("");
        }
    }
}