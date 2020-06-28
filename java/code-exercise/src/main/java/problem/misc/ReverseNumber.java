package problem.misc;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(final String[] args) {
		int n, reverse;
		System.out.println("Enter the number to reverse: ");
		try (final Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			reverse = reverse(n);
		}
		System.out.println("Reverse of entered number is " + reverse);
	}

	public static int reverse(int n) {
		int reverse = 0;
		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + (n % 10);
			n = n / 10;
		}
		return reverse;
	}
}
