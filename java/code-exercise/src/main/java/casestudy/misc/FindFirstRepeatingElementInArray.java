package casestudy.misc;

import java.util.HashSet;

public class FindFirstRepeatingElementInArray {

    static int[] a = {5, 4, 3, 2, 2, 3, 8, 9};

    public static void main(final String[] args) {

        final int min = findFirstRepeatingElement(a);
        System.out.println(min);
    }

    public static int findFirstRepeatingElement(final int[] a) {

        final HashSet<Integer> hs = new HashSet<>();
        int min = 0;

        for (int i = 0; i < a.length; i++) {
            if (!(hs.add(a[i]))) {
                min = a[i];
                return min;
            } else {
                hs.add(a[i]);
            }
        }
        return 0;
    }
}
