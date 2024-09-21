package dsa.algorithms.dynamicprogramming;

public class Knapsack implements DynamicProgramming {

    public static void main(String[] args) {

        int[] v = {60, 120, 10, 40}; // values per weight in same index order as weights
        int[] w = {10, 20, 30, 15}; // weights of the items in the same index order as values
        int W = 50; // total capacity in terms weight(w)
        int n = v.length; // # distinct items

        // Recursion
        int pickedUpValue = weightByRecursion(v, w, n, W);
        System.out.println("REC: " + pickedUpValue);

        // Dynamic Programming
        pickedUpValue = weightByDynamicProgramming(v, w, n, W);
        System.out.println("DP: " + pickedUpValue);
    }

    // dynamic programming
    private static int weightByDynamicProgramming(int[] v, int[] w, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][W];
    }

    // simple recursive solution
    private static int weightByRecursion(int[] v, int[] w, int n, int W) {
        if (n == 0 || W == 0)
            return 0;

        // weight exceeding capacity, not adding and move to next
        if (w[n - 1] > W)
            return weightByRecursion(v, w, n - 1, W);

        // max of already taken + next , next
        return max(v[n - 1] + weightByRecursion(v, w, n - 1, W - w[n - 1]),
                weightByRecursion(v, w, n - 1, W));
    }

    public static int max(final int a, final int b) {
        return a > b ? a : b;
    }

    public static int max(final int a, final int b, final int c) {
        return max(a, max(b, c));
    }
}