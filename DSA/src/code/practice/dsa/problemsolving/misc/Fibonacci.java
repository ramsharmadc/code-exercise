package dsa.problemsolving.misc;

import dsa.algorithms.dynamicprogramming.FibonacciSeries;

import java.math.BigInteger;

/**
 * Program to find Fibonacci series of a given no. Example Input - any integer Output - 1 1 2 3 5 8
 * 13 21 ...
 */

public class Fibonacci {

    public static void main(String[] args) {
        // user input
        /*
         * System.out.println("Enter the nth term:");
         *
         * Scanner scan_it = new Scanner(System.in); int n = scan_it.nextInt();
         */

        System.out.println("***** Fibonacci Series *****");
        System.out.println("By iteration..");
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.fibIter(40));

        System.out.println("By recursion..");
        System.out.println(fb.fibRec(40));

        System.out.println("By dynamic programming..");
        System.out.println(new FibonacciSeries(40).fibonacciByDP(40));
    }

    public String fibIter(int num) {
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("1");
        BigInteger f3 = new BigInteger("0");
        if (num == 0)
            return "0";
        if (num == 1)
            return "1";

        for (int i = 1; i <= num; i++) {
            f1 = f2;
            f2 = f3;
            f3 = f1.add(f2);
        }
        return f3.toString();
    }

    public BigInteger fibRec(int num) {
        if (num == 0)
            return new BigInteger("0");
        else if (num == 1)
            return new BigInteger("1");
        else
            return fibRec(num - 1).add(fibRec(num - 2));
    }
}
