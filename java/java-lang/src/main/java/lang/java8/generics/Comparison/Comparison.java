package lang.java8.generics.Comparison;

public class Comparison<T> implements Comparable<T> {

    private final T value;

    public Comparison() {

        this.value = null;
    }

    public Comparison(final T value) {

        this.value = value;
    }

    public static void main(final String[] args) {

        final Comparison<Integer> int_01 = new Comparison<>(12);
        final Comparison<Integer> int_02 = new Comparison<>(17);

        System.out.println(int_01.compareTo(int_02.value)); // for Integer, it
        // returns only -1,
        // 0, 1

        final Comparison<String> str_01 = new Comparison<>("one");
        final Comparison<String> str_02 = new Comparison<>("zero");

        // for String, it returns the magnitude of the diff
        System.out.println(str_01.compareTo(str_02.value));

        // System.out.println(str_01.compareTo(null));
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(final T int_02) {
        assert this.value != null;
        return ((Comparable<T>) this.value).compareTo(int_02);
    }

    @Override
    public boolean equals(final Object obj) {
        return this.value == obj;
    }
}
