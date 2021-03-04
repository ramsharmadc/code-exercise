package casestudy.misc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NewComparator implements Comparator<Object> {

    public static void main(String[] args) {

        NewComparator n = new NewComparator();
        A a = n.new A();
        B b = n.new B();

        List<A> la = new LinkedList<>();

        // Collections.sort(la, new NewComparator());

        new NewComparator().compare(a, b);
    }

    @Override
    public int compare(Object o1, Object o2) {

        A a = (A) o1;
        B b = (B) o2;

        return a.i = b.i;
    }

    class A {
        int i = 1;
    }

    class B {
        int i = 1;
    }
}
