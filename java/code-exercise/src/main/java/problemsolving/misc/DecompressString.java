package problemsolving.misc;

/**
 * In this exercise, you're going to decompress a compressed string.
 * Your input is a compressed string of the format number[string] and the
 * decompressed output form should be the string written number times. For example:
 * The input
 * 3[abc]4[ab]c
 * Would be output as
 * abcabcabcababababc
 * Other rules
 * Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa
 * One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
 * Characters allowed as input include digits, small English letters and brackets [ ].
 * Digits are only to represent amount of repetitions.
 * Letters are just letters.
 * Brackets are only part of syntax of writing repeated substring.
 * Input is always valid, so no need to check its validity.
 */
public class DecompressString {

    public static void main(String[] args) {
        String inStr = "9[abc]4[ab]5[c]";
        String decompressedStr = decompress(inStr);
        System.out.println(inStr);
        System.out.println(decompressedStr);
    }

    private static String decompress(String inStr) {
        StringBuilder decompressedString = new StringBuilder();
        StringBuilder strToken = null;
        int repeatNbr = 0;
        for (int i = 0; i < inStr.length(); i++) {
            char c = inStr.charAt(i);
            if (Character.isDigit(c)) {
                strToken = new StringBuilder();
                repeatNbr = repeatNbr * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
            } else if (c == ']') {
                decompressedString.append(repeat(strToken.toString(), repeatNbr));
                repeatNbr = 0;
                strToken = new StringBuilder();
            } else {
                strToken.append(c);
            }
        }
        decompressedString.append(strToken);
        return decompressedString.toString();
    }

    private static String repeat(String token, int times) {
        if (times < 1) return token;
        if (token == "" || token.length() == 0 || token == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++)
            stringBuilder.append(token);
        return stringBuilder.toString();
    }
}
