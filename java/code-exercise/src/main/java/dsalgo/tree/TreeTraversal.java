package dsalgo.tree;

public class TreeTraversal {

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);

        printInOrder(root);
        System.out.println();
        printPreOrder(root);
        System.out.println();
        printPostOrder(root);
    }

    private static void printInOrder(Node root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.key + " ");
        printInOrder(root.right);
    }

    private static void printPreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.key + " ");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    private static void printPostOrder(Node root) {
        if (root == null)
            return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.key + " ");
    }

    static class Node {
        Node left;
        Node right;
        int key;

        public Node(int value) {
            this.key = value;
        }
    }
}
