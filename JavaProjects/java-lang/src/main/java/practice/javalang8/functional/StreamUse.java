package practice.javalang8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUse {

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(23);
        l.add(13);

        // use stream on a list
        l.stream().findAny().ifPresent(x -> System.out.println(x));

        // throws ConcurrentModificationException
        // l.stream().forEach(x -> l.add(x));

        // a way to create stream
        Stream.of(3, 7, 1).iterator().forEachRemaining(System.out::print);

        // a way to create stream
        Stream.Builder<Integer> streamBldr = Stream.builder();
        streamBldr.accept(2);
        streamBldr.accept(3);
        streamBldr.accept(9);

        streamBldr.build().forEach(x -> l.add(x));






        Stream.of(4, 3, 5, 8, 6, 1).sorted(Integer::compare).forEach(StreamUse::accept);
        List<Integer> l1 = Stream.of(4, 3, 5, 8, 6, 1).parallel().
                sorted(Integer::compare).
                collect(Collectors.toList());


    }

    private static void accept(Integer x) {
        System.out.println(x);
    }
}
