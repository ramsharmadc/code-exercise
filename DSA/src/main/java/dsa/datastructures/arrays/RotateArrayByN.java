package dsa.datastructures.arrays;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class RotateArrayByN {

    public static void main(String[] args) {

        setUncaughtExceptionHandler();

        try {
            int[] arr = new int[10];
            int n = 4;

            for (int i = 0; i < arr.length; i++) {
                // arr[i] = Math.random();
                arr[i] = (int) (i * 21 + 6 * Math.random());
            }

            System.out.println(Arrays.toString(arr));

            System.out.println("Rotating...");

            TimeUnit.SECONDS.sleep(5);

            rotateArray(arr, n);

            TimeUnit.SECONDS.sleep(5);
//            "".toCharArray()

            System.out.println("Rotation finished...");

            System.out.println(Arrays.toString(arr));

            Integer.parseInt("TT");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static void rotateArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            shiftLeft(arr);
        }

    }

    private static void shiftLeft(int[] arr) {
        int tmp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = tmp;
    }

    public static void setUncaughtExceptionHandler() {

        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {

            System.out.println("Thread caused exception -> " + t.getId() + ":" + t.getName());

            System.out.println("ERROR:: " + e);
        });
    }
}
