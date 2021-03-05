package problemsolving.misc;

import java.util.HashMap;
import java.util.Map;

public class Find2Integers {
    public static void main(String[] args) {

        int[] a = {2, 3, 4, 2, 5, 1, 2, 8, 6, 5, 4};
        int targetNumber = 14;

        boolean thereExists2SuchNumbers = find2NumbersWithTargetSumAs(targetNumber, a);
        System.out.println("\n" + thereExists2SuchNumbers);

        thereExists2SuchNumbers = find2NumbersWithTargetSum(targetNumber, a);
        System.out.println("\n" + thereExists2SuchNumbers);

        thereExists2SuchNumbers = find2NumbersWithTargetSumUsingMap(targetNumber, a);
        System.out.println("\n" + thereExists2SuchNumbers);
    }

    private static boolean find2NumbersWithTargetSumUsingMap(int targetNumber, int[] a) {

        // additional storage
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int rem = targetNumber - a[i];
            if (rem > 0 && map.containsKey(rem)) {
                System.out.format("\nThere exists 2 numbers- %d and %d", a[i], rem); // doesn't give
                // index
                // of those 2 numbers
                return true;
            }
            map.put(a[i], 0);
        }
        return false;
    }

    // O(n) solution, but takes extra space and with limitations
    private static boolean find2NumbersWithTargetSum(int targetNumber, int[] a) {

        // waste of memory, how much you will initialize
        boolean[] binMap = new boolean[200];

        for (int i = 0; i < a.length; i++) {
            int remainingSum = targetNumber - a[i];
            if (remainingSum > 0 && binMap[remainingSum]) {
                System.out.format("\nThere exists 2 numbers- %d and %d", a[i], remainingSum); // doesn't
                // give
                // index
                // of
                // those
                // 2
                // numbers
                return true;
            }
            binMap[a[i]] = true;
        }
        return false;
    }

    // O(n^2) solution but simple and easy, no extra space
    private static boolean find2NumbersWithTargetSumAs(int targetNumber, int[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (i != j && a[i] != a[j] && a[i] + a[j] == targetNumber) {
                    System.out.format("index %d i.e. %d and index %d i.e. %d", i, a[i], j, a[j]);
                    return true;
                }
            }
        }
        return false;
    }

}
