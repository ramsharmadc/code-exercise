package problemsolving.misc;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentInDictionary {

    public static void main(String[] args) {

        Set<String> dict = new HashSet<>();
        dict.add("wells");
        dict.add("fargo");
        dict.add("india");

        System.out.println(checkSegments("wellsfargo", dict));
        System.out.println(checkSegments("wellsindia", dict));
        System.out.println(checkSegments("bangalore", dict));
        System.out.println(checkSegments("wellindia", dict));
    }

    private static boolean checkSegments(String s, Set<String> dict) {
        for (int i = 0; i < s.length(); i++) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);
                return dict.contains(second) || checkSegments(second, dict);
            }
        }
        return false;
    }
}
