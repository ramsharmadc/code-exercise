package lang.jdk8.interfaces;

import java.util.stream.Stream;

public class MyFunctionalInterfaceClass implements MyFunctionalInterface {

    @Override
    public Object apply(Object o) throws IllegalArgumentException {
        throw new IllegalArgumentException("invalid arg");
    }

    public static void main(String[] args) {

        MyFunctionalInterfaceClass obj = new MyFunctionalInterfaceClass();

        Stream.of(1, 2, 3).map(obj).forEach(x -> System.out.println(x));
    }
}
