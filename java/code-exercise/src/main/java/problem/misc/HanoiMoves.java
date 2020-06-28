package problem.misc;

public class HanoiMoves {
	private static int count = 6;

	public static void hanoi(int N, char from, char temp, char to) {
		if (N > 0) {
			hanoi(N - 1, from, temp, to);
			System.out.println("Move: " + (++count) + ", Moving disc from " + from + " to " + to);
			hanoi(N - 1, temp, from, to);
		}
	}

	public static void main(String[] args) {
		hanoi(10, 'A', 'B', 'C');
	}
}
