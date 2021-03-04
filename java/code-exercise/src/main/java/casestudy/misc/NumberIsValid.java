package casestudy.misc;

import java.util.Arrays;

/**
 * 4.325 is a valid number.
 * <p>
 * 1.1.1 is NOT a valid number.
 * <p>
 * 222 is a valid number.
 * <p>
 * 22. is NOT a valid number.
 * <p>
 * 0.1 is a valid number.
 * <p>
 * 22.22. is NOT a valid number.
 */
public class NumberIsValid {

    public static void main(String[] args) {

        String[] s = {"4.325", "1.1.1", ".222", "22.", "0.1", "22.22."};

        Arrays.stream(s).iterator().forEachRemaining(x -> {
            boolean b = validNumber(x);
            System.out.println("isValid(" + x + ") => " + b);
        });
    }

    private static boolean validNumber(String s) {

        if (s == null || s == "" || s.length() == 0)
            return true;

        if (s.indexOf(".") == -1) return true;

        if (s.indexOf(".") == s.length() - 1 ||
                s.indexOf(".") == 0) return false;

        else
            return validNumber(s.substring(0, s.indexOf("."))) &&
                    validNumber(s.substring(s.indexOf(".") + 1));
    }
}
