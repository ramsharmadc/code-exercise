package problem.misc;

public class KnightsMinimumMoves {

	public static void main(String[] args) {
		int A = 4;
		int B = 5;
		int minMoves = calculateMinMoves(A, B);
		System.out.println(minMoves);
	}

	private static int calculateMinMoves(int A, int B) {
		int temp;
		if (A < 0) {
			A = -A;
		}
		if (B < 0) {
			B = -B;
		}
		if (A > B) {
			temp = A;
			A = B;
			B = temp;
		}
		if (B == (2 * A)) {
			return A;
		}
		if (A == B) {
			if ((A % 3) == 0) {
				return 2 * (A / 3);
			}
			if ((A % 3) == 1) {
				return 2 + 2 * (A - 1) / 3;
			}
			if ((A % 3) == 1) {
				return 4 + 2 * (A - 2) / 3;
			}
		}
		if (A == 0) {
			if ((B % 4) == 0) {
				return B / 2;
			}
			if (((B % 4) == 1) || ((B % 4) == 3)) {
				return 3 + (B - (B % 4)) / 2;
			}
			if ((B % 4) == 2) {
				return 2 + (B - 2) / 2;
			}
		}
		if (B > 2 * A) {
			return calculateMinMoves(2 * A - B, 2 * A - B) + calculateMinMoves(B - A, 2 * (B - A));
		} else {
			return calculateMinMoves(0, B - (2 * A)) + calculateMinMoves(A, 2 * A);
		}
	}
}
