package dsa.problemsolving.misc;

import java.util.Hashtable;
import java.util.Map;

public class ThreeHashMapAndOneCommon {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Map<Integer, String> table1 = new Hashtable<>();
        final Map<Integer, String> table2 = new Hashtable<>();
        final Map<Integer, String> table3 = new Hashtable<>();

        table1.put(1, "common");
        table2.put(1, "common");
        table3.put(1, "common");

        final Map<Integer, String> table4 = new Hashtable<>();

        for (final Map.Entry<Integer, String> entry : table1.entrySet()) {
            // this is common in all three tables
            if (table2.containsValue(entry.getValue()) && table3.containsValue(entry.getValue())) {
                table4.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(table4);
    }

}
