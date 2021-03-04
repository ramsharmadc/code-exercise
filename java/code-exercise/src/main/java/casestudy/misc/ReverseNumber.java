package casestudy.misc;

import java.util.Scanner;

public class ReverseNumber {

    public int n, reverse;

    public static void main(final String[] args) {
        ReverseNumber r = new ReverseNumber();
        System.out.println("Enter the number to reverse: ");
        try (final Scanner in = new Scanner(System.in)) {
            r.n = in.nextInt();
            r.reverse = r.reverse(r.n);
        }
        System.out.println("Reverse of entered number is " + r.reverse);
    }

    public int reverse(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse = reverse * 10;
            reverse = reverse + (n % 10);
            n = n / 10;
        }
        return reverse;
    }
}
