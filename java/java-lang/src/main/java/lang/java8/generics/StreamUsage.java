package lang.java8.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage {

    static Function<Integer, Integer> increment = x -> {
        if (x < 0)
            throw new RuntimeException();
        try {
            function();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(x + 10);
        return x + 10;
    };

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        List<Integer> m = l.stream().map(x -> 8 * x).collect(Collectors.toList());
        // m.stream().forEach(x -> System.out.println(x));

        // Stream.of(l).forEach(c -> System.out.println(c));

        Stream.of(m).map(x -> increment).forEach(c -> c.apply(1));
    }

    private static void function() throws Exception {
        throw new Exception("Hello");
    }
}
