package dsa.datastructures.tree;

public class SwapLeftAndRightForEachNodeInTree {

    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinarySearchTree<>();
        t.insert(20);
        t.insert(50);
        t.insert(200);
        t.insert(75);
        t.insert(25);
        t.insert(300);

        System.out.println(t.printStringInOrder());

        swapLeftAndRightNodes(t.getRoot());

        System.out.println(t.printStringInOrder());
    }

    private static void swapLeftAndRightNodes(Node<Integer> t) {

        if (t == null) return;

        if (t.getLeftNode() != null) {
            swapLeftAndRightNodes(t.getLeftNode());
        }

        if (t.getRightNode() != null) {
            swapLeftAndRightNodes(t.getRightNode());
        }

        Node<Integer> tmp = t.getLeftNode();
        t.setLeftNode(t.getRightNode());
        t.setRightNode(tmp);
    }
}
