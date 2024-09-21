package dsa.problemsolving.misc;

/**
 * Find the two elements that have the smallest difference in a given array
 */
public class FindTwoElementsWithMinDifference {

    public static void main(String[] args) {

        int[] a = {3, 2, 6, 9, 12};

        int min = Integer.MAX_VALUE;

        // Brute-Force approach using 2 for loops
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                final int abs = Math.abs(a[i] - a[j]);
                if (min > abs) {
                    min = abs;
                }
            }
        }

        System.out.println("minimum is " + min);
    }
}
