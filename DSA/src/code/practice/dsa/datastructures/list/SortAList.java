package dsa.datastructures.list;

public class SortAList {

    public static void main(String[] args) {
        System.out.println("Sorting a list");
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(5);
        list.insert(7);
        list.insert(3);
        list.insert(11);
        list.showList();

        sortList(list);

        list.showList();
    }

    public static void sortList(LinkedList<Integer> list) {

        Node<Integer> head = list.getHead();
        Node<Integer> temp = head;

        while (temp.getNext() != null) {

            Node<Integer> resetPtr = head;
            Node<Integer> tempNext = temp.getNext();
            Node<Integer> buffr;

            while (resetPtr != null) {
                if (temp.getValue() > resetPtr.getValue()) {
                    buffr = temp;
                    temp.setValue(resetPtr.getValue());
                    resetPtr.setValue(buffr.getValue());
                }
                resetPtr = resetPtr.getNext();
            }

            temp = temp.getNext();
        }
    }
}
