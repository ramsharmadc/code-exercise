package dsa.problemsolving.misc;

import java.util.Stack;

public class ExpressionChecker {

    public static boolean checkExpression(String exp) throws NullPointerException {

        if (exp == null)
            throw new NullPointerException("Expression is null");
        if (exp.equals(""))
            return true;
        Stack<Character> stk = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                if (!stk.isEmpty()) {
                    stk.pop();
                } else
                    return false;
            }
        }
        return stk.isEmpty();
    }
}
