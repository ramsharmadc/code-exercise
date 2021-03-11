package dsa.datastructures.tree;

public class SentinalNode {

    private final Node next = null;
    private final Node left = null;
    private final Node right = null;
    private final NodeColour color = NodeColour.BLACK;
    private Node parent;

    public Node getNext() {
        return next;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public NodeColour getColor() {
        return color;
    }
}
