package dsa.problemsolving.misc;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

    public static boolean checkAnagram(final String one, final String two) {
        final Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (final Character c : one.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c) + 1));
            } else {
                map.put(c, 1);
            }
        }

        for (final Character c : two.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c) - 1));
            } else {
                map.put(c, 1);
            }
        }

        for (final Character e : map.keySet()) {
            if (map.get(e) > 0)
                return false;
        }

        return true;
    }

    public boolean isAnagaramOptimized(String strActual, String strGiven) {

        for (char c : strActual.toCharArray()) {
            int pivot = strGiven.indexOf(c);
            if (pivot != -1) {
                String tmpLeft = strGiven.substring(0, strGiven.indexOf(c));
                String tmpRight = strGiven.substring(strGiven.indexOf(c) + 1);
                strGiven = tmpLeft + tmpRight;
            }
        }

        return strGiven.trim().equals("");
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final String one = "COT";
        final String two = "OTC";
        final boolean b = new CheckAnagram().isAnagaramOptimized(one, two);
        System.out.println(b);


    }
}
