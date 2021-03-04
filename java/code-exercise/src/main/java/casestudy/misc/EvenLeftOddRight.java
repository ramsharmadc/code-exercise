package casestudy.misc;

import util.CommonUtils;

public class EvenLeftOddRight {

    /**
     * Given +ve numbers in an array . Put the even #s to the left of the array and the odd to the
     * right side of the array . Don't use extra array
     *
     * @throws Exception
     */

    public static void main(final String[] args) throws Exception {
        final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4,
                5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1,
                2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10};
        System.out.println(CommonUtils.arrayAsString(arr));
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2) != 0) {
                for (int j = i; j < arr.length; j++) {
                    if ((arr[j] % 2) == 0) {
                        final int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
        System.out.println(CommonUtils.arrayAsString(arr));
    }
}
