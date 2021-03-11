package dsa.problemsolving.misc;

import java.util.ArrayList;

public class StringHasUniqueChars {

    private static boolean checkStringHasUniqueChars(final String str) {
        for (int i = 0; i < str.toCharArray().length; i++) {
            for (int j = i + 1; j < str.toCharArray().length; j++) {
                if (str.toCharArray()[i] == str.toCharArray()[j])
                    return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        final String str = "AAABBBCDEEEFFGHIJKLMNOPQRSTUVWXYZZZXX";
        if (checkStringHasUniqueChars(str)) {
            System.out.println("String has unique chars");
        } else {
            System.out.println("Not Unique");
            System.out.println("Removed Dups: " + removeDupes(str));
        }
    }

    private static String removeDupes(final String str) {
        final StringBuffer strBuff = new StringBuffer();
        final ArrayList<Character> strAsCharArr = new ArrayList<Character>();

        for (final char ch : str.toCharArray()) {
            if (!strAsCharArr.contains(ch)) {
                strAsCharArr.add(ch);
            }
        }

        for (final Character ch : strAsCharArr) {
            strBuff.append(ch);
        }
        return strBuff.toString();
    }
}
