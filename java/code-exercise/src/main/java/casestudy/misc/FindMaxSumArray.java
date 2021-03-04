package casestudy.misc;

public class FindMaxSumArray {

    // Find the maximum sum from the sub-arrays within the Array
    public static Integer findMaxSumFromArray(int[] array) {
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < array.length; i++) {
            max_ending_here = max(0, max_ending_here + array[i]);
            max_so_far = max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = {-3, 2, -1, 3, 4, -1};
        int m = findMaxSumFromArray(a);
        System.out.println(m);
    }

    public static int max(int a, int b) {
        return (a > b ? a : b);
    }
}
