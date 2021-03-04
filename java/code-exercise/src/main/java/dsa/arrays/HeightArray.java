package dsa.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * You have given height array of array. Generate the original array. Input: [6,3,0,2,2,0,0] Output
 * : [ 1,5,7,3,2,6,4] * A[i] value in input array is the number of greater element on right side.
 *
 * @author ramsharma
 */

public class HeightArray {

    public static void main(String[] args) {
        // A is a height array(Rank array),
        // e.g. there are 6 elements to the right of A[0]
        int[] A = {6, 3, 0, 2, 2, 0, 0};

        int[] B = getOriginalArray(A);

        System.out.println(Arrays.toString(B));
    }

    private static int[] getOriginalArray(int[] a) {
        int[] B = new int[a.length];
        int max = B.length;

        // setting up rank for the elements
        Set<Integer> s = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });

        int t = 1;
        while (t <= max) {
            s.add(t++);
        }
        System.out.println("Set => " + s);

        for (int i = 0; i < a.length; i++) {
            int rank = a[i];
            B[i] = findElement(rank, s);
        }

        return B;
    }

    // check range and find the fitting element
    private static int findElement(int rank, Set<Integer> s) {
        int i = 0, e = 0;
        for (Integer j : s) {
            e = j;
            if (i == rank) {
                s.remove(j);
                break;
            }
            i++;
        }
        return e;
    }
}
