package dsa.list;

public class FindMIddleElementOfList {

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.insert(3);
		l.insert(8);
		l.insert(4);
		l.insert(7);
		l.insert(6);
		l.insert(9);
		l.insert(4);

		System.out.println("List in hand...");
		l.showList();

		Node midNode = findMiddleOfList(l);
		System.out.println(midNode.getValue());
	}

	public static Node findMiddleOfList(LinkedList l) {

		// like tortoise and hare
		Node slowPtr = l.getHead();
		Node fastPtr = slowPtr;

		while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}

		return slowPtr;
	}
}
