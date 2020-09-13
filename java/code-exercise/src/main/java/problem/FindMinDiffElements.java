package problem;

public class FindMinDiffElements {

	public void findNumbers(int[] a, int n) {

		findSum(a, n, a.length, 0);
	}

	public int findSum(int[] a, int sum, int i, int previousSum) {

		if (i <= 2 || i > a.length) {
			return 0;
		} else {
			for (int k = 0; k < i - 1; k++) {
				if ((previousSum = sum - sum(a[k], findSum(a, sum, k + 1, previousSum),
						findSum(a, sum, k + 2, previousSum))) <= previousSum) {
					print(k, k + 1, k + 2, a);
					return previousSum;
				} else
					return findSum(a, sum, k, previousSum);
			}
		}
		return findSum(a, sum, i + 1, previousSum);
	}

	void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public int sum(int a, int b, int c) {
		return a + b + c;
	}

	public void print(int i, int j, int k, int[] a) {
		System.out.println(a[i]);
		System.out.println(a[j]);
		System.out.println(a[k]);
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 2, 5 };
		int sum = 20;
		new FindMinDiffElements().findNumbers(a, sum);
	}
}
