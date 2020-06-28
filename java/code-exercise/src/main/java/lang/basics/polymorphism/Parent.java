package lang.basics.polymorphism;

class Child extends Parent {
	public void anotherFoo() {
		System.out.println("Another Child method");
	}

	@Override
	public void foo() {
		System.out.println("Child Foo()");
	}

	@Override
	public Number foo(Number nbr) {
		// TODO Auto-generated method stub
		return super.foo(nbr);
	}
}

public class Parent {
	// the cons. without params should nt b private
	public Parent() {
	}

	public Parent(int n) {
	}

	public static void main(String[] args) {
		Parent p = new Child();
		p.foo();
		p.foo(12);
		// p.anotherFoo(); // ERROR !!
		// u cant call a method which is unknown to Parent, even the parent has
		// a reference to the child
	}

	public void foo() {
		System.out.println("Parent's Foo()");
	}

	public Number foo(Number nbr) {
		System.out.println("Parent's Foo()");
		return nbr;
	}
}