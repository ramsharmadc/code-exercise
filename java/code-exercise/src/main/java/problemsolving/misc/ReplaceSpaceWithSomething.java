package problemsolving.misc;

public class ReplaceSpaceWithSomething {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final String str = " There always are some spaces ";
        final String replaceChar = "%20";

        final String newStr = replaceSpaceWith(str, replaceChar);
        System.out.println(newStr);
    }

    public static String replaceSpaceWith(final String str, final String replaceChar) {

        // TODO Auto-generated method stub
        StringBuffer strBuf = null;
        for (final Character c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                final String _str = str.replaceAll(c.toString(), replaceChar);
                strBuf = new StringBuffer();
                strBuf.append(_str);
            }
        }
        return strBuf.toString();
    }

}
