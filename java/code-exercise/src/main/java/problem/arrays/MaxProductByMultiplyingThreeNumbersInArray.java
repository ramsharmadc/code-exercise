package problem.arrays;

public class MaxProductByMultiplyingThreeNumbersInArray {

	/**
	 * A unsorted array of integers is given; you need to find the max product
	 * formed my multiplying three numbers. (You cannot sort the array, watch out
	 * when there are negative numbers)
	 */

	public static void main(String[] args) {
		System.out.println("Checking max product by multiplying 3 numbers..");
		int[] a = new int[] { 3, 6, 8, 2, 12, 4 };
		int maxProduct = findMaxProduct(a);
		System.out.println("Max Product == " + maxProduct);
	}

	private static int findMaxProduct(int[] args) {

		int firstMax = 0;
		int secondMax = 0;
		int thirdMax = 0;

		for (int i = 0; i < args.length; i++) {

			System.out.println("Checking for " + args[i]);

			if (firstMax < args[i]) {
				firstMax = args[i];
				System.out.println("First max == " + thirdMax);

				if (secondMax < args[i]) {
					secondMax = args[i];
					System.out.println("Second max == " + secondMax);

					if (thirdMax < args[i]) {
						thirdMax = args[i];
						System.out.println("Third max == " + thirdMax);
					}
				}
			}
		}

		System.out.println("First Max, Second Max, Third max " + firstMax + " " + secondMax + " " + thirdMax);
		return firstMax * secondMax * thirdMax;
	}
}
