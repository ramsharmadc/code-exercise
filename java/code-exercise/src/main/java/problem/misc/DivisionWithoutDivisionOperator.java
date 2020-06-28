package problem.misc;

/**
 * Implement division without using division operator in log(n) time. solution:
 * use bitwise shifting
 * 
 * @author ramsh
 */
public class DivisionWithoutDivisionOperator {

	private final Integer n = 98;
	private final Integer d = 1; // right shift divides by 2^d

	public static void main(final String[] args) {

		final DivisionWithoutDivisionOperator obj = new DivisionWithoutDivisionOperator();

		final int ans = ((obj.n >> obj.d) >> obj.d);

		System.out.println(ans);
	}

	// 12 3 3 + 3 + 3 + 3
}
