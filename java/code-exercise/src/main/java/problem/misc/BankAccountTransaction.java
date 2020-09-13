package problem.misc;

import java.util.Scanner;

public class BankAccountTransaction {

	static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
		double fees = 0;
		for (int i = 0; i < n; i++) {
			fees = fees + Math.max(k, ((0.01 * x) * p[i]));
		}
		return fees > d ? "upfront" : "fee";
	}

	private void calculatesTheYearlyTotal(){
		System.out.println("Yearly total = "+34324);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int x = in.nextInt();
			int d = in.nextInt();
			int[] p = new int[n];
			for (int p_i = 0; p_i < n; p_i++) {
				p[p_i] = in.nextInt();
			}
			String result = feeOrUpfront(n, k, x, d, p);
			System.out.println(result);
		}
		in.close();
	}
}