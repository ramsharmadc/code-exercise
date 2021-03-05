package dsalgo.algos.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all possible expressions that evaluate to a target Given a string that contains only digits
 * from 0 to 9, and an integer value, target. Find out how many expressions are possible which
 * evaluate to target using binary operator +, � and * in given string of digits.
 * <p>
 * Input : "123", Target : 6 Output : {�1+2+3�, �1*2*3�}
 * <p>
 * Input : �125�, Target : 7 Output : {�1*2+5�, �12-5�}
 *
 * @author ramsharma
 */
public class PossibleExpressionToEvaluateTarget {

    static String in = "123";
    static int target = 6;
    static List<String> permutations = new ArrayList<String>();

    public static void main(String[] args) {
        eval(in);
    }

    static private void eval(String input) {
        getCombinations(input, 0, input.length());

        System.out.println(permutations);

        String expr = evalNow(permutations);
        System.out.println(expr);

    }

    private static String evalNow(List<String> pem) {

        /*
         * if (tgt == target) { return str; }
         */
        StringBuilder expr = new StringBuilder();
        int prev_val = 0;
        for (int m = 0; m < pem.size(); m++) {

            Integer m_val = Integer.valueOf(pem.get(m));
            expr.append(m_val);
            prev_val += m_val;

            for (int n = 0; n < pem.size(); n++) {
                Integer n_val = Integer.valueOf(pem.get(n));

                if (prev_val + n_val == target)
                    expr.append("+").append(n_val);
                else if (prev_val - n_val == target)
                    expr.append("-").append(n_val);
                else if (prev_val * n_val == target)
                    expr.append("*").append(n_val);
                else if (prev_val / n_val == target)
                    expr.append("/").append(n_val);
            }

            if (m == pem.size()) {
                expr = new StringBuilder();
                prev_val = 0;
            }
        }

        return expr.toString();
        /*
         * return evalNow(pem, i + 1, tgt + Integer.valueOf(pem.get(i)), str + "+" + pem.get(i));
         */

    }

    private static void getCombinations(String I_Str, int start, int end) {

        for (int i = 0; i < I_Str.length(); i++) {
            StringBuilder strB = new StringBuilder();
            strB.append(I_Str.charAt(i));
            permutations.add(String.valueOf(I_Str.charAt(i)));
            for (int j = 0; j < I_Str.length(); j++) {
                if (i != j) {

                    strB.append(I_Str.charAt(j));
                    permutations.add(strB.toString());
                }
            }
        }
    }
}
