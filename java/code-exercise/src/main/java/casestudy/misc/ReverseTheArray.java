package casestudy.misc;

import java.util.Arrays;

public class ReverseTheArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        reverseArray(a);
        System.out.println(Arrays.toString(a));
    }

    private static void reverseArray(int[] a) {
        int mid = a.length / 2;
        for (int i = 0; i < mid; i++) {
            int j = a.length - (i + 1);
            if (i != j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
}
