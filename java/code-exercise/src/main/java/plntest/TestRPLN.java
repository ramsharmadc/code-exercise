package plntest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRPLN {

	private ReversePolishNotationCalculator rplnCalc;

	@Before
	public void init() {
		rplnCalc = new ReversePolishNotationCalculator();
	}

	@Test
	public void checkRPLNAddition() {
		String exp = "3 4 +";
		int res = rplnCalc.calculate(exp);
		Assert.assertEquals(7, res);
	}

	@Test
	public void checkRPLNSubtract() {
		String exp = "5 3 -";
		int res = rplnCalc.calculate(exp);
		Assert.assertEquals(2, res);
	}

	@Test
	public void checkRPLNMultiply() {
		String exp = "3 4 *";
		int res = rplnCalc.calculate(exp);
		Assert.assertEquals(12, res);
	}

	@Test
	public void checkRPLNMDivide() {
		String exp = "6   3 / "; // / 3 12
		int res = rplnCalc.calculate(exp);
		Assert.assertEquals(2, res);
	}

	@Test
	public void checkRPLNMComplex() {
		String exp1 = "15 7 1 1 + - /  3 * 2 1 1 + + -"; // / 3 12
		int res1 = rplnCalc.calculate(exp1);
		Assert.assertEquals(5, res1);

		String exp2 = "12 4 1 - /"; // / 3 12
		int res2 = rplnCalc.calculate(exp2);
		Assert.assertEquals(4, res2);

		String exp3 = "12 4 / 1  -"; // / 3 12
		int res3 = rplnCalc.calculate(exp3);
		Assert.assertEquals(2, res3);
	}
}
