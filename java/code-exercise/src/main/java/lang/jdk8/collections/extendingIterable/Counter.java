package lang.jdk8.collections.extendingIterable;

import java.util.Iterator;

public class Counter implements Iterable<Integer> {

    private final int limit;

    Counter(final int size) {

        limit = size;
    }

    public static void main(final String[] args) {

        final Counter count = new Counter(20);

        for (final int i : count) {
            System.out.print(i + "|");
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            private int i = 1;

            @Override
            public boolean hasNext() {

                return i <= limit;
            }

            @Override
            public Integer next() {

                return i++;
            }

            @Override
            public void remove() {

                i--;
            }
        };
    }
}
