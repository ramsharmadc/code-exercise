package main.java.imctest.first;

import java.util.Objects;

public class Rectangle implements Shape{

    private double height;
    private double length;
    private double breadth;

    public Rectangle(double height, double length, double breadth) {
        this.height = height;
        this.length = length;
        this.breadth = breadth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Double.compare(height, rectangle.height) == 0 && Double.compare(length, rectangle.length) == 0 && Double.compare(breadth, rectangle.breadth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, length, breadth);
    }

    @Override
    public String toString() {
        return STR."Rectangle{height=\{height}, length=\{length}, breadth=\{breadth}\{'}'}";
    }

    @Override
    public void accept(ShapeVisitor shapeVisitor) {
        shapeVisitor.visitRectangle(this);
    }

}
