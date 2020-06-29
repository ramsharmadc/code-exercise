package dsa.list;

import java.util.LinkedList;

public class AddTwoLists {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.add(2);
		list1.add(0);
		list1.add(0);
		// list1.add(0);
		// list1.add(0);
		// list1.add(0);
		list2.add(2);
		list2.add(3);
		list2.add(2);
		// list2.add(3);
		// list2.add(4);
		System.out.println(sumTwoLists(list1, list2));
	}

	/**
	 * approach :: First make numbers from both the lists in decimal form and then
	 * add the two numbers obtained.
	 */
	public static int sumTwoLists(LinkedList<Integer> li_a, LinkedList<Integer> li_b) {
		int numOne = 0;
		int numTwo = 0;

		while (li_a != null && !(li_a.isEmpty())) {
			numOne = li_a.poll() + (numOne * 10);
		}

		while (li_b != null && !(li_b.isEmpty())) {
			numTwo = li_b.poll() + (numTwo * 10);
		}

		return (numOne + numTwo);
	}
}
