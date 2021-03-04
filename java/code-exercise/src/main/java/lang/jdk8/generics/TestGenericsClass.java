package lang.jdk8.generics;

import java.util.Vector;

public class TestGenericsClass {

    public static void main(String[] args) {

        Vector<String> stringVector = new Vector<>();
        Vector<Integer> intVector = new Vector<>();

        System.out.println(stringVector.getClass());
        System.out.println(intVector.getClass());

        System.out.println(stringVector.getClass() == intVector.getClass());
        System.out.println(stringVector.getClass().equals(intVector.getClass()));
    }
}
