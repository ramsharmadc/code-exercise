package problem.misc;

import util.CommonUtils;

/**
 * Given a Integer, find the maximum number that can be formed from the digits.
 * Input : 8754365 output : 8765543
 * 
 * @author ramsh
 */
public class MaxNumberFromDigits {
	public static void main(String[] args) throws Exception {
		int[] a = new int[10];
		int n = 8754365;

		System.out.println(n);
		System.out.println(CommonUtils.arrayAsString(a));

		while (n != 0) {
			int m = n % 10;
			n = n / 10;
			// System.out.println(m ) ;
			// System.out.println(n ) ;
			a[9 - m] = a[9 - m] + 1;
		}

		System.out.println(CommonUtils.arrayAsString(a));

		for (int g = 0; g < a.length; g++) {
			if (a[g] != 0) {
				for (int l = 0; l < a[g]; l++) {
					System.out.print(9 - g);
				}
			}
		}
	}
}
