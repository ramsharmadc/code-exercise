package casestudy.misc;

public class MaxJminusI {
    private static int findMaxJminusI(final int[] arr) {
        int temp = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    max = (j - 1);
                    if (max < temp)
                        max = temp;
                    temp = max;
                }
            }
        }
        return max;
    }

    public static void main(final String[] args) {
        final int[] arr = {8, 10, 3, 2, 80, 30, 33, 39};
        final int max = findMaxJminusI(arr);
        System.out.println(max);
    }
}
