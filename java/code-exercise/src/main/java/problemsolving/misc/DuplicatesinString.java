package problemsolving.misc;

public class DuplicatesinString {

    public static void main(final String[] args) {

        String str = removeDups("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
        str = removeDups("Today is the day");
        System.out.println(str);
    }

    public static String removeDuplicateCharactersFromAString(final String str) {
        return removeDups(str);
    }

    // this method uses new String, but the best is to do in-place
    private static String removeDups(final String str) {
        final StringBuilder strB = new StringBuilder();
        final boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (!charSet[c]) {
                strB.append(c);
                charSet[c] = true;
            }
        }
        return strB.toString();
    }
}
