package problemsolving.misc;

public class CheckNotRepeating {

    public static void main(String[] args) {

        int[] a = {23, 45, 56, 78, 90, 12, 23, 45, 56, 78, 90, 34, 12, 34};
        int nonRepeat = 0;

        try {
            for (int m : a) {
                nonRepeat ^= m;
            }
        } catch (ArithmeticException e) {
            switch ("str") {
                case "str":
                    System.out.println("found");
            }
        }

        if (nonRepeat != 0) {
            System.out.println("This was not repeating :: " + nonRepeat);
        } else
            System.out.println("Every digit is repeating.");
    }

}
