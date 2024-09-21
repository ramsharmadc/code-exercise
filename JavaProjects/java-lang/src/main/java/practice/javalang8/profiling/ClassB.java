package practice.javalang8.profiling;

import java.util.HashMap;
import java.util.Map;

public class ClassB  {

    public static void main(String[] args) {

        ClassB b1 = new ClassB();

        Map<ClassA, Integer> m1 = new HashMap<>();

        ClassA key1 = new ClassA("Ram", 1, null);
        ClassA key2 = new ClassA("Ram", 1, null);
        ClassA key3 = new ClassA("Ram", 1, null);

        m1.put(key1, 1);
        m1.put(key2, 2);
        m1.put(key3, 3);

        int v = 20;
        v++;
    }
}