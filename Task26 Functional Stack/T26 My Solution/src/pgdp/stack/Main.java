package pgdp.stack;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Happy");
        arr.add("New");
        arr.add("Year!");

        Stack<String> stack = new Stack<>();
        stack.addAll(arr);

        int length = sum(stack);
        System.out.println("Sum of the length: " + length);

    }
    // Anonymer Klasse
    public static int sum(Stack<String> s) {
        return s.sum(new Counter<String>() {
            @Override
            public int toNumber(String o) {
                return o.length();
            }
        });
    }

    // lambda
    public static int sum2(Stack<String> s) {
        return s.sum(o -> o.length());
    }
    // method reference
    public static int sum3(Stack<String> s) {
        return s.sum(String::length);
    }

    // normal class
    public static class sumOfLength implements Counter<String> {
        @Override
        public int toNumber(String o) {
            return o.length();
        }
    }
    public static int sum4(Stack<String> s) {
        return s.sum(new sumOfLength());
    }
}
