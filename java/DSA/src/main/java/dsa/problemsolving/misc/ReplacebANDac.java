package dsa.problemsolving.misc;

import java.util.Arrays;

public class ReplacebANDac {

    public static String[] eliminateBandAC(final String[] arr) {

        final String[] toReturn = new String[arr.length];
        int i = 0;
        StringBuilder tm = null;

        for (final String str : arr) {
            tm = new StringBuilder();

            if (str.contains("ac")) {
                tm.append(str.replace("ac", ""));
            } else if (str.contains("b")) {
                tm.append(str.replace("b", ""));
            } else {
                tm.append(str);
            }

            toReturn[i++] = tm.toString();
        }

        return toReturn;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final String[] arr = {"abbccac", "acbac", "react"};

        // eliminateBandAC(arr);
        System.out.println(Arrays.toString(eliminateBandAC(arr)));

        // Array
    }

}
