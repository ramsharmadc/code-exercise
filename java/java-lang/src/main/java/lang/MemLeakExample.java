package lang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MemLeakExample {


    // A a = new A();

    public void generateAObjects(List<A> l) {

        while (true) {
            A a = new A();
            l.add(a);
            System.out.println("added");
        }

    }

    public static void main(String args[]) {

        MemLeakExample m1 = new MemLeakExample();

        List<A> listOfA = new LinkedList<>();

        m1.generateAObjects(listOfA);

    }
}

    class A {
        String s;
        List l;
    }


