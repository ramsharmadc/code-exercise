package problemsolving.misc;

import util.CommonUtils;

public class ReverseFirstNcharsOfString {

    public static void main(final String[] args) {
        final String str = "Prithvi Kumar";
        System.out.println(str);
        System.out.println(reverseFirstNChars(str, 7));
    }

    public static String reverseFirstNChars(final String str, final int n) {
        if (CommonUtils.isEmpty(str))
            return null;
        final StringBuilder strB = new StringBuilder();
        // System.out.println( str.substring( 0, n ) ) ;
        final String newStr = CommonUtils.reverse(str.substring(0, n));
        strB.append(CommonUtils.getFirstLetterUpperCase(newStr.toLowerCase()));
        strB.append(str.substring(n));
        return strB.toString();
    }
}
