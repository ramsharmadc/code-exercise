package lang.java_8.abstract_class;

public abstract class AbstractClassB extends AbstractClassA {

    /*
     * @Override void abstractMethod() { // TODO Auto-generated method stub }
     */

    // abstract class can have constructor
    public AbstractClassB() {
        System.out.println("constructor of an abstract class");
    }

    public abstract void meth();

}
