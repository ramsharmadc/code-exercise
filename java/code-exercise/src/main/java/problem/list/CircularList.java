package problem.list;

import dsa.datastructure.list.LinkedList;
import dsa.datastructure.list.Node;

public class CircularList {
	public static void main(final String[] args) {
		final LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);

		Node<Integer> first;
		Node<Integer> second;

		while (true) {
			first = list.getHead();
			second = list.getHead().getNext();

			if (first == second) {
				System.out.println("TRUE");
			}

			if (first.getNext() == second) {
				break;
			}
		}
		System.out.println("DONE");
	}
}
