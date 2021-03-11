package dsa.problemsolving.misc;

public class ReverseWords {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        // String str = "Sunday means Holiday";
        // String str = "This is a test";
        // String str = "all your base";
        final String str = "foobar";
        final String reversedStr = reverseWordsInString(str);
        final String reversedStrAgain = reverseOrderString(str);
        System.out.println(str);
        System.out.println(reversedStr);
        System.out.println(reversedStrAgain);
    }

    public static String reverseOrderString(final String str) {
        final char[] strAsArr = str.toCharArray();
        final StringBuilder newStr = new StringBuilder();
        for (int i = (strAsArr.length - 1); i >= 0; i--) {
            newStr.append(strAsArr[i]);
        }
        return newStr.toString();
    }

    public static String reverseWordsInString(final String str) {
        final String[] words = str.split(" ");
        final StringBuilder newStr = new StringBuilder();
        for (int i = (words.length - 1); i >= 0; i--) {
            newStr.append(words[i] + " ");
        }
        return newStr.toString();
    }
}
