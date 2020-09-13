package problem.misc;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * find all set of elements in an array with sum equal to k(given)
 */
public class SumOfSetEqualsK {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 };
		// Integer[]a = {8,9,2,3,4,7};
		Arrays.sort(a);
		final int sum = 50;

		final ArrayList<Integer[]> arr = setOfSumEqualsK(a, sum);

		for (int p = 0; p < arr.size(); p++) {
			try {
				System.out.println(CommonUtils.arrayAsString(a));
			} catch (final Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Integer[]> setOfSumEqualsK(final int[] a, final int sum) {

		final ArrayList<Integer[]> arr = new ArrayList<>();

		for (int m = a.length; m > 0; m--) {

			final Stack<Integer> stk = new Stack<>();

			int tempSum = 0;
			int i = 0;

			final Integer[] tempArr = new Integer[a.length];

			for (int j = 0; j < m; j++) {
				stk.push(a[j]);
			}

			while (!stk.isEmpty()) {
				final int n = stk.pop();
				tempArr[i++] = n;
				tempSum += n;

				if (tempSum == sum) {
					arr.add(tempArr);
					break;

				} else if (tempSum < sum) {
					continue;
				} else if (tempSum > sum) {
					tempSum -= n;
					tempArr[i--] = 0;

					continue;
				}
			}
		}
		return arr;
	}

}
