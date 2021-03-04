package dsa.tree;

/**
 * You are given a list "A" containing "n" integers. It is given that there exists at least one
 * subset in "A" such that doing a binary OR operation of all the elements gives a value "X". Find
 * the minimum number of elements that should be removed from A such that no such subset exists.
 *
 * @author ramsharma
 */

public class Solution2 {

    static int[] A = {2, 3, 4, 5, 6};
    static int X = 38;

    // test program
    public static void main(String[] args) {

        findAndRemoveSubset(X);

        System.out.println(A);
    }

    private static void findAndRemoveSubset(int targetNumber) {

        for (int left_index = 0; left_index < A.length; left_index++)
            for (int right_index = left_index + 1; right_index < A.length; right_index++) {
                {
                    int tempX = doBinaryOR(A, left_index, right_index);

                    if (targetNumber == tempX) {
                        removeSubsetFrom(A, left_index, right_index);
                    }
                }
            }
    }

    private static void removeSubsetFrom(int[] a, int start_index2, int end_index2) {

    }

    static int doBinaryOR(int[] set, int left_index, int right_index) {
        int previous = 1;

        for (int i = 0; i < set.length; i++) {
            previous = previous | set[i];
        }

        return previous;
    }
}
