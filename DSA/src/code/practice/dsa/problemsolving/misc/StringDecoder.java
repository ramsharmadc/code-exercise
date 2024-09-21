package dsa.problemsolving.misc;

import java.util.Queue;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid;
 * No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * <p>
 * Example 1:
 * Input: s = "3[a] 2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Example 2:
 * Input: s = "3[a 2[c]]"
 * Output: "accaccacc"
 * <p>
 * Example 3:
 * Input: s = "2[abc] 3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * Example 4:
 * Input: s = "abc 3[cd] xyz"
 * Output: "abccdcdcdxyz"
 */
public class StringDecoder {

    public static void main(String[] args) {

        testDecoder("3[a]2[bc]");
        testDecoder("3[a2[c]]");
        testDecoder("2[abc]3[cd]ef");
        testDecoder("abc3[cd]xyz");

    }

    public static void testDecoder(String ins) {
        StringDecoder stringDecoder = new StringDecoder();
        String decodeString = stringDecoder.decode(ins);
        System.out.println(ins + " -> " + decodeString);
    }

    public String decode(String s) {
        int count = 0;
        //using 2 stacks, one for the count and one for the characters
        Stack<Integer> stkI = new Stack<>();
        Stack<String> stkC = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = Character.getNumericValue(c);
                stkI.push(count);
            } else if (c == ']') {
                String tmp = "";
                String tmpStr = "";
                while (!stkC.isEmpty()) {
                    if ("[".equals(stkC.peek())) {
                        tmpStr = repeat(tmp, stkI.pop());
                        stkC.pop();
                        stkC.push(tmpStr);
                        break;
                    } else {
                        tmp = stkC.pop() + tmp;
                    }
                }
            } else {
                stkC.push(c + "");
            }
        }
        String outputStr = "";
        while (!stkC.isEmpty()) {
            outputStr = stkC.pop() + outputStr;
        }

        return outputStr.toString();
    }

    private String joinString(Queue<Character> q) {
        StringBuilder s = new StringBuilder();
        for (Character c : q) {
            s.append(c);
        }
        return s.toString();
    }

    // 3->[a]
    // 2->[bc]
    //3->[a2[c]]

    public String repeat(String s, int times) {
        if (times <= 0 || s == null || s == "") return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
