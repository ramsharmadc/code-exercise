package dsalgo.arrays;

import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) {

        final int[] a = new int[5];
        int i = 0;
        for (; i < a.length; i++) {
            a[i] = i + 3;
        }
        Arrays.stream(a).forEach(z -> System.out.print(z + " "));

        System.out.println("Program Finished.");
    }
}
