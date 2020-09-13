package lang.jdk8.basics.oveloading;

public class PassNullObject {

	public PassNullObject() throws Exception {

	}

	public static void callMe(final Object nul) {

		System.out.println("Object passed.");
	}

	public static void callMe(final String nul) {

		System.out.println("String passed.");
	}

	public static void main(final String args[]) {

		callMe(null);
	}
}
