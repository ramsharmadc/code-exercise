package lang.wrapper;

public class WrapperTest {
	static Integer a;
	static Integer b = a;

	// check this when I m calling it in main()
	static Integer newInt = new Integer(null);

	static int c;
	static int d = c;

	public static void main(String[] args) {

		System.out.println(a);
		System.out.println(b);

		System.out.println(WrapperTest.newInt);

		// see the difference here, these below 4 lines are fine at class level
		// int e ;
		// int f = e;

		// Integer m;
		// Integer n = m;

		System.out.println(c);
		System.out.println(d);
	}
}
