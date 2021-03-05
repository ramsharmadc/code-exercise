package problemsolving.misc;

import java.util.HashSet;
import java.util.Set;

public class CheckRepeating {

    public static void main(final String[] args) {

        final int[] arr = {1, 2, 3, 10, 4, 6, 7, 8, 9, 10};

        final Set<Integer> set = new HashSet<Integer>();

        for (final Integer i : arr) {
            if (!set.add(i)) {
                System.out.println("This is repeating :: " + i);
            } else {
                set.add(i);
            }
        }
    }
}
