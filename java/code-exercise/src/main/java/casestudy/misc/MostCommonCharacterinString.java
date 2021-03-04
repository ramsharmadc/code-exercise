package casestudy.misc;

import java.util.HashMap;
import java.util.Map;

public class MostCommonCharacterinString {

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();

        String str = "ABCCDEEFGHabcddeeeef";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            System.out.println(c);

            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 0);
            }
        }
    }
}
