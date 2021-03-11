package dsa.problemsolving.misc;

public class Swap3Numbers {

    public static void main(final String[] args) {
        final int a = 7, b = 9, c = 6, d = 4;
        System.out.format("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
        swap3Numbers(a, b, c);
        swap4Numbers(a, b, c, d);
    }

    private static void swap3Numbers(int a, int b, int c) {
        final int temp1 = b;
        b = a;
        a = c;
        c = temp1;
        System.out.format("a = %d, b = %d, c = %d\n", a, b, c);
    }

    private static void swap4Numbers(int a, int b, int c, int d) {
        final int temp = b;
        b = a;
        a = d;
        d = c;
        c = temp;
        System.out.format("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
    }
}
