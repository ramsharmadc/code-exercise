package problem.list;

import dsa.datastructure.list.LinkedList;
import dsa.datastructure.list.ListADT;

public class LinkedListToOddAndEvenButOddReversed {

	static ListADT<Integer> evenList = new LinkedList<>();
	static ListADT<Integer> oddList = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		java.util.List<Integer> list = new java.util.LinkedList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		splitListInEvenAndOdd(list);

		evenList.showList();
		oddList.showList();
	}

	private static void splitListInEvenAndOdd(java.util.List<Integer> list) throws Exception {

		for (Integer i : list) {
			if (i.equals(0) || i % 2 == 0)
				evenList.insert(i);
			else
				oddList.insertAt(i, 1);
		}
	}
}
