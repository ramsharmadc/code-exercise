package code.java.lang.genericz;

public class Office extends Building {

    int size;
    String name;

    public Office(int area, int location, int size, String name) {
        super(area, location);
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Office:: " + size + ", " + name;
    }
}
