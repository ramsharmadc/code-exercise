package dsalgo.algos.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print sums of all subsets of a given set Given an array of integers, print sums of all subsets in
 * it. Output sums can be printed in any order.
 * <p>
 * Input : arr[] = {2, 3} Output: 0 2 3 5
 * <p>
 * Input : arr[] = {2, 4, 5} Output : 0 2 4 5 6 7 9 11
 *
 * @author ramsharma
 */
public class SumOfAllSubsetsOfGivenSet {

    static int[] arr = {2, 4, 5};
    static List<Integer> allPerms = new ArrayList<Integer>();

    public static void main(String[] args) {
        allPerms.add(0);
        findSubset(arr, (arr.length - arr.length), arr.length, 0);
        allPerms.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("Sum of all subsets : " + allPerms);
    }

    static void findSubset(int[] arr, int start, int end, int sum) {
        if (start >= end) {
            allPerms.add(sum);
            return;
        }
        findSubset(arr, start + 1, end, sum + arr[start]);
        findSubset(arr, start + 1, end, sum);
    }
}
