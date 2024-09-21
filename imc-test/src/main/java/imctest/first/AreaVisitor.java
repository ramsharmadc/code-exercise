package main.java.imctest.first;

public class AreaVisitor implements ShapeVisitor {

    private Area computedArea;

    @Override
    public void visitCircle(Circle circle) {
        double radius = circle.getRadius();
        computedArea = new Area(Math.PI * radius * radius);
    }

    @Override
    public void visitTriangle(Triangle triangle) {
       double semiperimeter = (triangle.getSideA() + triangle.getSideB() + triangle.getSideC())/2;
       computedArea = new Area(Math.sqrt(
               semiperimeter*(semiperimeter-triangle.getSideA())*
                       (semiperimeter-triangle.getSideB())*
                       (semiperimeter-triangle.getSideC())));
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double height = rectangle.getHeight();
        double breadth = rectangle.getBreadth();
        double length = rectangle.getLength();
        computedArea = new Area( height * breadth * length);
    }

    public Area getComputedArea() {
        return computedArea;
    }
}
