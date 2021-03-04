package dsa.algos.dynamicprogramming;

public class EggDroppingProblem implements DynamicProgramming {

    private static final int floors = 10;
    private static final int eggs = 2;
    private static final int[][] dp = new int[eggs + 1][floors + 1];

    public static void main(String[] args) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int minFloor = dropAnEgg(floors, eggs);
        System.out.format("Minimum number of attempts = %d", minFloor);
    }

    private static int dropAnEgg(int f, int e) {
        if (f <= 1)
            return f;
        if (e == 1)
            return f;
        if (dp[e][f] != -1)
            return dp[e][f];
        System.out.format("Attempting floor %d with egg %d \n", f, e);
        // return Math.min(i, Math.max(findMinimumFloor(f - 1, e - 1, i + 1),
        // findMinimumFloor(f + 1, e, i + 1)));
        dp[e][f] = 9999;
        // k = number of attempts
        for (int k = 1; k <= f; k++) {
            dp[e][k] = Math.min(dp[e][k], Math.max(dropAnEgg(f - 1, e - 1), dropAnEgg(f - k, e)));
        }
        return dp[e][f];
    }

    private static void dropAnEggByDP() {
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int i = 0; i < eggs + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 1; i < floors + 1; i++) {
            dp[1][i] = i;
        }
    }
}
