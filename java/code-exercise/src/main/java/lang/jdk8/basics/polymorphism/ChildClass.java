package lang.jdk8.basics.polymorphism;

public class ChildClass extends BaseClass {

	@Override
	public String getObject() {

		return "";
	}

	@Override
	public StaticMethodsChild getStaticMethod() {

		return (StaticMethodsChild) super.getStaticMethod();
	}
}