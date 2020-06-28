package problem.misc;

public class DuplicatesInArrayWithinKindices {

	public static boolean checkDuplicateWithinIndices(int[] arr, int indices) {

		for (int i = 0; i < (arr.length); i++) {
			return checkInThisArray(arr, (i + 1), (i + indices), arr[i]);
		}
		return false;
	}

	public static int checkDupsWithInImmediateNeighbours(int[] arr) {

		for (int i = 1; i < (arr.length - 1); i++) {
			if (arr[i] == arr[i + 1] || arr[i] == arr[i - 1])
				return arr[i];
		}
		return -1;
	}

	private static boolean checkInThisArray(int[] arr, int start, int last, int n) {

		for (int i = start; i < last; i++) {
			if (n == arr[i])
				return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 4, 5 };
		System.out.println(checkDupsWithInImmediateNeighbours(a));
		System.out.println(checkDuplicateWithinIndices(a, 3));

	}
}
