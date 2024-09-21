package dsa.datastructures.tree;

import dsa.datastructures.queue.Queue;

public class BreadthFirstSearch_BFS_Tree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.insert(50);
        t.insert(20);

        t.insert(30);
        t.insert(40);

        t.insert(100);
        t.insert(70);
        t.insert(150);

        System.out.println(t.printStringInOrder());
        System.out.println(t.printStringPreOrder());
        System.out.println(t.printStringPostOrder());

        String levelOrder = printLevelOrder(t);
        System.out.println(levelOrder);
    }

    private static String printLevelOrder(BinarySearchTree<Integer> t) {
        StringBuilder s = new StringBuilder();
        Queue<Node> q = new Queue();
        q.enqueue(t.getRoot());
        while (!q.isEmpty()) {
            Node n = q.dequeue();
            s.append(n.getValue() + " ");
            if (n.getLeftNode() != null)
                q.enqueue(n.getLeftNode());
            if (n.getRightNode() != null)
                q.enqueue(n.getRightNode());
        }
        return s.toString();
    }
}
