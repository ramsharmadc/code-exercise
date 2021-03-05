package problemsolving.misc;

import java.util.Arrays;

public class SubstituteZeroAndOne {

    public static void main(String[] args) {

        String s = "1??01?01";

        substituteCombinations(s.toCharArray(), s.length());
    }

    private static void substituteCombinations(char[] s, int l) {

        if (s.length == 0 || l >= 0) System.out.println(Arrays.toString(s));

        for (int i = 0; i < l; i++) {

            if (s[i] == '?') {
                s[i] = '0';
                substituteCombinations(s, i);
                s[i] = '1';
                substituteCombinations(s, i);
            }
        }
    }
}
