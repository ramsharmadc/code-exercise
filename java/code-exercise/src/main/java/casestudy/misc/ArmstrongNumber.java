package casestudy.misc;

import java.util.Scanner;

/**
 * This program computes all Armstrong numbers in the range of ! 0 and 999. An Armstrong number is a
 * number such that the sum ! of its digits raised to the third power is equal to the number !
 * itself. For example, 371 is an Armstrong number, since ! 3**3 + 7**3 + 1**3 = 371.
 */
public class ArmstrongNumber {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        String str = in.nextLine();
        String[] diffSize = str.split(",");
        int[] sizePack = new int[n];

        for (int i = 0; i < n; i++) {
            sizePack[i] = Integer.valueOf(diffSize[i]);
        }
        System.out.print(findMaxRectangle(n, sizePack));
    }

    public static int findMaxRectangle(final int n, int[] a) {
        if ((n == 0) || (n == 1))
            return 0;
        int max_val = 0;
        for (int i = 1; i < n; i++) {
            max_val = max(max_val, max(a[i] * (n - i), findMaxRectangle(n - i, a) * i));
        }
        return max_val;
    }

    private static int max(final int a, final int b) {
        return a > b ? a : b;
    }
}
