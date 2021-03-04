package casestudy;

import java.util.Arrays;
import java.util.Stack;

/**
 * Conventional RPN Result 2 2 2 3 + 4 3 4 + 7 12 / 4 - 1 12 4 / 1 - 2 12 / (4 - 1) 12 4 1 - / 4
 * ((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1)) 15 7 1 1 + - / 3 * 2 1 1 + + - 5
 */
public class ReversePolishNotationCalculator {

    public int calculate(String exp) {
        Stack<Integer> stack = new Stack<>();

        /*
         * for (String c : exp.split(" ")) { int result = 0; if (anOperator(c)) { Integer right =
         * Integer.valueOf(stack.pop()); Integer left = Integer.valueOf(stack.pop()); result =
         * calculate(right, left, c); stack.push(Integer.valueOf(result)); } else if (c != null &&
         * !c.equals(" ")) { stack.push(Integer.valueOf(c)); } }
         */

        Arrays.asList(exp.split(" ")).forEach(token -> {
            if (anOperator(token)) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(calculate(right, left, token));
            } else if (token != null && !token.equals("") && !token.equals(" ")) {
                stack.push(Integer.valueOf(token));
            }
        });
        return stack.pop();
    }

    private int calculate(Integer right, Integer left, String c) {
        switch (c) {
            case "+":
                return add(left, right);
            case "-":
                return subtract(left, right);
            case "*":
                return multiply(left, right);
            case "/":
                return divide(left, right);
            default:
                return 0;
        }
    }

    private boolean anOperator(String c) {
        return "+".equals(c) || "*".equals(c) || "/".equals(c) || "-".equals(c);
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }
}
