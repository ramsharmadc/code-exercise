package lang.jdk8.basics.abstractclasses;

public abstract class AbstractClassA extends ClassA {

    // abstract class can have private methods with implementation
    private static void hello() {
        System.out.println("This is a private non-abstract method which can be used internally.");
    }

    public static void main(String[] args) {
        hello();
    }

    // default scope
    abstract void abstractMethod();

    // here a non-abstract method is overridden by an abstract method
    @Override
    public abstract void methodOne();

    public abstract void meth();
}
