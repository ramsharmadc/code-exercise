package dsa.algorithms.recursion;

import dsa.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    int count = 0;

    public static void main(final String[] args) {
        final StringPermutation oj = new StringPermutation();
        try {
            final String str = "123";
            List<String> permutations = new ArrayList<>();
            oj.permute(str.toCharArray(), permutations, 0, (str.length() - 1));
//            System.out.print(permutations);
            System.out.println("\nTotal permutations = " + permutations.size());
        } catch (final Exception e) {
            System.out.println("ERROR:: " + e.getMessage());
        }
    }

    private void permute(char[] s, List<String> p, int start, int end) throws Exception {
        if (start == end) {
            System.out.println(CommonUtils.arrayAsString(s, ""));
             p.add(CommonUtils.arrayAsString(s, ""));
        } else {
            for (int j = start; j <= end; j++) {
                swap(s, start, j);
                permute(s, p, (start + 1), end);
                swap(s, start, j); // backtrack
            }
        }
    }

    private void swap(final char[] chars, final int x, final int y) throws Exception {
        if (x != y) {
            char temp;
            temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }
    }
}
