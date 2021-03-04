package dsa.algos.sorting;

import dsa.util.CommonUtils;

public class MergeSort {

    private int[] arr;
    private int[] tempArr;
    private int length;

    public static void main(String[] args) throws Exception {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        System.out.println(CommonUtils.arrayAsString(inputArr));
        MergeSort obj = new MergeSort();
        obj.sort(inputArr);
        System.out.println(CommonUtils.arrayAsString(obj.arr));
    }

    public void sort(int[] arr) {
        this.arr = arr;
        length = arr.length;
        tempArr = new int[length];
        mergeSort(0, length - 1);
    }

    private void mergeSort(int min, int max) {
        if (min < max) {
            int mid = min + (max - min) / 2;
            mergeSort(min, mid);
            mergeSort(mid + 1, max);
            merge(min, mid, max);
        }
    }

    private void merge(int low, int mid, int max) {
        for (int i = low; i <= max; i++) {
            tempArr[i] = arr[i];
        }
        int i, k, j;
        i = k = low;
        j = mid + 1;
        while (i <= mid && j <= max) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = tempArr[i];
            k++;
            i++;
        }
    }
}
