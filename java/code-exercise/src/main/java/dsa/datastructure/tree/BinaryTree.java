package dsa.datastructure.tree;

import java.util.LinkedList;
import java.util.List;

public abstract class BinaryTree<T> implements Tree<T> {

	private Node<T> root = null;
	private StringBuilder str = null;

	public BinaryTree() {
		str = new StringBuilder();
	}

	@Override
	public abstract void insert(T val);

	@Override
	public abstract Node<T> searchNode(T val);

	@Override
	public abstract void delete(T val);

	@Override
	public abstract T getMax();

	@Override
	public abstract T getMinimun();

	@Override
	public Node<T> getRoot() {

		return root;
	}

	public void setRoot(Node<T> _root) {
		root = _root;
	}

	@Override
	public String printStringInOrder() {
		str = new StringBuilder();
		printInOrder(getRoot());
		return str.toString();
	}

	@Override
	public String printStringPostOrder() {
		str = new StringBuilder();
		printPostOrder(getRoot());
		return str.toString();
	}

	@Override
	public String printStringPreOrder() {
		str = new StringBuilder();
		printPreOrder(getRoot());
		return str.toString();
	}

	private void printInOrder(Node<T> node) {
		Node<T> root = node;
		try {
			if (root == null)
				return;
			printInOrder(root.getLeftNode());
			str.append(root.getValue()).append(" ");
			printInOrder(root.getRightNode());
		} catch (Exception e) {
			throw new RuntimeException("Error while In-Order traversal.", e);
		}
	}

	private void printPostOrder(Node<T> node) {
		Node<T> root = node;
		try {
			if (root == null)
				return;
			printPostOrder(root.getLeftNode());
			printPostOrder(root.getRightNode());
			str.append(root.getValue()).append(" ");
		} catch (Exception e) {
			throw new RuntimeException("Error while In-Order traversal.", e);
		}
	}

	private void printPreOrder(Node<T> node) {
		Node<T> root = node;
		try {
			if (root == null)
				return;
			str.append(root.getValue()).append(" ");
			printPreOrder(root.getLeftNode());
			printPreOrder(root.getRightNode());
		} catch (Exception e) {
		}
	}

	public List<T> logTraversal(Tree<T> tree) {
		List<T> list = new LinkedList<T>();
		printInOrder(getRoot(), list);
		return list;
	}

	private void printInOrder(Node<T> node, List<T> list) {
		Node<T> root = node;
		try {
			if (root == null)
				return;
			printInOrder(root.getLeftNode());
			list.add(root.getValue());
			printInOrder(root.getRightNode());
		} catch (Exception e) {
		}
	}
}
