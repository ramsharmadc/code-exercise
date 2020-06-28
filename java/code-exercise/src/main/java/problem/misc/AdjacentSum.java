package problem.misc;

public class AdjacentSum {
	private static final int ADJACENT = 3;
	private static int[] input = new int[] { 5, 6, 9, 2, 8, 7, 6 };
	private static int start_index = -1;

	public static void main(final String args[]) {
		int sum = 0;
		int max_sum = 0;

		for (int i = 0; i < ((input.length - ADJACENT) + 1); i++) {
			if (i == 0) {
				sum = input[i] + input[i + 1] + input[i + 2];
				max_sum = sum;
				start_index = i;
			} else {
				sum = (sum - input[i - 1]) + input[i + 2];
				if (sum > max_sum) {
					max_sum = sum;
					start_index = i;
				}
			}
			System.out.println("i : " + i + ", sum : " + sum);
		}
		System.out.println("sum : " + sum + ", index : " + start_index);
	}
}