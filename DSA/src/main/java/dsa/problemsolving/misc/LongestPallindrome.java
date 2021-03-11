package dsa.problemsolving.misc;

public class LongestPallindrome {
    private static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static String longestPallindrome(String s) {
        if (s == null || s.length() == 0)
            return null;
        if (s.length() == 1)
            return s;

        String longestStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            String tmp = helper(s, i, i);
            if (tmp.length() > longestStr.length()) {
                longestStr = tmp;
            }
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longestStr.length()) {
                longestStr = tmp;
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        String s = "bbaaabcb";
        System.out.println(longestPallindrome(s));
    }
}
