package main.java.imctest.first;

public interface ShapeVisitor {

    void visitCircle(Circle circle);

    void visitTriangle(Triangle triangle);

    void visitRectangle(Rectangle rectangle);
}
