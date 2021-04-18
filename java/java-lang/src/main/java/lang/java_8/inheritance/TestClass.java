package lang.java_8.inheritance;

public class TestClass {

    public static void main(final String[] args) {

        BaseClass obj = new BaseClass();
        ChildClass cObj = new ChildClass();

        obj.showProps();
        System.out.println(obj);

        obj = cObj;
        cObj = (ChildClass) obj.showProps();
        System.out.println(cObj);

        ClassC c = new ClassC();
        c.met1OfA();
        c.met2OfA();
        c.met1OfB();
    }

}
