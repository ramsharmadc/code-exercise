package lang.java_8.innerclasses;

public class ParentClass2 {

    public static void main(final String[] args) {

        // how to create a non-static AND static inner class object
        final ParentClass2.InnerClass1 inObj = new ParentClass2().new InnerClass1(); // we
        // need
        // a
        // ParentClass2
        // object
        inObj.print();

        new ParentClass2.NestedClass();
        // object
        inObj.print();
    }

    static class NestedClass {

        void print() {

            System.out.println("ParentClass2.NestedClass.print()");
        }
    }

    class InnerClass1 {

        void print() {

            System.out.println("ParentClass2.InnerClass1.print()");
        }
    }
}
