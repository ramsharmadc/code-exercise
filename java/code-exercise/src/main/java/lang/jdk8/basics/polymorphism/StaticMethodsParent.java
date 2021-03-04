package lang.jdk8.basics.polymorphism;

public class StaticMethodsParent extends Parent {

    Parent p = new Parent(10);

    public StaticMethodsParent() {

        System.out.println("Before...");
        getNumberFrom();
        System.out.println("After...");
    }

    public static String getString() {

        return "StaticMethodsParent class";
    }

    @Override
    public Integer foo(Number nbr) {

        // TODO Auto-generated method stub
        super.foo(nbr);
        return (Integer) nbr;
    }

    private int getNumber() {

        return 0;
    }

    public Object getNumberFrom() {

        System.out.println("Parent's getNumberFrom()");
        return 0;
    }
}
