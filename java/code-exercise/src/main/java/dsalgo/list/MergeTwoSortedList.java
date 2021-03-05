package dsalgo.list;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        mergeSortedList(l1, l2);
    }

    private static void mergeSortedList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        Node<Integer> hd1 = l1.getHead();
        Node<Integer> hd2 = l2.getHead();

        while (hd1.getNext() != null && hd2.getNext() != null) {
            if (hd1.getValue() < hd2.getValue()) {
                if (hd1.getNext().getValue() < hd2.getValue()) {

                } else if (hd1.getNext().getValue() > hd2.getValue()) {
                    Node tmp = hd1.getNext();
                    hd1.setNext(hd2);
                    hd2.setNext(tmp);
                }
            }
            /*
             * else if() {
             *
             * }
             */
        }

        if (hd1.getNext() == null && hd2.getNext() != null) {
            hd1.setNext(hd2);
        } else if (hd1.getNext() != null && hd2.getNext() == null) {
            hd2.setNext(hd1);
        }
    }
}
