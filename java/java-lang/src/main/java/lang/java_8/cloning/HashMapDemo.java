package lang.java_8.cloning;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(final String[] args) {

        // create two hash maps
        final HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, String> clonedMap;

        // populate 1st map
        map.put(1, "tutorials");
        map.put(2, "point");
        map.put(3, "is best");

        // clone 1st map
        clonedMap = (HashMap<Integer, String>) map.clone();

        // first check if they are same references
        System.out.println("Are the original and cloned map share same reference ? "
                + ((map == clonedMap) ? "YES" : "NO"));

        // after cloning
        System.out.println("1st Map: ");
        System.out.println(map);
        System.out.println("2nd Map (cloned): ");
        System.out.println(clonedMap);

        // changes in the cloned map
        clonedMap.put(4, "Four");

        System.out.println("after changes in cloned map");
        System.out.println("1st Map: ");
        System.out.println(map);
        System.out.println("2nd Map (cloned): ");
        System.out.println(clonedMap);
    }
}
