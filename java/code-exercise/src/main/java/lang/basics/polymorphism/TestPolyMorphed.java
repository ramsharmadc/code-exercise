package lang.basics.polymorphism;

public class TestPolyMorphed {

	public static void main(String[] args) {

		StaticMethodsChild child = new StaticMethodsChild(10);
		// System.out.println(child.getString());

		StaticMethodsParent p = new StaticMethodsParent();
		System.out.println(StaticMethodsParent.getString());

		p = new StaticMethodsChild(2);
		System.out.println(StaticMethodsParent.getString());
		// p.getNumberFrom();
	}
}
