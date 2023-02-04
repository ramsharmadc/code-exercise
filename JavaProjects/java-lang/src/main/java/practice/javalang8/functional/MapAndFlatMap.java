package practice.javalang8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

    public static void main(String[] args) {
        List<Object> l1 = Arrays.asList(12, 56, 90, 45, 67, 79);

        l1.forEach(System.out::print);
        System.out.println();

        List<Object> l2 = l1.stream().map(x ->
                x.toString()).collect(Collectors.toList());
        System.out.println(l2);

        List<Object> l3 = Stream.of(l1, l2).flatMap(x ->
                Arrays.stream(x.toArray())).collect(Collectors.toList());
        System.out.println(l3);

        l1.stream().sorted().map(x -> Objects.hash(x)).forEach(x ->
                System.out.print(x + " "));
    }
}
