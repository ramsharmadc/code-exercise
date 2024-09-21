package practice.javalang8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    public static void main(String[] args) throws Exception {
        int i = 0;

        int m = 010;
        int j = 07;

        System.out.println(m);
        System.out.println(j);

        short s = 9;
        System.out.println(add(s, 6));

        try {
            float f = 3f;
            int x = (int) f;
            byte b = (byte) f;
            double d = (double) f;
            System.out.println(x + b + d);
            List<String> listOfWords = Arrays.asList("Hello", "Java");
            System.out.println(listOfWords);
            Collections.sort(listOfWords, Comparator.comparingInt(String::length));
            System.out.println(listOfWords);
        } catch (NumberFormatException e) {
            System.out.println("bad number");
        }
    }

    static int add(int a, int b) {
        return a + b;
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }
}
