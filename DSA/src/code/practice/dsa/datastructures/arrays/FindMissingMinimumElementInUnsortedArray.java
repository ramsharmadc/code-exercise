package dsa.datastructures.arrays;

public class FindMissingMinimumElementInUnsortedArray {

    public static void main(String[] args) {
        int[] a = {4, 6, 8, 9, 11, 3};
        int n = findMinimum(a);
        System.out.println(n);
    }

    private static int findMinimum(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }
}
