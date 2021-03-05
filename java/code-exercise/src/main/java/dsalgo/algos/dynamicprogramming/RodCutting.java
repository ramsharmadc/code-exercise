/**
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that
 * maximizes product of lengths of all parts. You must make at least one cut. Assume that the length
 * of rope is more than 2 meters. Examples: Input: n = 2 Output: 1 (Maximum obtainable product is
 * 1*1) Input: n = 3 Output: 2 (Maximum obtainable product is 1*2) Input: n = 4 Output: 4 (Maximum
 * obtainable product is 2*2) Input: n = 5 Output: 6 (Maximum obtainable product is 2*3) Input: n =
 * 10 Output: 36 (Maximum obtainable product is 3*3*4)
 */

package dsalgo.algos.dynamicprogramming;

public class RodCutting implements DynamicProgramming {

    public static int findMaxProd(final int rod_length) {
        // Base cases
        if (rod_length < 2) {
            // System.out.println("Base Case: length=" + rod_length);
            return 0;
        }

        // Make a cut at different places and take the maximum of all
        int max_val = 0;

        for (int cut = 1; cut < rod_length; cut++) {
            // System.out.println("Max Val now=" + max_val + " and rod_length=" +
            // rod_length);
            max_val = max(max_val, cut * (rod_length - cut), findMaxProd(rod_length - cut) * cut);
        }
        // Return the maximum of all values
        // System.out.println("Max Val Return=" + max_val);
        return max_val;
    }

    public static void main(final String[] args) {
        final int rod_length = 5;
        System.out.println(findMaxProd(rod_length));
    }

    private static int max(final int a, final int b) {
        return a > b ? a : b;
    }

    private static int max(final int a, final int b, final int c) {
        return max(a, max(b, c));
    }
}
