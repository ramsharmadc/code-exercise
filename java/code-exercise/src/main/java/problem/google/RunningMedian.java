package problem.google;

public class RunningMedian {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		double[] d = findRunningMedian(a);
	}

	private static double[] findRunningMedian(int[] a) {

		double[] d = new double[a.length];

		for (int i = 0; i < a.length; i++) {
			int[] t = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				t[j] = a[j];
			}
			d[i] = calculateMedian(t);
			System.out.println(d[i]);
		}

		return d;
	}

	static double calculateMedian(int[] a) {
		int len = a.length;

		if (len == 1)
			return a[0];
		if (len == 2)
			return (double) (a[0] + a[1]) / 2;
		if (len == 3)
			return a[1];
		else if (len % 2 == 0) {
			double d1 = (double) (a[(int) (len - 1) / 2] + a[(int) len / 2]) / 2;
			return d1;
		} else {
			double d1 = (double) a[len - 1]/2;
			return d1;
		}
	}

}
