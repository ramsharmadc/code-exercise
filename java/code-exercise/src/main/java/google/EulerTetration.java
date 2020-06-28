package google;

import java.math.BigInteger;
import java.util.Scanner;

public class EulerTetration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			BigInteger m = in.nextBigInteger();
			BigInteger res = calcTetration(a, b);

			System.out.println("a=" + a);
			System.out.println("b=" + b);
			System.out.println("m=" + m);
			System.out.println("res=" + res);
		}
		in.close();
	}

	private static BigInteger calcTetration(int a, int b) {
		if (b == 1)
			return BigInteger.valueOf(a);
		else
			return BigInteger.valueOf((long) Math.pow(a, calcTetration(a, b - 1).doubleValue()));
	}
}
