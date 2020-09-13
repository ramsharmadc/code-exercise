package lang.jdk8.annotation;

public class SimpleClass {

	@SimpleAnnotation
	static
	String hello;

	public static void main(String[] args) {
		System.out.println(hello);
	}
}
