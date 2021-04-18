package lang.java_8.wrapper;

import java.util.Collections;
import java.util.LinkedList;

public class WrapperCheck {

    public static void main(String[] args) {

        int a = 4;
        int b = 5;
        int c = 6;
        int d = 7;
        int e = 8;
        int f = 9;

        Object[] marr = {1, 2, 3, 4, 5};
        Object m = marr;

        LinkedList<Integer> lst = new LinkedList<Integer>();
        Collections.sort(lst);

        lst.add(a);
        lst.add(b);
        lst.add(c);
        lst.add(d);
        lst.add(e);
        lst.add(f);

        System.out.println(lst);

    }

}
