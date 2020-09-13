package problem.misc;

public class FindMajorityElement {

	public static void main(String[] args) {
		int[] a = { 2, 1, 2, 3, 3, 3, 4, 6, 4, 3, 3, 3, 3 };
		int majorElement = -1;
		double tc = Math.floor(a.length / 2);
		for (int i = 0; i < a.length; i++) {
			int ocr = findOccurrences(a[i], a);
			if (ocr > tc) {
				majorElement = majorElement < ocr ? a[i] : majorElement;
			}
		}
		System.out.println(majorElement);
	}

	private static int findOccurrences(int n, int[] a) {
		int c = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] == n)
				c += 1;

		return c;
	}
}
