package dsa.algos.dynamicprogramming;

public class CollectMaximumCandies implements DynamicProgramming {
	public static void main(String[] args) {
		int[][] A = new int[2][2];
		A[0][0] = 2;
		A[0][1] = 20;
		A[1][0] = 12;
		A[1][1] = 17;
		int a = findMaxCandiesByRecursion(A, 0, 0);
		System.out.println("REC: " + a);
		a = findMaxCandiesByDynamicProgramming(A, 0, 0);
		System.out.println("DP: " + a);
	}

	// brute force recursion
	private static int findMaxCandiesByRecursion(int[][] A, int i, int j) {
		if (i > 1 || j > 1)
			return 0; // row and column limit reached
		return A[i][j] +
				max(findMaxCandiesByRecursion(A, i, j + 1),
						findMaxCandiesByRecursion(A, i + 1, j));
	}

	// dynamic programming
	private static int findMaxCandiesByDynamicProgramming(int[][] A, int i, int j) {
		int[][] dp = new int[2][2];
		for (int k = 0; k < A.length; k++) {
			for (int p = 0; p < A[k].length; p++) {
				if (k == 0 || p == 0) {
					dp[k][p] = A[k][p];
				} else {
					dp[k][p] = A[k][p] + max(dp[k][p], dp[k - 1][p], dp[k][p - 1]);
				}
			}
		}
		return dp[1][1];
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int max(int a, int b, int c) {
		return max(max(a, b), c);
	}
}
