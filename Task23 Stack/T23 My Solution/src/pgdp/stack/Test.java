package pgdp.stack;

public class Test {
    public static void main(String [] args){
//        String s1 = "([])";
//        String s2 = "([])(){([])}";
        String s3 = "([)]";
//        System.out.println("String 1: " + BracketChecker.checkBrackets(s1));
//        System.out.println("String 2: " + BracketChecker.checkBrackets(s2));
        boolean r = BracketChecker.checkBrackets(s3);
        System.out.println("String 3: " + BracketChecker.checkBrackets(s3));
    }
}
