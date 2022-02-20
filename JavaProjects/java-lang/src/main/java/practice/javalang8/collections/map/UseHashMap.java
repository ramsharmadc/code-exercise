package practice.javalang8.collections.map;

import java.util.HashMap;
import java.util.Map;

class UseHashMap {

    public static void main(final String[] args) {

        final Map<String, String> newMap = new HashMap<String, String>();

        for (int i = 0; i < 10; i++) {
            newMap.put("Key", "value".concat(String.valueOf(i)));
        }

        System.out.println(newMap);

        setNull(newMap);

        System.out.println(newMap.size());
        System.out.println(newMap);

    }

    private static void setNull(Map<String, String> map) {

        // the local map just got the address, its not the actual object
        if (map != null) {
            // map.clear(); // clear will work, but making null doesn't

            map = null;
        }

        // this will give NPE
        // System.out.println(map.size());
    }
}
