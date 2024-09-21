package main.java.imctest.first;

import java.util.Objects;

public class Area {

    private double value;

    public Area(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area area)) return false;
        return Double.compare(value, area.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
