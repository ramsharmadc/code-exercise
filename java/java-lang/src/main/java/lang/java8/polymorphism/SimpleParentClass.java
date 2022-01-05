package lang.java8.polymorphism;

class SimpleChildClass extends SimpleParentClass {

    // public void makeNull() throws Exception { //not compile
    @Override
    public void makeNull() throws NullPointerException {

    }
}


public class SimpleParentClass {

    public void makeNull() throws Exception {

        System.out.println("SimpleParentClass");
    }
}
