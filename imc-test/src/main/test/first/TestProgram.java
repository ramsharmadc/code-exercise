package main.test.first;

import main.java.imctest.first.AreaVisitor;
import main.java.imctest.first.Circle;
import main.java.imctest.first.Rectangle;
import main.java.imctest.first.Triangle;

import java.util.Random;

public class TestProgram {

    public static void main(String[] args) {

        AreaVisitor areaVisitor = new AreaVisitor();
        ;

        for (int i = 0; i < 100; i++) {

            areaVisitor.visitCircle(getRandomCircle(i + 121));
        }

        for (int i = 0; i < 100; i++) {

            areaVisitor.visitRectangle(getRandomRectangle(i + 121));
        }

        for (int i = 0; i < 100; i++) {

            areaVisitor.visitTriangle(getRandomTriangle(i + 121));
        }
    }

    private static Circle getRandomCircle(long seed) {
        return new Circle(new Random(seed).nextDouble());
    }

    private static Triangle getRandomTriangle(long seed) {
        return new Triangle(new Random(seed + 1).nextDouble(),
                new Random(seed + 2).nextDouble(),
                new Random(seed + 3).nextDouble());
    }

    private static Rectangle getRandomRectangle(long seed) {
        return new Rectangle(new Random(seed + 1).nextDouble(),
                new Random(seed + 2).nextDouble(),
                new Random(seed + 3).nextDouble());
    }
}
