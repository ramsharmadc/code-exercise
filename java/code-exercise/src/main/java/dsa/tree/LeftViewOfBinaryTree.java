package dsa.tree;

public class LeftViewOfBinaryTree {

    public static void main(String[] args) {

        Tree<Integer> t = new BinarySearchTree<>();

        t.insert(8);
        t.insert(5);
        t.insert(2);
        t.insert(10);
        t.insert(13);
        t.insert(9);
        t.insert(16);

        System.out.println(t.printStringInOrder());

        leftViewOfTree(t.getRoot(), 0);
    }

    private static void leftViewOfTree(Node<Integer> root, int toPrint) {

        if (root == null)
            return;

        if (toPrint == 0)
            System.out.print(root.getValue() + " ");

        leftViewOfTree(root.getLeftNode(), 0);
        leftViewOfTree(root.getRightNode(), 1);
    }
}
