package dsa.datastructures.v2;

/**
 * Created by ramsh on 08-05-2016.
 */
public class LinkList<T> {
    Node<T> head;

    public void add(T val) {
        Node node = new Node<T>(val);
        if (head == null)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public void iterate() {
        if (head == null)
            System.out.print("[]");
        else {
            System.out.print("[");
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.val);
                tmp = tmp.next;
                if (tmp != null)
                    System.out.print(",");
            }
            System.out.println("]");
        }
    }

    public void delete(T val) throws Exception {
        if (head == null)
            throw new Exception("List is empty.");

        if (head.val.equals(val)) {
            head = head.next;
            return;
        }

        Node tmp = head;
        Node prv = head;
        head = head.next;

        while (head != null) {
            if (head.val.equals(val)) {
                prv.next = head.next;
                head = tmp;
                return;
            }
            head = head.next;
            prv = head;
        }
        head = tmp;
    }

    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> previous;

        Node(T _val) {
            val = _val;
        }
    }
}
