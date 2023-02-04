package practice.javalang8.polymorphism;

public class BaseClass {

    protected Object getObject() {
        return null;
    }

    public StaticMethodsParent getStaticMethod() {
        return null;
    }

    private Object nextObject() {
        System.out.println("this could be the next object in the line.");
        return getObject();
    }
}
