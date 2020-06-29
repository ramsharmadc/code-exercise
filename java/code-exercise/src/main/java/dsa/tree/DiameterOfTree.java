package dsa.tree;

public class DiameterOfTree {

	static int height(Node<Integer> node) {

		// tree is empty
		if (node == null || (node.getLeftNode() == null && node.getRightNode() == null))
			return 0;

		// add 1 at current level, and
		// go down and find max height out of left and right trees
		return (1 + Math.max(height(node.getLeftNode()), height(node.getRightNode())));
	}

	public static void main(String[] args) {

		// sample binary tree
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(50);
		tree.insert(80);
		tree.insert(90);
		tree.insert(70);
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);

		String inOrd = tree.printStringInOrder();
		System.out.println("Tree In-Order => " + inOrd);

		int height = height(tree.getRoot());
		System.out.println("height of tree => " + height);

		DiameterOfTree obj = new DiameterOfTree();
		int diameter = obj.diameter(tree.getRoot());
		System.out.println("Diameter of tree: " + diameter);
	}

	int diameter(Node root) {
		// tree is empty
		if (root == null)
			return 0;

		// find right and left heights
		int left_height = height(root.getLeftNode());
		int right_height = height(root.getRightNode());

		// find left and right diameters
		int left_diameter = diameter(root.getLeftNode());
		int right_diameter = diameter(root.getRightNode());

		return Math.max((left_height + right_height + 1), Math.max(left_diameter, right_diameter));
	}
}

class BinaryTreeForTest<T> {
	private Node<T> root = null;

	public Node<T> getRoot() {
		return root;
	}

	protected void setRoot(Node<T> _root) {
		root = _root;
	}

	public void insert(final T val) {
		// if tree is empty
		if (getRoot() == null) {
			setRoot(new Node<T>(val));
			return;
		} else
			insert(new Node<T>(val));
	}

	private void insert(final Node<T> z) {
		Node<T> y = null;
		Node<T> x = getRoot();
		while (x != null) {
			y = x;
			if (z.compareTo(x.getValue()) < 0)
				x = x.getLeftNode();
			else
				x = x.getRightNode();
		}
		if (y == null)
			setRoot(z);
		else if (z.compareTo(y.getValue()) < 0)
			y.setLeftNode(z);
		else
			y.setRightNode(z);
	}

	static class Node<T> implements Comparable<T> {

		private Node<T> leftNode;
		private Node<T> rightNode;
		private Node<T> root;
		private T value;

		public Node() {
			this.value = null;
			this.leftNode = null;
			this.rightNode = null;
			this.root = null;
		}

		public Node(final T value) {
			this();
			this.value = value;
		}

		public Node(final Node<T> root) {
			this();
			this.root = root;
		}

		public Node<T> getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(final Node<T> leftNode) {
			this.leftNode = leftNode;
		}

		public Node<T> getRightNode() {
			return rightNode;
		}

		public void setRightNode(final Node<T> rightNode) {
			this.rightNode = rightNode;
		}

		public Node<T> getRoot() {
			return root;
		}

		public void setRoot(final Node<T> root) {
			this.root = root;
		}

		public T getValue() {
			return value;
		}

		public void setValue(final T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return getValue().toString();
		}

		@Override
		public int compareTo(final T _param) {
			if (value == _param)
				return 0;
			if (_param instanceof Integer) {
				Integer paramLeft = (Integer) getValue();
				Integer paramRight = (Integer) _param;
				return paramLeft.compareTo(paramRight);
			} else if (_param instanceof String) {
				String paramLeft = (String) getValue();
				String paramRight = (String) _param;
				return paramLeft.compareToIgnoreCase(paramRight);
			} else if (_param instanceof Character) {
				Character paramLeft = (Character) getValue();
				Character paramRight = (Character) _param;
				return paramLeft.compareTo(paramRight);
			}
			return 0;
		}
	}
}
