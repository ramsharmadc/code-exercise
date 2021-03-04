package casestudy.misc;

import java.util.*;

public class GenUtil {

    private static int count = 0;
    private static int flag = 0;

    public static int CountPrimeUpTo(final int N) {

        if ((N == 0) || (N == 1))
            return 1;

        else {
            for (int i = 1; i <= N; i++) {
                flag = 0;
                if (i == 1) {
                    count++;
                    continue;
                }
                for (int j = 2; j <= (i / 2); j++) {
                    if ((i % j) == 0) {
                        flag = 1;
                        break;
                    } else {
                        continue;
                    }
                }

                if (flag == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Find the maximum sum from the sub-arrays within the Array
    public static Integer findMaxSumFromArray(final int[] array) {

        int max_so_far = 0;
        int max_ending_here = 0;

        for (final int element : array) {
            max_ending_here = max(0, max_ending_here + element);
            max_so_far = max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public static int gcd(final int p, final int q) {

        if (q == 0)
            return p;
        else
            return gcd(q, p % q);
    }

    public static int largestNumber(int nm) {

        int temp = 0;
        final List<Integer> arr = new ArrayList<Integer>();
        // int i = 0;

        while (nm != 0) {
            temp = (nm % 10);
            nm = nm / 10;
            arr.add(temp);
        }

        final Comparator<Integer> comparator = Collections.reverseOrder();
        Collections.sort(arr, comparator);

        // System.out.println(arr);
        for (final int i : arr) {
            nm = (nm * 10) + i;
        }

        // System.out.println(nm);
        return nm;
    }

    public static int max(final int a, final int b) {

        return (a > b ? a : b);
    }

    // public void printRomanNumerals
    public static void subtractLinkedLists(final LinkedList<Integer> list1,
                                           final LinkedList<Integer> list2) {

        new LinkedList();

        for (final int i : list1) {

        }
    }
}
