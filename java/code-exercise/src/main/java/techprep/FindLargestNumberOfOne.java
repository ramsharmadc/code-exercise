package techprep;

/**
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
 * Example:
 * <p>
 * <p>
 * Input matrix
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1  // this row has maximum 1s
 * 0 0 0 0
 * <p>
 * Output: 2
 */

public class FindLargestNumberOfOne {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        int max1s = findmaxOnes(a);
        System.out.println(max1s);
    }

    private static int findmaxOnes(int[][] a) {
        int max = -1;
        int maxAtIndex = -1;

        for (int i = 0; i < a.length; i++) {
            int currCount = findCountOf1s(a[i]);
            if (max < currCount) {
                max = currCount;
                maxAtIndex = i;
            }
        }
        return maxAtIndex;
    }

    static int findCountOf1s(int[] a) {
        int pivot = findFirstPositionOf1(a);
        if (pivot < 0) return 0;
        return a.length - pivot;
    }

    static int findFirstPositionOf1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) return i;
        }
        return -1;
    }

    static int findFirstPositionOf1UsingBinarySearch(int[] a) {
        return BinarySearch.search(a, 1, 0, a.length-1);
    }
}
