package dsa.algorithms.sorting;

import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) throws Exception {

        long startTimer = System.nanoTime();
        int[] arr = {10, 23, 7, 16, 90,
                45/*
		           * , 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90, 45, 10, 23,
		           * 7, 16, 90, 45, 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90,
		           * 45, 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90, 45, 10, 23, 7, 16, 90, 45
		           */};
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Unsorted array:: " + Arrays.toString(arr));

        try {
            // this one is correct
            quickSort(arr, left, right);
            long endTimer = System.nanoTime();
            System.out.println("Sorted in " + (endTimer - startTimer) / 1000 + " ms");
            System.out.println("Sorted array:: " + Arrays.toString(arr));
        } catch (ArithmeticException ae) {
            throw new ArithmeticException(ae.toString());
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int q = partition(arr, left, right);
        if (left < q - 1)
            quickSort(arr, left, q - 1);
        if (right > q)
            quickSort(arr, q, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            System.out.println("Intermediate array:: " + Arrays.toString(arr));
        }
        return i;
    }
}
