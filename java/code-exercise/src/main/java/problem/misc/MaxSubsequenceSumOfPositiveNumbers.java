package problem.misc;

public class MaxSubsequenceSumOfPositiveNumbers {
	private static int getMaxSum(int[] a, int length) {
		int maxSumSoFar = 0, maxSumIntermediate = 0;
		for (int i = 0; i < length; i++) {
			if (a[i] > 0) { // adding negative will reduce the sum, so don't add
				maxSumIntermediate += a[i];
				maxSumSoFar = max(maxSumSoFar, maxSumIntermediate);
			} else {
				maxSumSoFar = max(maxSumSoFar, maxSumIntermediate);
				maxSumIntermediate = 0;
			}
		}

		return maxSumSoFar;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 2, -1, 4, 5, 6, -2, 9, 8, -1, 2, 6, 32 };
		int maxSum = getMaxSum(a, a.length);
		System.out.println(maxSum);
	}

	public static int max(int n1, int n2) {
		return (n1 > n2) ? n1 : n2;
	}
}
