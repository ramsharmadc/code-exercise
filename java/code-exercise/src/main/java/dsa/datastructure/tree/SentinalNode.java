package dsa.datastructure.tree;

public class SentinalNode {

	private Node next = null;
	private Node left = null;
	private Node right = null;
	private Node parent;
	private NodeColour color = NodeColour.BLACK;

	public void setParent(Node node) {
		this.parent = node;
	}

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

	public NodeColour getColor() {
		return color;
	}
}
