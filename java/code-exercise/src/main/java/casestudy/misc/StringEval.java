package casestudy.misc;

import java.util.Stack;

public class StringEval {

    public static int evaluateString(String str) {

        /**
         * if char is not operator and if it is not * OR 1, push it if next is * OR / , read next,
         * pop one and apply, then push result if end, pop all and apply the operator
         */

        int n = 0;
        int m = 0;
        int res = 0;
        Stack<Integer> s = new Stack<>();

        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; ) {
            if (c[i] != '*' && c[i] != '+' && c[i] != '-' && c[i] != '/') {
                // its a number
                s.push((int) c[i]);
                i += 1;
                continue;
            }
            if (c[i] == '*' || c[i] == '/') {
                if (s != null) {
                    n = s.pop();
                    i += 1;
                    m = c[i];
                    i += 1;

                    if (c[i] == '*')
                        s.push(n * m);
                    else
                        s.push(n * m);

                    continue;
                }
            }

            s.push((int) c[i]);
            i += 1;
        }

        while (s != null) {
            int n1 = s.pop();
            Integer op = s.pop();
            int m1 = s.pop();

            if (op == '+') {
                res = n1 + m1;
            }
        }

        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        // string evaluation in one pass : 3*5+4*5

        String str = "3*5+4*5";
        evaluateString(str);
    }

}
