package designpatterns.builder;

public class TestBuilderClass {

    public static void main(String[] args) {

        UseBuilderPattern.ObjectBuilder objectBuilder = new UseBuilderPattern.ObjectBuilder();

        objectBuilder.addId(2);
        objectBuilder.addAge(31);

        UseBuilderPattern myObj = objectBuilder.build();

        new UseBuilderPattern(2, 31);
    }
}
