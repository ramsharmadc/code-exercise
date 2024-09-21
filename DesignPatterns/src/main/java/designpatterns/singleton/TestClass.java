package designpatterns.singleton;

import java.util.stream.IntStream;

public class TestClass extends SampleSingletonClass {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        Sequence sequence = Sequence.getInstance();
        int i = 0;
        while (i++ < 100000)
            System.out.print(Sequence.next() + " ");

        System.out.println("\nUsing stream now");
        IntStream.range(0, 100000).parallel().forEach(c -> System.out.print(Sequence.next() + " "));
    }

}
