package dsa.datastructures.list;

/*
input - .  a linked list (head)
int k = 7

1->2->3->4->5->6->7->8-9...

*/


import java.util.HashMap;
import java.util.Map;

public class FindKthLastNodeInSingleLinkedList {

    static Map<Integer, Node<Integer>> nodePosition = new HashMap<>();

    public Node<Integer> getLastKthNode(Node<Integer> head, int k) {
        int n = size(head);
        int x = n - k;
        return nodePosition.get(x);
    }

    public Node<Integer> optimizedGetNode(Node<Integer> head, int k) {

        // 1. empty list
        // 2. if list.size < k
        // 3. k < 1
        // 4. check for loop in the list
        // 5.

        Node<Integer> fastPtr = head;
        Node<Integer> slowPtr = head;

        for (int i = 0; i < k; i++) {
            fastPtr = fastPtr.next;
        }

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }

    public int size(Node<Integer> head) {

        if (head == null) {
            return 0;
        }

        int c = 0;
        while (head != null) {
            c += 1;
            nodePosition.put(c, head);
            head = head.next;
        }
        return c;
    }

    class Node<K> {

        Node<K> next;
        K value;

        public Node(K value) {
            this.value = value;
        }

        public Node<K> getNext() {
            return next;
        }

        public void setNext(Node<K> next) {
            this.next = next;
        }

        public K getValue() {
            return value;
        }

        public void setValue(K value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        FindKthLastNodeInSingleLinkedList findKthLastNodeInSingleLinkedList =
                new FindKthLastNodeInSingleLinkedList();
        Node<Integer> head = findKthLastNodeInSingleLinkedList.new Node(1);
        Node<Integer> tmp = head;

        for (int i = 2; i < 11; i++) {
            tmp.setNext(findKthLastNodeInSingleLinkedList.new Node<>(i));
            tmp = tmp.next;
        }

        Node<Integer> kthLastNode = findKthLastNodeInSingleLinkedList.getLastKthNode(head, 4);
        Node<Integer> kthLastNode2 = findKthLastNodeInSingleLinkedList.optimizedGetNode(head, 4);

        System.out.println(kthLastNode.value);
        System.out.println(kthLastNode2.value);

        assert (kthLastNode.value == 3);
        assert (kthLastNode2.value == 3);
    }
}
