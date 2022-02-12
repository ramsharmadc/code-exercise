package practice.javalang8.collections.extendingIterable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorConcept {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final List<Integer> list = new LinkedList<Integer>();

        /*** HERE Iterator throws exception ***/
        // Iterator<Integer> itr = list.iterator();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        /*** HERE Iterator will work ***/
        final Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

}
