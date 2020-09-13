package lang.jdk8.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	public static <T> List<T> getList() {

		return new ArrayList<T>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;

		// double dbl = sum(nums); // ok

		// below adds not allowed --- If it is extends you can't add
		/*
		 * nums.add(3.14); nums.add(3); nums.add(new Integer(3)); // compile-time error
		 */

		// now this is okay
		nums.add(null);

		List<? super Integer> _ints = ints; // List<? super Integer> is List
		// <Integer>
		System.out.println(_ints);

		_ints.add((int) 4.12); // add allowed here
		_ints.add(5); // add allowed here

		int n = (Integer) _ints.get(3);
		System.out.println(n);

		List<?> _list = TestGeneric.<Object>getList();
		List<?> __list = TestGeneric.<List<?>>getList(); // OKAY

		System.out.println(_list);
		System.out.println(__list);
	}

}
