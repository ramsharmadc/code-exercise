package lang;

class Student {

	@Override
	public String toString() {

		// TODO Auto-generated method stub
		return super.toString();
	}
}

public class TestClass {

	public static void main(final String[] args) {

		final int x;
		x = 20;
		// args=new String[]{"final array change"};

		System.out.println(x);

		final String str = "XYZ";
		// System.out.println(str.compareTo(new Student())); // compile error
		System.out.println(str.compareTo("Student"));

		System.out.println("abcd".compareTo("wxyz"));

		System.out.println(1 << 10);
	}

	void changeFinalParam(final Object obj) {
		// obj = new Object();
	}

}
