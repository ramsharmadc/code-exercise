package lang.java8.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class KnowStreams {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, KnowStreams.Type.MEAT),
                new Dish("beef", false, 700, KnowStreams.Type.MEAT),
                new Dish("chicken", false, 400, KnowStreams.Type.MEAT),
                new Dish("french fries", true, 530, KnowStreams.Type.OTHER),
                new Dish("rice", true, 350, KnowStreams.Type.OTHER),
                new Dish("season fruit", true, 120, KnowStreams.Type.OTHER),
                new Dish("pizza", true, 550, KnowStreams.Type.OTHER),
                new Dish("prawns", false, 300, KnowStreams.Type.FISH),
                new Dish("salmon", false, 450, KnowStreams.Type.FISH));

        exploreStreams(menu);
    }

    private static void exploreStreams(List<Dish> menu) {
        List<String> threeHighestCalorieDishes =
                menu.stream().
                        filter(x -> {
                            System.out.println("filtering " + x.name);
                            return x.getCalories() > 500;
                        }).
                        limit(3).
                        sorted(Comparator.comparingInt(x -> x.calories)).
                        map(x -> {
                            System.out.println("mapping " + x.name);
                            return x.name;
                        }).
                        collect(Collectors.toList());
        System.out.println(threeHighestCalorieDishes);

    }

    public enum Type {MEAT, FISH, OTHER}

    static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
