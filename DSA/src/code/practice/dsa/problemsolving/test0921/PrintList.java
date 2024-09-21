package dsa.problemsolving.test0921;

import java.util.ArrayList;
import java.util.List;

public class PrintList {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        printMyList(l, l.size(), l.size());
    }

    private static void printMyList(List<Integer> l, int n, int m) {
        if (l == null || n < 1)
            return;
        System.out.print(l.get(m - n) + " ");
        printMyList(l, n - 1, m);
    }
}
