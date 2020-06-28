package lang;

public class Calculator {
	public static void main(String[] args) throws Exception {
		int i = 0;

		int m = 010;
		int j = 07;

		System.out.println(m);
		System.out.println(j);

		short s = 9;
		System.out.println(add(s,6));

		try{
			Float f = new Float("3.0");
			int x = f.intValue();
			byte b = f.byteValue();
			double d = f.doubleValue();
			System.out.println(x+b+d);
		}catch (NumberFormatException e){
			System.out.println("bad number");
		}
	}

	static int add(int a, int b){
		return a + b;
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	interface IntegerMath {
		int operation(int a, int b);
	}
}
