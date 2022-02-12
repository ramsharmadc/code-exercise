package practice.javalang8.inheritance;

public class ClassB extends ClassA {

    public void met1OfB() {
        System.out.println("met1OfB()");
    }

    /*
     * @Override protected void met1OfA() { System.out.println("Overriding in ClassB");
     * super.met1OfA(); }
     */

    @Override
    public void met2OfA() {
        System.out.println("Overriding in ClassB");
        super.met2OfA();
    }
}
