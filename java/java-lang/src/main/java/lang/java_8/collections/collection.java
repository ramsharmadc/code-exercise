package lang.java_8.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class collection<T> {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
        System.out.println(list);
        // int a = list.toArray(new int[0]); // this will not compile
        System.out.println(list.toArray());

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static <T extends Comparable<T>> T max(Collection<T> col) {
        Iterator<T> itr = col.iterator();
        T max = null;
        if (itr != null && itr.hasNext())
            max = itr.next();

        while (itr.hasNext()) {
            T current = itr.next();
            if (max == null || max.compareTo(current) < 0)
                max = current;
        }
        return max;
    }
}
