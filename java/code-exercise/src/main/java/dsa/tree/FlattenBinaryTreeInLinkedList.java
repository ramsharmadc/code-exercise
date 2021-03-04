package dsa.tree;

public class FlattenBinaryTreeInLinkedList {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        // System.out.println(TreeUtils.checkIfBinarySearchTree(tree));

//        System.out.println(TreeUtils.checkIfBST(tree));
//        System.out.println(tree.printStringInOrder());

        TreeUtils.printAllPathOfTheTree(tree);
    }

    public void flattenTree(Node<Integer> root) {
        if (root == null ||
                (root.getLeftNode() == null && root.getRightNode() == null)) return;

        if (root.getLeftNode() != null) {

            flattenTree(root.getLeftNode());

            Node tmp = root.getRightNode();
            root.getRightNode().setRightNode(root.getRightNode());
            root.setLeftNode(null);

            Node curr = root.getRightNode();
            while (curr.getRightNode() != null) {
                curr = curr.getRightNode();
            }

            curr.setRightNode(tmp);
        }

        flattenTree(root.getRightNode());
    }
}
