package problemsolving.misc;

import util.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of numbers, find the longest subset with consecutive numbers be it any order
 */

public class LongSubsetWithConsecutiveNumbers {

    public static void main(String[] args) throws Exception {
        int[] S = {5, 1, 9, 25, 3, 7, 26, 8, 20, 21, 22, 4, 10, 2, 11, 3, 23, 12, 24};

        List<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(S);

        System.out.println(CommonUtils.arrayAsString(S));

        for (int i = 0; i < S.length - 1; i++) {
            if (S[i + 1] == S[i])
                i++;
            if (S[i + 1] - S[i] == 1) {
                tmp.add(S[i]);
                if (i != (S.length - 2))
                    continue;
                else
                    tmp.remove(tmp.size() - 1);
            }
            tmp.add(S[i]);
            subsets.add(tmp);
            tmp = new ArrayList<>();
        }

        for (ArrayList<Integer> l : subsets)
            System.out.println(l);
    }
}
