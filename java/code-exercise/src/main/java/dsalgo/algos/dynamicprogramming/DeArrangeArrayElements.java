package dsalgo.algos.dynamicprogramming;

import dsalgo.util.CommonUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * A De-arrangement is a permutation of 'n' elements, such that no element appears in its original
 * position. For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.
 * <p>
 * Given a number 'n', find total number of De-arrangements of a set of n elements
 *
 * @author ramsharma
 */
public class DeArrangeArrayElements implements DynamicProgramming {

    // static int[] n = new int[] {0, 1, 2, 3};
    static int[] n = new int[]{91, 89, 765};
    static List<String> repeatedCombinations = new LinkedList<>();
    static Set<String> permutations = new HashSet<>();
    static int diff_and_RepeatedCombinations = 0;

    public static void main(String[] args) throws Exception {
        permutations.add(CommonUtils.arrayAsString(n));
        deArrange(n, 0, n.length - 1);
        permutations.addAll(repeatedCombinations);
        permutations.remove(CommonUtils.arrayAsString(new int[]{0, 1, 2}));
        System.out.println("Total permutations = " + repeatedCombinations.size());
        System.out.println("Permutations: " + permutations);
    }

    private static void deArrange(int[] n, int start, int end) throws Exception {

        if (start == end) {
            // System.out.println(CommonUtils.arrayAsString(n));
            // permutations.add(CommonUtils.arrayAsString(n));
        } else {
            for (int i = start; i <= end; i++) {
                for (int j = 0; j <= end; j++) {
                    if (i != j) {
                        swap(n, i, j);
                        System.out.println(CommonUtils.arrayAsString(n));
                        System.out.println(diff_and_RepeatedCombinations++);
                        // repeatedCombinations.add(CommonUtils.arrayAsString(n));
                        deArrange(n, start + 1, end);
                        // swap(n, i, j);
                    }
                }
            }
        }
    }

    private static void swap(int[] arr, int index_a, int index_b) {
        int temp = arr[index_a];
        arr[index_a] = arr[index_b];
        arr[index_b] = temp;

    }
}
