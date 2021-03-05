package problemsolving.misc;

import dsalgo.util.CommonUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GenerateAnagramsAndFindRank {

    public static void main(String[] args) {
        String s1 = "aaab";    // 1
        String s2 = "abab";    // 2
        String s3 = "baaa";    // 4
        String s4 = "coolword";    // 406
        String s5 = "beekeeper";    // 63
        String s6 = "zoologist";    // 57649

        int i = 0;
        while (i++ < 100) {
            findRankInAnagram(s1);
            findRankInAnagram(s2);
            findRankInAnagram(s3);
            findRankInAnagram(s4);
            findRankInAnagram(s5);
            findRankInAnagram(s6);
        }
    }

    private static void findRankInAnagram(String s) {
        List<String> anagrams = getAnagrams(s.toCharArray());
//        System.out.println(anagrams);
        System.out.println("Rank(" + s + ") is " + (anagrams.indexOf(s) + 1));
    }

    private static List<String> getAnagrams(char[] s) {
        Set<String> anagramHolder = new TreeSet<>();
        permuteString(s, anagramHolder, 0, s.length - 1);
        return Collections.list(Collections.enumeration(anagramHolder));
    }

    private static void permuteString(char[] s, Set<String> anagramHolder, int i, int j) {
        if (i == j) anagramHolder.add(CommonUtils.arrayAsString(s, ""));
        for (int k = i; k <= j; k++) {
            swap(s, i, k);
            permuteString(s, anagramHolder, i + 1, j);
            swap(s, i, k);
        }
    }

    private static void swap(char[] s, int i, int k) {
        char tmp = s[i];
        s[i] = s[k];
        s[k] = tmp;
    }
}
