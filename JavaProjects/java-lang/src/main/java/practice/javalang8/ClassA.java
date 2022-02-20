package practice.javalang8;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ClassA {

    private final String name;
    private final int id;
    private final List<Integer> l;

    private ClassA() {
        name = "";
        id = 0;
        l = Collections.emptyList();
    }

    public ClassA(String name, int id, List<Integer> l) {
        this.name = name;
        this.id = id;
        this.l = Collections.unmodifiableList(l == null ? Collections.emptyList() : l);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getL() {
        return l;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof ClassA)) return false;

        ClassA that = (ClassA) o;

        return this.name.equals(that.name) &&
                this.id == that.id &&
                this.l.equals(that.l);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, l);
    }
}
