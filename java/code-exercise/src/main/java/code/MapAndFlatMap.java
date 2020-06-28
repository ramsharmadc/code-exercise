package code;

import java.util.*;

public class MapAndFlatMap {

    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(12, 56, 90, 45, 67, 79);

        l.stream().filter(x -> x > 50).forEach(y -> System.out.print(y + " "));

        System.out.println();

        Integer m = l.stream().max(Comparator.comparingInt(i -> i)).orElse(0);
        System.out.print(m);
        System.out.println();

        Map<Integer, Integer> mp1 = new HashMap<>();
        mp1.put(1, 1);
        mp1.put(2, 2);
        for (Map.Entry<Integer, Integer> e : mp1.entrySet()) {
            System.out.println(e.getKey() + " :: " + e.getValue());
        }
    }
}
