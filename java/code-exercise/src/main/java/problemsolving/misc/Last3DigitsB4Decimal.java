package problemsolving.misc;

import java.util.Scanner;

/*
 * Problem //In this problem, you have to find the last three digits before the decimal point for
 * the number (3 + root(5))n. //For example, when n = 5, (3 + root(5))5 = 3935.73982... The answer
 * is 935. //For n = 2, (3 + root(5))2 = 27.4164079... The answer is 027.
 */

public class Last3DigitsB4Decimal {

    private static void last3Digits(int n) {
        // System.out.println(ReverseNumber.reverse(n));
        // System.out.println(n);
        int num = 0;
        int rem = n / 10;
        while (rem != 0) {
            num += num * 10;
        } // int n1 =
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int x = 3;
        int y = 26;
        double rootOfY = Math.sqrt(y);
        System.out.println("Give n :: ");
        // int n = Integer.valueOf(scnr.next());
        Double finalNumber = (x + rootOfY) * Double.parseDouble(scnr.next());
        System.out.println(finalNumber);
        last3Digits(finalNumber.intValue());
        scnr.close();
    }
}
