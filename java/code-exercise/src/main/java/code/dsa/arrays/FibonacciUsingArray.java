package code.dsa.arrays;

import java.math.BigInteger;

public class FibonacciUsingArray {
    public static void main(String[] args) {
        BigInteger[] res = new BigInteger[100000];
        int n = 80000;
        BigInteger fibAtN = fibonacci(n, res);
        System.out.println("Fibonacci number at " + n + " is " + fibAtN);
    }

    public static BigInteger fibonacci(int n, BigInteger[] res) {
        for (int i = 0; i < n; i++) {
            if (i == 0) res[i] = BigInteger.ZERO;
            else if (i == 1) res[i] = BigInteger.ONE;
            else res[i] = res[i - 1].add(res[i - 2]);
            System.out.println("i = " + i + ", Fin(" + (i + 1) + ") is " + res[i]);
        }
        return res[n - 1];
    }
}
