package dsa.problemsolving.misc;

public class CheckSubString {

    public static boolean checkSubString(final String parentStr, final String subStr) {

        final int len = subStr.length();
        for (int i = 0; i < ((parentStr.length() - len) + 1); i++) {
            if (parentStr.substring(i, (i + len)).equals(subStr))
                return true;
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final String bigStr = "RamSharma";
        final String smallStr = "Ram";

        System.out.println(bigStr.toLowerCase().contains(smallStr.toLowerCase()));

        System.out.println(checkSubString(bigStr.toLowerCase(), smallStr.toLowerCase()));

        checkSubString(bigStr, smallStr);

        // if same case
        System.out.println();
    }
}
