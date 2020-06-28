package problem.misc;

import problem.util.CommonUtils;

public class RearrangeNegativeAndPositiveInArray {

	static int a[] = { 1, 2, -1, 3, -2, 4, 5, -3, -4, 6, -5, -6 };

	public static void main(final String[] args) {

		try {

			System.out.println(CommonUtils.arrayAsString(a));
			reArrangeNegativeAndPositiveNumbers(a);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void reArrangeNegativeAndPositiveNumbers(final int[] a) throws Exception {

		int right = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] < 0) {
				right = i;

				while (a[i] > 0) {
					i++;
				}

				final int temp = a[i];
				a[i] = a[right];
				a[right] = temp;
			}

			i++;
		}

		System.out.println(CommonUtils.arrayAsString(a));
	}
}
