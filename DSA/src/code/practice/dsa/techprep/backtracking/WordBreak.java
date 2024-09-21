package dsa.techprep.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a valid sentence without any spaces between the words and a dictionary of valid English words,
 * find all possible ways to break the sentence in individual dictionary words.
 * <p>
 * Example:
 * Input: "ilikesamsungmobile"
 * Output: i like sam sung mobile
 * i like samsung mobile
 */
public class WordBreak {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(
                Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice",
                        "and", "cream", "icecream", "man", "go", "mango"));
        String str = "ilikesamsungmobile";
        Set<String> possibleBreakups = findValidBreakups(dictionary, str);
        for (String possibleBreakup : possibleBreakups) {
            System.out.print(possibleBreakup + " ");
        }
    }

    private static Set<String> findValidBreakups(Set<String> dictionary, String str) {
        Set<String> ls = new LinkedHashSet<>();
        breakWords(str, dictionary, str.length(), ls, "");
        return ls;
    }

    static void breakWords(String s, Set<String> dict, int len, Set<String> repo, String tmp) {
        if (len <= 0 || s.length() == 0) return;
        for (int i = 0; i < len; i++) {
            tmp = tmp + s.charAt(i);
            if (dict.contains(tmp)) {
                if (tmp != "" || tmp.length() > 0) {
                    repo.add(tmp);
                }
                breakWords(s.substring(i + 1), dict, s.substring(i + 1).length(), repo, "");
            } else {
                breakWords(s.substring(i + 1), dict, s.substring(i + 1).length(), repo, tmp);
            }
        }
    }
}
