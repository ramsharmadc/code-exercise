package practice.javalang8.abstract_class;

public abstract class AbstractClassA extends ClassA {

    // abstract class can have private methods with implementation
    private static void hello() {
        System.out.println("This is a private non-abstract method which can be used internally.");
    }

    public AbstractClassA(){
        System.out.println("Abstract classes can have constructors as to initialize " +
                "the attributes of their own but  we can " +
                "not create instances of Abstract classes.");
    }

    public static void main(String[] args) {
        hello();

        // AbstractClassA abstractClassA = new AbstractClassA();
    }

    // default scope
    abstract void abstractMethod();

    // here a non-abstract method is overridden by an abstract method
    @Override
    public abstract void methodOne();

    public abstract void meth();
}
