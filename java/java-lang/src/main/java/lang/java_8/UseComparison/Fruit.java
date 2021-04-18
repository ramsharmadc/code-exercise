package lang.java_8.UseComparison;

public class Fruit implements Comparable<Fruit> {

    protected String name;
    protected Integer size;

    protected Fruit(String name, int size) {

        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Fruit o) {

        return this.size > o.size ? 1 : (this.size == o.size ? 0 : -1);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Fruit) {
            Fruit fruit_one = (Fruit) obj;
            return this.name.equals(fruit_one.name) && this.size == fruit_one.size;
        } else
            return false;
    }

    @Override
    public int hashCode() {

        return this.name.hashCode() * 31 + size;
    }

    @Override
    public String toString() {

        return this.name + " - " + this.size;
    }
}
