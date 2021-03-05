package dsalgo.list;

public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> previous;
    private Node<T> head;

    // attribs for skiplist node
    private Node<T> expressWayNode;
    private Node<T> subWayNode;

    public Node() {

        this.value = null;
        this.next = null;
        this.previous = null;
        this.head = null;
    }

    public Node(final Node<T> node) {

        this.value = node.value;
        this.next = node.next;
        this.previous = node.previous;
        this.head = node.head;
    }

    public Node(final T value) {

        this.value = value;
        this.next = null;
        this.previous = null;
        this.head = null;
    }

    public Node<T> getHead() {

        return head;
    }

    public void setHead(final Node<T> head) {

        this.head = head;
    }

    public Node<T> getNext() {

        return next;
    }

    public void setNext(final Node<T> next) {

        this.next = next;
    }

    public Node<T> getPrevious() {

        return previous;
    }

    public void setPrevious(final Node<T> previous) {

        this.previous = previous;
    }

    public T getValue() {

        return value;
    }

    public void setValue(final T value) {

        this.value = value;
    }

    protected Node<T> getExpressWayNode() {

        return this.expressWayNode;
    }

    protected void setExpressWayNode(Node<T> expressWayNode) {

        this.expressWayNode = expressWayNode;
    }

    protected Node<T> getSubWayNode() {

        return this.subWayNode;
    }

    protected void setSubWayNode(Node<T> subWayNode) {

        this.subWayNode = subWayNode;
    }

    @Override
    public String toString() {
        return "Node-" + value;
    }
}
