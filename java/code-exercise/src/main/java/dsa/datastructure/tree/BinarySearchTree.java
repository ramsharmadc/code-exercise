package dsa.datastructure.tree;

public class BinarySearchTree<T> extends BinaryTree<T> {

	public BinarySearchTree() {
		super();
	}

	@Override
	public void insert(final T val) {
		// if tree is empty
		if (getRoot() == null) {
			setRoot(new Node<T>(val));
			return;
		} else
			insert(new Node<T>(val));
	}

	@Override
	public void delete(final T val) throws RuntimeException {
		// Integer v = Integer.valueOf( ( Integer ) val ) ;
		final Node<T> z = searchNode(val);
		delete(z);
	}

	@Override
	public T getMax() {
		Node<T> x = getRoot();
		while (x.getRightNode() != null)
			x = x.getRightNode();
		return x.getValue();
	}

	@Override
	public T getMinimun() {
		Node<T> x = getRoot();
		while (x.getLeftNode() != null)
			x = x.getLeftNode();
		return x.getValue();
	}

	private T getMinimun(final Node<T> root) {
		Node<T> x = root;
		while (x.getLeftNode() != null)
			x = x.getLeftNode();
		return x.getValue();
	}

	@Override
	public Node<T> searchNode(final T val) throws RuntimeException {
		final Node<T> root = getRoot();
		if (root == null)
			throw new RuntimeException("Root is null for this tree.");
		if (root.getValue() == val)
			return root;
		final Node<T> searchingFor = searchNode(root, val);
		return searchingFor;
	}

	private Node<T> searchNode(final Node<T> x, final T val) throws RuntimeException {
		if (x == null)
			throw new RuntimeException("Value not found in the tree.");
		if (x.compareTo(val) == 0)
			return x;
		// val < x.getValue()
		if (x.compareTo(val) > 0)
			return searchNode(x.getLeftNode(), val);
		else
			return searchNode(x.getRightNode(), val);
	}

	private void transplant(final Node<T> u, Node<T> v) {
		if (u.getParent() == null)
			setRoot(v);
		else if (u == u.getParent().getLeftNode())
			u.getParent().setLeftNode(v);
		else
			u.getParent().setRightNode(v);

		if (v == null) {
			v = new Node<T>();
			v.setParent(u.getParent());
		}
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
		z.setParent(y);
		if (y == null)
			setRoot(z);
		else if (z.compareTo(y.getValue()) < 0)
			y.setLeftNode(z);
		else
			y.setRightNode(z);
	}

	private void delete(final Node<T> z) throws RuntimeException {
		if (z.getLeftNode() == null)
			transplant(z, z.getRightNode());
		else if (z.getRightNode() == null)
			transplant(z, z.getLeftNode());
		else {
			final Node<T> y = searchNode(getMinimun(z.getRightNode()));
			if (y.getParent() != z) {
				transplant(y, y.getRightNode());
				y.setRightNode(z.getRightNode());
				y.getRightNode().setParent(y);
			}
			transplant(z, y);
			y.setLeftNode(z.getLeftNode());
			y.getLeftNode().setParent(y);
		}
	}
}
