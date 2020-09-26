package lang.jdk8.generics;

import java.util.Objects;

public class Pair<T, U> {

    private final T key;
    private final U value;

    public Pair(final T key, final U value) {
        this.key = key;
        this.value = value;
    }

    public static void main(final String[] args) {
        final Pair<Integer, String> pair = new Pair<Integer, String>(1, "One");
        System.out.println(pair.getKey() + " : " + pair.getValue());
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
