package casestudy.misc;

public class LCM {

    public static int determineLCM(final int a, final int b) {

        int num1, num2;
        if (a > b) {
            num1 = a;
            num2 = b;
        } else {
            num1 = b;
            num2 = a;
        }
        for (int i = 1; i <= num2; i++) {
            if (((num1 * i) % num2) == 0)
                return i * num1;
        }
        throw new Error("Error");
    }

    public static void main(final String[] args) {

        final int d = determineLCM(3, 15);
        System.out.println(d);

    }
}
