package lang.java_8.collections.map;

import java.util.TreeMap;

public class SortedMap {

    public static void main(final String[] args) {

        final TreeMap<String, String> map = new TreeMap<>();

        map.put("first", "first");
        map.put("second", "second");
        map.put("third", "third");

        final java.util.SortedMap<String, String> sortedMap = map.subMap("first", "third");

        System.out.println(sortedMap);
    }
}
