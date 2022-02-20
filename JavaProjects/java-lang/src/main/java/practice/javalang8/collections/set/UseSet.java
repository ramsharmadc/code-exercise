package practice.javalang8.collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseSet implements Comparable<Object> {

    public UseSet() {

    }

    public static void main(final String[] args) {

        Set<String> strSet = new HashSet<>();
        strSet.add("RAM");
        strSet.add("RAM");
        System.out.println(strSet);

        // checkTreeSet();
    }

    private static void checkTreeSet() {
        final UseSet obj_01 = new UseSet();
        final UseSet obj_02 = new UseSet();
        final Set<UseSet> set_01 = new TreeSet<>();
        set_01.add(obj_01);
        set_01.add(obj_01);
        set_01.add(obj_02);
        System.out.println(set_01);
    }

    @Override
    public int compareTo(final Object o) {

        // return -1; // adds all 3 same objects
        // return 1; // adds all 3 same objects
        // return 0;
        return o.hashCode();// * (int) Math.random();
    }

    @Override
    public boolean equals(final Object obj) {
        return 1 != 2;
    }

    @Override
    public String toString() {
        return "obj1";
    }
}
