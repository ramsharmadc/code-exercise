package dsa.datastructure.stack;

public class TestStack {

	public static void main(final String[] args) throws Exception {

		final Stack<Integer> obj = new Stack<>();

		for (int i = 0; i < 10; i++) {
			obj.push(i + 1);
		}

		obj.printStack();

		System.out.print("Peek :: " + obj.peek());
		System.out.println("; Pop :: " + obj.pop());

		System.out.print("Peek :: " + obj.peek());
		System.out.println("; Pop :: " + obj.pop());

		System.out.println(obj.isEmpty());
		// Stack r = StackUtils.sortTheStack( obj ) ;

		// r.printStack() ;
	}
}
