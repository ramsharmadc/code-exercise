package dsa.algorithms.dynamicprogramming;

public class CoinChange implements DynamicProgramming {

    int sum = 250; // total change(sum)required
    int[] avialableCoins = {1, 5, 10, 25, 100}; // coins denomination available

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        try {
            int cr = c.coinChangeRecursion(c.avialableCoins, c.sum, c.avialableCoins.length - 1);
            System.out.println("By Recursion :: " + cr);

            int cdp = c.coinChangeDP(c.avialableCoins, c.sum);
            System.out.println("By DP :: " + cdp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int max(final int a, final int b) {
        return a > b ? a : b;
    }

    public static int max(final int a, final int b, final int c) {
        return max(a, max(b, c));
    }

    public static int min(final int a, final int b) {
        return a > b ? b : a;
    }

    public static int min(final int a, final int b, final int c) {
        return min(a, min(b, c));
    }

    // BankAccountTransaction by recursion
    int coinChangeRecursion(int[] coins, int sum, int len) {
        if (len < 0)
            return 0;
        else if (sum < 0)
            return 0;
        else if (sum == 0)
            return 1;
        else if (coins[len] == sum)
            return 1;
        else if (coins[len] < sum)
            return 1 + coinChangeRecursion(coins, sum - coins[len], len);
        else
            return coinChangeRecursion(coins, sum, len - 1);
    }

    int coinChangeDP(int[] coins, int sum) {
        int[][] dp = new int[coins[coins.length - 1] + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j < sum) {
                    dp[i][j] = Math.floorDiv(j, i);
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - (i * dp[i][j - 1])];
                }
            }
        }

        return dp[coins[coins.length - 1]][sum];
    }
}
