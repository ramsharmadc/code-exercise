package dsa.tree;

import dsa.queue.Queue;

public class TreeBFSTraversal {

	public static void main(String[] args) {
		
		Tree<Integer> t = new BinarySearchTree<>();
		t.insert(9);
		t.insert(6);
		t.insert(15);
		t.insert(3);
		t.insert(8);
		t.insert(12);
		t.insert(18);

		System.out.println("INORDER:: " + t.printStringInOrder());

		bfsTraversal(t);
	}

	private static void bfsTraversal(Tree<Integer> t) {
		
		Node<Integer> root = t.getRoot();
		Queue<Node<Integer>> q = new Queue<>();
		q.enqueue(root);

		while (q != null && !q.isEmpty()) {
			Node<Integer> tmp = q.dequeue();
			if (tmp != null) {
				System.out.print(tmp.getValue() + "|");
				q.enqueue(tmp.getLeftNode());
				q.enqueue(tmp.getRightNode());
			}
		}
	}
}
