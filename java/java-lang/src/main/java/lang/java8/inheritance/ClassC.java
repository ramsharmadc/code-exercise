package lang.java8.inheritance;

public class ClassC extends ClassB {

    @Override
    public void met1OfB() {
        super.met1OfB();
    }

    @Override
    protected void met1OfA() {
        System.out.println("Overriding in ClassC");
        super.met1OfA();
    }

    @Override
    public void met2OfA() {
        System.out.println("Overriding in ClassC");
        super.met2OfA();
    }
}
