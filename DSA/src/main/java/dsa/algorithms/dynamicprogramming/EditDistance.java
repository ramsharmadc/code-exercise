package dsa.algorithms.dynamicprogramming;

public class EditDistance implements DynamicProgramming {

    public static void main(String[] args) {
        String s1 = "mother";
        String s2 = "father";

        int d = new EditDistance().editDistance(s1, s2, s1.length(), s2.length());
        System.out.println("REC:: Edit distance b/w " + s1 + " and " + s2 + " is: " + d);

        d = new EditDistance().editDistanceByDP(s1, s2, s1.length(), s2.length());
        System.out.println("DP:: Edit distance b/w " + s1 + " and " + s2 + " is: " + d);
    }

    // recursive/natural/intuitive approach
    public int editDistance(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return editDistance(s1, s2, (m - 1), (n - 1));
        else
            return 1 + min(editDistance(s1, s2, m, (n - 1)), // delete
                    editDistance(s1, s2, (m - 1), n), // inserts
                    editDistance(s1, s2, (m - 1), (n - 1))); // change
    }

    // dynamic programming ( !!--clever minds--!! )
    public int editDistanceByDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j; // need so many inserts
                else if (j == 0)
                    dp[i][j] = i; // need so many deletes
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1]; // need replacement
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    public int min(int x, int y) {
        return (x < y) ? x : y;
    }

    public int min(int x, int y, int z) {
        return min(x, min(y, z));
    }
}
