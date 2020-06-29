package lang.functional;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FunctionalProgram {

    public static Predicate<Integer> IsPrimePredicate = x -> {
        return x > 1 && IntStream.range(2, x).noneMatch(y -> x % y == 0);
    };
    static Function<Integer, Integer> addOne = n -> n + 1;
    static Function<Integer, Integer> multiplyTen = n -> n * 10;

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));

        System.out.println(IsPrimePredicate.test(6));
        System.out.println(IsPrimePredicate.test(7));
        System.out.println(IsPrimePredicate.test(11));

        System.out.println(addOne.andThen(multiplyTen).apply(2));
    }

    public static boolean isPrime(int x) {
        return x > 1 && IntStream.range(2, x).noneMatch(y -> x % y == 0);
    }
}