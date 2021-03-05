package dsalgo.algos.sorting;

import dsalgo.util.CommonUtils;

public class CountingSort {

    public static void main(String[] args) {
        int[] A = {12, 19, 113, 78, 89, 59, 43, 76, 39, 51, 8, 4, 6, 6, 70, 49, 79, 94, 83};

        try {
            System.out.println(CommonUtils.arrayAsString(A, "|"));
            A = new CountingSort().countSort(A, new int[A.length], 113);
            System.out.println(CommonUtils.arrayAsString(A, "|"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] countSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }
        for (int j = (A.length - 1); j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        return B;
    }
}
