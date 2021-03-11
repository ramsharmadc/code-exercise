package dsa.datastructures.list;

public class ReverseList {

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

        reverseList(l.getHead());
    }

    public static void reverseList(Node head) {

    }
}
