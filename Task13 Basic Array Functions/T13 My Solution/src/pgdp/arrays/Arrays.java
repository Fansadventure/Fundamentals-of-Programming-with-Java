package pgdp.arrays;

import static pgdp.MiniJava.*;

public class Arrays {
    public static void print(int[] feld) {
        // TODO
        if(feld.length==0) write("{}");
        for (int i=0; i<feld.length;i++){
            if(i ==0) writeConsole("{"+feld[i]);
            else writeConsole(", "+feld[i]);
            if(i == feld.length-1) writeLineConsole("}");
        }
    }

    public static void minUndMax(int[] feld) {
        // TODO
        int min = feld[0];
        int max = feld[0];
        for(int i=0; i<feld.length;i++){
            if(min > feld[i]) min = feld[i];
            if(max < feld[i]) max = feld[i];
        }
        write("Minimum = "+min +", Maximum = "+max);
    }

    public static int[] invertieren(int[] feld) {
        // TODO
        int [] b = new int [feld.length];
        int count =0;
        for(int i= feld.length-1;i>=0;i--){
            b[count] = feld[i];
            count ++;
        }
        return b;
    }

    public static int[] schneiden(int[] feld, int laenge) {
        // TODO
        int [] arr = new int [laenge];
        for(int i =0; i<laenge;i++){
            if(i<feld.length) arr[i]=feld[i];
            else arr[i] =0;
        }
        return arr;
    }

    public static int[] linearisieren(int[][] feld) {
        // TODO
        int n=0;
        for(int i=0; i<feld.length;i++){
                n += feld[i].length;
        }
        int [] arr = new int [n];
        int count =0;
        for(int i=0;i<feld.length;i++){
            for(int j=0; j<feld[i].length;j++){
                arr[count] = feld[i][j];
                count ++;
            }
        }
        return arr;
    }


//    public static void main (String [] args){
////        int [] arr = {1,2,3,4};
//        int [][] arr = {{1,2,3,4},{5,6,7},{88,66}};
////        int [] arr = new int [0];
////        print(arr);
////        minUndMax(arr);
////        print(invertieren(arr));
////        print(schneiden(arr,3));
////        print(schneiden(arr,6));
//        print(linearisieren(arr));
//    }
}
