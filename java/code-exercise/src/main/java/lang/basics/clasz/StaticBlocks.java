package lang.basics.clasz;

class OneMoreStaticClass extends StaticBlocks {

	static {
		System.out.println("OneMoreStaticClass class is referenced." + i);
	}

	public void callMe() {
		System.out.println("You are called.");
	}
}

public class StaticBlocks {

	protected static int i;

	static {
		i = 900;
		System.out.println("This class is referenced. i = " + i);
	}

	public static void main(final String[] args) {
		System.out.println(StaticBlocks.i);
		new OneMoreStaticClass();
	}
}
