package casestudy.misc;

public class LargestSumSubArray {


    public static void main(String[] args) {

        int[] a = {-4, 2, -5, 1, 2, 3, 6, -15, 17};
        int maxSum = findMaxSumInSubArray(a);
        System.out.println(maxSum);
    }

    private static int findMaxSumInSubArray(int[] a) {

        int currentMax = a[0];
        int globalMax = a[0];

        for (int i = 0; i < a.length; i++) {
            if (currentMax < 0) {
                currentMax = a[i];
            } else {
                currentMax += a[i];
            }

            if (globalMax < currentMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
}
