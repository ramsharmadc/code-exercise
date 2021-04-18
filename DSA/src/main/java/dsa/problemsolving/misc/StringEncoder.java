package dsa.problemsolving.misc;

/**
 * Run length encoding of string. See below for example:
 * aaaaabbbccd => a5b3c2d1
 * xyz => x1y1z1
 */
public class StringEncoder {

    public static void main(String[] args) {

        System.out.println(testEncoder("aaaaabbbccdd"));
        System.out.println(testEncoder("xyz"));
    }

    private static String testEncoder(String s) {

        int cur = 1;
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cur += 1;
            } else {
                sb.append(c + "" + cur);
                c = s.charAt(i);
                cur = 1;
            }
        }
        sb.append(c + "" + cur);
        return sb.toString();
    }
}
