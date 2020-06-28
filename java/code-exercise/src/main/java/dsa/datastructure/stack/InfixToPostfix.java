package dsa.datastructure.stack;

import java.util.Stack;

/**
 * @author ramsharma
 */

public class InfixToPostfix {

	// Intermediate stack
	static Stack<Character> stk = new Stack<Character>();
	static Stack<Double> stkVal = new Stack<Double>();
	private static StringBuilder postfixExpression;
	private static StringBuilder infixExpression;
	private static Double postfixVal;

	private static void calculatePostfixExpression() {

		for (Character ch : postfixExpression.toString().toCharArray()) {

			if (!ch.equals('+') && !ch.equals('/') && !ch.equals('*') && !ch.equals('-') && !ch.equals('(')
					&& !ch.equals(')')) {

				stkVal.push(Double.valueOf(ch));
			} else {
				Double a = stkVal.pop();
				Double b = stkVal.pop();

				if (ch.equals('+'))
					stkVal.push(a + b);
				else if (ch.equals('-'))
					stkVal.push(a - b);
				else if (ch.equals('/'))
					stkVal.push(a / b);
				else if (ch.equals('*'))
					stkVal.push(a * b);
			}
		}

		postfixVal = stkVal.pop();
	}

	public static Double calculatePostfixExpression(String postfixExpr) {

		postfixExpression = new StringBuilder(postfixExpr);

		calculatePostfixExpression();

		return postfixVal;
	}

	private static void getPostfixFromInfix() {

		// traversing each character
		for (Character ch : infixExpression.toString().toCharArray()) {

			// It should not be white space
			if (!Character.isWhitespace(ch)) {

				// If it's not an operator
				if (!ch.equals('+') && !ch.equals('/') && !ch.equals('*') && !ch.equals('-') && !ch.equals('(')
						&& !ch.equals(')')) {

					postfixExpression.append(ch);
				}

				// If it's an operator
				else {

					// If right parenthesis ')'
					if (ch.equals(')')) {
						while (!stk.isEmpty()) {
							Character tmp = stk.pop();
							postfixExpression.append(!tmp.equals('(') ? tmp : "");
							if (tmp.equals('('))
								break;
						}
					}

					// if it's a left parenthesis '(', just push it
					else if (ch.equals('(')) {
						stk.push(ch);
					}

					// if not a right OR left parenthesis, if it's a high
					// precedence operator '*' or '/'
					else if (!stk.isEmpty() && (ch.equals('*') || ch.equals('/'))) {

						// pop from stack until low precedence operator comes OR
						// it's a left parenthesis '('
						// and write to the expression
						while (!stk.isEmpty() && !(stk.peek().equals('+') || stk.peek().equals('-'))
								&& !stk.peek().equals('(')) {

							Character tmp = stk.pop();
							if (!tmp.equals('(')) {
								postfixExpression.append(tmp);
							}
						}
						// after popping out needed operators, push the current
						// operator
						stk.push(ch);
					}

					// if it was not high precedence operator, may be '+' or '-'
					else {
						// pop until '(' comes
						while (!stk.isEmpty() && !stk.peek().equals('(')) {
							Character tmp = stk.pop();
							if (!tmp.equals('(')) {
								postfixExpression.append(tmp); // writing to the
																// expression
							}
						}
						// push the current operator
						stk.push(ch);
					}
				} // 'if it's an operator' block ends
			} // if it's a white space block ends
		} // for-each ends

		// At the end, clear the stack by popping out each operator and writing
		// to the expression
		while (!stk.isEmpty()) {
			Character tmp = stk.pop();
			if (!tmp.equals('(')) {
				postfixExpression.append(tmp);
			}
		}
	}

	/**
	 * Converts Infix expression to Post fix expression
	 * 
	 * @param infixExpr expression string
	 * @return post fix expression string
	 */
	public static String getPostfixFromInfix(String infixExpr) {

		postfixExpression = new StringBuilder();
		infixExpression = new StringBuilder(infixExpr);

		getPostfixFromInfix();

		return postfixExpression.toString();
	}

	public static void main(String[] args) {

		String inStr = "4 * ( 3 + 2 ) - 1";
		int n[] = { 2 };
		n[0]++;
		System.out.print(n[0]);
		// String inStr =
		// "4 * ( 3 + 2 ) - (1 + 2 * 5 * 6) * ( 9 * 2 + 1 ) * 5 * ( 8 + 7 * 2 ) * ( 4 *
		// 7 - 2 ) * 8"
		// ;
		// String inStr = "a + b * c + ( d * e + f ) * g" ;

		System.out.println(getPostfixFromInfix(inStr));
		// System.out.println(
		// calculatePostfixExpression(getPostfixFromInfix(inStr)));
	}
}
