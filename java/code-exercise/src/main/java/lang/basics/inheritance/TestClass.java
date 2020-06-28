package lang.basics.inheritance;

public class TestClass {

	public static void main(final String[] args) {

		lang.basics.inheritance.BaseClass obj = new lang.basics.inheritance.BaseClass();

		lang.basics.inheritance.ChildClass cObj = new lang.basics.inheritance.ChildClass();

		obj.showProps();
		System.out.println(obj);

		obj = cObj;
		cObj = (lang.basics.inheritance.ChildClass) obj.showProps();
		System.out.println(cObj);

		ClassC c = new ClassC();
		c.met1OfA();
		c.met2OfA();
		c.met1OfB();
	}

}
