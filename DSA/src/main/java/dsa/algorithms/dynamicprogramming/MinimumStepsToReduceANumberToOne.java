package dsa.algorithms.dynamicprogramming;

import java.util.Calendar;

/**
 * Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 1.)
 * Subtract 1 from it. ( n = n - 1 ) , 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 ,
 * then n = n / 2 ) , 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3 ).
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to
 * 1
 *
 * @author ramsharma
 */
public class MinimumStepsToReduceANumberToOne implements DynamicProgramming {

    static int N = 70000000;
    static int steps = 0;
    static int[] memory = new int[N + 1];

    public static void main(String[] args) {

        // Recursion approach

        System.out.println(Calendar.getInstance().getTime());
        System.out.println("[RECURSION]");
        int minSteps = 0;
        // minSteps =reduce_to_1(N);
        System.out.format("\tMinimun number of steps to reduce %d to 1 = %d\n", N, minSteps);
        System.out.format("\tTotal steps tried = %d \n", steps);
        System.out.println("\t" + Calendar.getInstance().getTime());

        // Dynamic Programming approach - TOP to BOTTOM
        System.out.println("[DYNAMIC PROGRAMMING]");
        steps = 0;
        for (int i = 0; i < memory.length; i++)
            memory[i] = -1;
        int minStepsDP = 0;
        // minStepsDP = reduce_to_1_by_DP(N);
        System.out.format("\tMinimun number of steps to reduce %d to 1 = %d\n", N, minStepsDP);
        System.out.format("\tTotal steps tried = %d \n", steps);
        System.out.println("\t" + Calendar.getInstance().getTime());

        // Dynamic Programming approach - BOTTOM-UP
        System.out.println("[DYNAMIC PROGRAMMING]");
        steps = 0;
        int minStepsDP_2 = reduce_to_1_by_DP_Bottom_Up(N);
        System.out.format("\tMinimun number of steps to reduce %d to 1 = %d\n", N, minStepsDP_2);
        System.out.format("\tTotal steps tried = %d \n", steps);
        System.out.println("\t" + Calendar.getInstance().getTime());
    }

    // pure recursion
    private static int reduce_to_1(int N) {
        if (N == 1)
            return 0;

        // System.out.println(N);
        steps += 1;

        if (N % 2 == 0) {
            return 1 + Math.min(reduce_to_1(N / 2), reduce_to_1(N - 1));
        } else if (N % 3 == 0) {
            return 1 + Math.min(reduce_to_1(N / 3), reduce_to_1(N - 1));
        } else
            return 1 + reduce_to_1(N - 1);
    }

    // Top-Down dynamic programming
    // using above recursion in addition to memory
    private static int reduce_to_1_by_DP(int N) {

        if (memory[N] != -1)
            return memory[N];

        if (N <= 1)
            return memory[N] = 0;

        // System.out.println(N);
        steps += 1;

        if (N % 2 == 0) {
            memory[N] = 1 + Math.min(reduce_to_1(N / 2), reduce_to_1(N - 1));
            // return memory[N];
        } else if (N % 3 == 0) {
            memory[N] = 1 + Math.min(reduce_to_1(N / 3), reduce_to_1(N - 1));
            // return memory[N];
        } else {
            memory[N] = 1 + reduce_to_1(N - 1);
            // return memory[N];
        }

        return memory[N];
    }

    // bottom up Dynamic Programming approach
    private static int reduce_to_1_by_DP_Bottom_Up(int N) {

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {

            steps += 1;

            dp[i] = 1 + dp[i - 1];

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
        }

        return dp[N];
    }

}
