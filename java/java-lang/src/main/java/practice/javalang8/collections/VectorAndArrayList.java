package practice.javalang8.collections;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorAndArrayList {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("Sample String");

        vector.add("Sample String");
        list.add("Sample String");
    }
}
