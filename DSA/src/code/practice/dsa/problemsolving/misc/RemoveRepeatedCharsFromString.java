package dsa.problemsolving.misc;

import java.util.HashSet;
import java.util.Set;

public class RemoveRepeatedCharsFromString {

    public static void main(String[] args) {
        String str = "abbcccddddeeff";
        String expectedString = "abcdef";

        String actual = removeRepeatedCharsUsingSet(str);

        System.out.println("Result - " + (expectedString.equals(actual)));

        actual = removeRepeatedCharsUsingRecusrion(str);
    }

    private static String removeRepeatedCharsUsingRecusrion(String str) {
        if (null == str || str.isEmpty())
            return "";
        for (char c : str.toCharArray()) {
            while (str.indexOf(c) != str.lastIndexOf(c)) {

            }
        }
        return str;
    }

    private static String removeRepeatedCharsUsingSet(String str) {
        if (str == null || str.trim().isEmpty())
            return str;
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }
        StringBuilder strB = new StringBuilder();
        uniqueChars.forEach(x -> strB.append(x));
        return strB.toString();

        // return str;
    }
}
