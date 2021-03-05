package problemsolving.misc;

import java.util.HashMap;
import java.util.Map;

public class ConvertNumberToItsName {

    private final static String[] constantStrings = {"Zero", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static String convertNumberToItsName(final Integer i) {

        if (i == null)
            return null;

        final StringBuilder str = new StringBuilder();

        final Map<Integer, String> numberToString = createOneToNineMap();

        System.out.println(numberToString);

        return str.toString();
    }

    private static Map<Integer, String> createOneToNineMap() {

        final Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            map.put(i, constantStrings[i]);
        }

        return map;
    }

    public static void main(final String[] args) {

        convertNumberToItsName(1900);
    }
}
