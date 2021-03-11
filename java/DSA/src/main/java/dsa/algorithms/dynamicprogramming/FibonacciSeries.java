package dsa.algorithms.dynamicprogramming;

public class FibonacciSeries implements DynamicProgramming {

    private final int[] t;

    public FibonacciSeries(int n) {
        t = new int[n];
        t[0] = 1;
        t[1] = 1;
    }

    public static void main(String[] args) {
        FibonacciSeries fbPrg = new FibonacciSeries(10);
        int n = fbPrg.fibonacciByDP(10);
        System.out.println(n);

        // fbPrg.fibonacciByDPRec(fbPrg.t.length);
        // System.out.println(fbPrg.t[10]);
    }

    // DP -> recursion + memoization
    public int fibonacciByDPRec(int n) {
        if (n > t.length - 1)
            return fibonacciByDP(n - 1);
        if (n < 0 || t[n] != 0)
            return t[n];
        return (t[n] = fibonacciByDP(n - 1) + fibonacciByDP(n - 2));
    }

    public int fibonacciByDP(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}
