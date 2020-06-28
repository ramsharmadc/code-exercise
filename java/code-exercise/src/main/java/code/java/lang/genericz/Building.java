package code.java.lang.genericz;

public class Building {

    int area;
    int location;

    public Building(int area, int location) {
        this.area = area;
        this.location = location;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Building: " + area + ", " + location;
    }
}
