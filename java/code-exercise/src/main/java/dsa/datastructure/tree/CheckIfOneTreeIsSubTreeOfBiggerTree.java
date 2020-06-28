package dsa.datastructure.tree;

public class CheckIfOneTreeIsSubTreeOfBiggerTree {

	public static void main(String[] args) {

		BinaryTree<Integer> parentTree = new BinarySearchTree<>();
		parentTree.insert(30);
		parentTree.insert(20);
		parentTree.insert(15);
		parentTree.insert(25);
		parentTree.insert(40);
		parentTree.insert(38);
		parentTree.insert(39);
		parentTree.insert(45);

		BinaryTree<Integer> subTree = new BinarySearchTree<>();
		subTree.insert(40);
		subTree.insert(38);
		subTree.insert(39);
		subTree.insert(45);

		boolean isTrue = ifSubTree(parentTree.getRoot(), subTree.getRoot());
		System.out.println(isTrue);
	}

	static boolean ifSubTree(Node<Integer> pr, Node<Integer> cr) {
		if (pr == null && cr == null)
			return true;

		if (pr == null || cr == null)
			return false;

		if (pr.getValue() == cr.getValue())
			return isIdenticalTree(pr, cr);

		return ifSubTree(pr.getLeftNode(), cr) || ifSubTree(pr.getRightNode(), cr);
	}

	static boolean isIdenticalTree(Node<Integer> p, Node<Integer> c) {

		if (p == null && c == null)
			return true;

		if (p == null || c == null)
			return false;

		return p.getValue() == c.getValue() && isIdenticalTree(p.getLeftNode(), c.getLeftNode())
				&& isIdenticalTree(p.getRightNode(), c.getRightNode());
	}
}
