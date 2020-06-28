package problem.misc;

public class ProductArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };

		int arrayLeft[] = null;
		int arrayRight[] = null;

		int prodArr[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arrayLeft = new int[arr.length];
			arrayRight = new int[arr.length];

			// preparing left array
			for (int l = 0; l < i; l++) {
				arrayLeft[l] = arr[l];
			}

			// preparing right array
			for (int r = (i + 1), m = 0; r < arr.length; r++) {
				arrayRight[m++] = arr[r];
			}

			int pl = 1; // product left side

			int pr = 1; // product right side

			// multiply the elements of both arrays (left/right)
			if (arrayLeft != null) {
				for (int ll = 0; ll < arrayLeft.length; ll++) {
					pl *= arrayLeft[ll] != 0 ? arrayLeft[ll] : 1;
				}
			}
			if (arrayRight != null) {
				for (int rr = 0; rr < arrayRight.length; rr++) {
					pr *= arrayRight[rr] != 0 ? arrayRight[rr] : 1;
				}
			}

			prodArr[i] = (pl * pr);
		}

		for (int j = 0; j < prodArr.length; j++) {
			System.out.println(prodArr[j]);
		}
	}
}
