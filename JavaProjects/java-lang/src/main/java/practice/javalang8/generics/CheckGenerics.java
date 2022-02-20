package practice.javalang8.generics;

import java.util.ArrayList;
import java.util.List;

public class CheckGenerics {
    public static void main(String[] args) {
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
