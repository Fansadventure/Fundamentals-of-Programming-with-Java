package pgdp.crypto;

import static pgdp.MiniJava.*;

public class CaesarChiffre {
    public static void main(String[] args) {
        String inputText = readString("Bitte Text eingeben:");
        int key = readInt("Bitte Schlüssel eingeben:");
        char[] input = toArray(inputText);
        write(encrypt(input,key));
        
        // TODO output

    }
    public static char[] toArray(String input){
        char [] result = new char[input.length()];
        for(int i=0;i<input.length();i++)
            result[i] = input.charAt(i);
        return result;
    }
    public static String encrypt(char[] input, int key){
        if(key>=0)
            key = key%26;
        else
            key = key%26 +26;
        char[] result = new char[input.length];
        for(int i=0;i<input.length;i++){
            if(input[i]>='a' && input[i]<='z'){
                result[i]= (char) ((input[i]-'a'+key)%26 +'a');
            }else if(input[i]>='A' && input[i]<='Z'){
                result[i]= (char) ((input[i]-'A'+key)%26 +'A');
            }else
                result[i] = input[i];
        }
        return new String(result);
    }
}
