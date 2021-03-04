package casestudy.misc;

import java.util.Arrays;

public class MoveZerosToLeft {

    public static void main(String[] args) {
        int[] a = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        runTest(a);

        int[] b = {1, 0, 2, 3, 4, 6, 7, 8};
        runTest(b);
    }

    public static void runTest(int[] a) {
        System.out.println(Arrays.toString(a));
        shiftZerosToLeft(a);
        System.out.println(Arrays.toString(a));
    }

    private static void shiftZerosToLeft(int[] a) {
        int readIndex = a.length - 1, writeIndex = a.length - 1;

        while (readIndex >= 0) {
            if (a[readIndex] != 0) {
                a[writeIndex] = a[readIndex];
                writeIndex--;
                readIndex--;
            } else if (a[readIndex] == 0) {
                readIndex--;
            }
        }

        while (writeIndex >= 0) {
            a[writeIndex] = 0;
            writeIndex--;
        }
    }
}
