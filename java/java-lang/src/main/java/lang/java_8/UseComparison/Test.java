package lang.java_8.UseComparison;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Apple a1 = new Apple(50);
        Apple a2 = new Apple(30);

        Orange o1 = new Orange(40);
        Orange o2 = new Orange(35);

        List<Apple> apples = Arrays.asList(a1, a2);
        System.out.print(apples);
        System.out.println(" Big Apple: " + Collections.max(apples));

        List<Orange> oranges = Arrays.asList(o1, o2);
        System.out.print(oranges);
        System.out.println(" Big Orange: " + Collections.max(oranges));

    }
}
