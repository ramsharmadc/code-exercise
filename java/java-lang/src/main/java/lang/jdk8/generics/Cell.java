package lang.jdk8.generics;

import java.util.LinkedList;
import java.util.List;

public class Cell<T> {

    private static int count = 0;
    private final int id;
    private final T value;

    // private static List<T> values = new ArrayList<T>(); // illegal

    public Cell(final T value) {
        this.value = value;
        id = nextId();
    }

    public static synchronized int getCount() {
        return count;
    }

    // public static List<T> getValues() { return new LinkedList();} // illegal
    public static List<Object> getValues() {
        return new LinkedList<>();
    } // it's fine

    public static void main(final String[] args) {
        final Cell<String> strCell = new Cell<String>("value");
        final Cell<Integer> intCell = new Cell<Integer>(1);
        System.out.println(strCell.getId() + ", " + intCell.getId());
        System.out.println(Cell.getCount());
    }

    private static synchronized int nextId() {
        return count++;
    }

    public int getId() {
        return id;
    }

    public T getValue() {
        return value;
    }
}
