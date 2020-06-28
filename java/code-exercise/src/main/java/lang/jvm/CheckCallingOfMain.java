package lang.jvm;

public class CheckCallingOfMain {

	public static void main(final int[] args) {

		System.out.println("Not Happy");
	}

	public static void main(final String[] args) {

		System.out.println("Happy");
	}

	public static void main(String args) {

		System.out.println("Very Happy");
	}
}
