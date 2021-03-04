package dsa.list;

public class PairWiseSwapInList {

    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<Integer>();
        l.insert(3);
        l.insert(8);
        l.insert(7);
        l.insert(6);
        l.insert(9);
        l.insert(4);

        System.out.println("List before pair-wise swapping..");
        l.showList();

        // pairwiseSwapList(l);
        pairwiseSwapRecusrive(l.getHead());

        System.out.println("List after pair-wise swapping..");
        l.showList();

    }

    public static void pairwiseSwapList(LinkedList<Integer> l) {
        Node head = l.getHead();
        Node t = head;

        while (t != null && t.getNext() != null) {
            // System.out.println("Head => " + head.getValue());
            Node nxt = t.getNext();
            // System.out.println("Head.Next => " + nxt.getValue());
            Integer tmpVal = (Integer) t.getValue();
            t.setValue(nxt.getValue());
            nxt.setValue(tmpVal);

            t = t.getNext();
        }
    }

    public static void pairwiseSwapRecusrive(Node head) {
        if (head != null && head.getNext() != null) {
            swap(head, head.getNext());
            pairwiseSwapRecusrive(head.getNext().getNext());
        }
    }

    private static void swap(Node head, Node next) {
        // Object tmp = head.getValue();
        // head.setValue(next.getValue());
        // next.setValue(tmp);

        Node tmpNode = head;
        head = next;
        next = tmpNode;
    }
}
