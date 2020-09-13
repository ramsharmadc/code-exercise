package lang.jdk8.genericz;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CheckGenerics {

    public static void main(String[] args) {

        Spliterator spliterator = new Spliterator() {
            @Override
            public boolean tryAdvance(Consumer action) {
                return false;
            }

            @Override
            public Spliterator trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }
        };
        List<Building> bl = new ArrayList<>();

        bl.add(new Building(12, 35));
        bl.add(new Building(14, 55));

        bl.add(new Office(2, 15, 30, "SEZ"));
        bl.add(new Office(3, 25, 20, "HiTech"));

        bl.stream().forEach(x -> System.out.println(x));

        List l = new ArrayList();
        l.add("A String");
        l.add(1);
        l.add(true);
        l.forEach(x -> System.out.println(x));

    }
}
