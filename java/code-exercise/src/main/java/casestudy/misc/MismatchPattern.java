package casestudy.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Give an array of integers, which are in repeated format except one integer, write a function to
 * return that integer. ex [2,2,3,3,4,4,4,5,5] = 4 and [2,2,2,3,3,3,3,4,4,4] = 3
 */

public class MismatchPattern {

    private static void getNumberWithMismatchPatternUsingHashMap(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        System.out.println(map);

        TreeSet<Integer> set = new TreeSet<>(map.values());
        System.out.println(set.pollLast());
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        int[] arr2 = {2, 2, 3, 3, 4, 4, 4, 5, 5};

        getNumberWithMismatchPatternUsingHashMap(arr1);
        getNumberWithMismatchPatternUsingHashMap(arr2);
    }
}
