package dsalgo.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.print("Initial Linked List:: ");
        printList(list.getHead());

        System.out.print("\nReversed Linked List:: ");
        reverseLinkList(list);

        LinkedList<Integer> newlist = new LinkedList<Integer>();
        newlist.insert(1);
        newlist.insert(2);
        newlist.insert(3);
        newlist.insert(4);
        newlist.insert(5);

        System.out.println("\nReversed Linked List in chunks:: ");
        reverseListInChunks(list, 2);

        reverseLinkList_2(newlist);
    }

    private static void reverseListInChunks(LinkedList<Integer> list, int k) {
        Node<Integer> head = list.getHead();
        Node<Integer> origin = list.getHead();
        Node<Integer> next = head.getNext();
        Node<Integer> previous = null;
        Node<Integer> fastNext = null;

        while (next != null) {
            head.setNext(previous);
            fastNext = next.getNext();
            next.setHead(head);
            head = fastNext;
            next = head.getNext();
        }

        printList(head);
    }

    private static void reverseLinkList(LinkedList<Integer> list) {
        Node<Integer> head = list.getHead();
        Node<Integer> next = head.getNext();
        Node<Integer> previous = null;
        Node<Integer> tempNext = null;

        // one iteration throughout
        // Time(f(n)) = O(n)
        while (next != null) {
            head.setNext(previous); // this reverses the link in place
            tempNext = next.getNext();
            next.setNext(head);
            previous = head;
            head = next;
            next = tempNext;
        }

        printList(head);
    }

    public static void printList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
    }

    public static void reverseLinkList_2(LinkedList<Integer> list) {

        System.out.println("\nREVERSING LIST");

        Node head = list.getHead();
        Node nxt = head.getNext();
        Node tmp = null;
        Node prv = null;

        while (nxt != null) {
            head.setNext(prv);
            tmp = nxt.getNext();
            nxt.setNext(head);
            prv = head;
            head = nxt;
            nxt = tmp;
        }
        printList(head);
    }
}
