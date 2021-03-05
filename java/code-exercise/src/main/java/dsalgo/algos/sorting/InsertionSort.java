package dsalgo.algos.sorting;

import dsalgo.util.CommonUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 1, 3};

        try {
            System.out.println(CommonUtils.arrayAsString(a, "|"));
            for (int j = 1; j < a.length; j++) {
                int key = a[j];
                int i = j - 1;
                while (i > -1 && a[i] > key) {
                    a[i + 1] = a[i];
                    i -= 1;
                }
                a[i + 1] = key;
            }
            System.out.println(CommonUtils.arrayAsString(a, "|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
