package dsa.tree;

/**
 * @param <T>
 * @author ramsharma
 */
public class Node<T> implements Comparable<T> {

	private Node<T> leftNode;
	private Node<T> rightNode;
	private Node<T> parent;
	private Node<T> root;
	private T value;

	public Node() {
		this.value = null;
		this.leftNode = null;
		this.rightNode = null;
		this.parent = null;
		this.root = null;
	}

	public Node(final T value) {
		this();
		this.value = value;
	}

	public Node(final int key, final Object object, final Object object2) {
		// TODO complete...
	}

	public Node(final Node<T> root) {
		this();
		this.root = root;
	}

	/**
	 * @return the leftNode
	 */
	public Node<T> getLeftNode() {
		return leftNode;
	}

	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(final Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * @return the parent
	 */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(final Node<T> parent) {
		this.parent = parent;
	}

	/**
	 * @return the rightNode
	 */
	public Node<T> getRightNode() {
		return rightNode;
	}

	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(final Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	/**
	 * @return the root
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(final Node<T> root) {
		this.root = root;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
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
