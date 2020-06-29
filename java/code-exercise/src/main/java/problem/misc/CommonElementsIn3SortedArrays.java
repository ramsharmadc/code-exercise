package problem.misc;

import dsa.algos.sorting.Quicksort;
import util.CommonUtils;

public class CommonElementsIn3SortedArrays {

	private static int[] a = { 5, 3, 8, 2, 9, 1 };
	private static int[] b = { 15, 13, 5, 12, 19, 11 };
	private static int[] c = { 25, 23, 5, 22, 29, 21 };

	public static void main(final String[] args) {

		Quicksort.quickSort(a, 0, (a.length - 1));
		Quicksort.quickSort(b, 0, (a.length - 1));
		Quicksort.quickSort(c, 0, (a.length - 1));

		try {
			System.out.println(CommonUtils.arrayAsString(a));
			System.out.println(CommonUtils.arrayAsString(b));
			System.out.println(CommonUtils.arrayAsString(c));

			findCommonElements(a, b, c);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void findCommonElements(final int[] a, final int[] b, final int[] c) {

		int i = 0;
		int j = 0;
		int k = 0;

		final int lenOfA = a.length;
		final int lenOfB = b.length;
		final int lenOfC = c.length;

		while ((i < lenOfA) && (j < lenOfB) && (k < lenOfC)) {

			if ((a[i] == b[j]) && (b[j] == c[k])) {
				System.out.println(a[i]);
				i++;
				j++;
				k++;
			} else if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else {
				k++;
			}
		}
	}
}
