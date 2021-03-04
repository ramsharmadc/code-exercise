package dsa.tree;

import java.util.Stack;

public class BinaryTreeToInorderStack {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        // System.out.println(tree.printStringInOrder());

        Stack<Integer> inorderStackFromTree = convertTreeToInOrderStack(tree);
        print_stack(inorderStackFromTree);

        Stack<Integer> preorderStackFromTree = convertTreeToPreOrderStack(tree);
        print_stack(preorderStackFromTree);

        Stack<Integer> postorderStackFromTree = convertTreeToPostOrderStack(tree);
        print_stack(postorderStackFromTree);

    }

    private static Stack<Integer> convertTreeToInOrderStack(BinaryTree<Integer> tree) {

        Stack<Integer> stk = new Stack<>();
        Node<Integer> root = tree.getRoot();
        if (root == null) {
            stk.push(null);
            return stk;
        } else {
            inorderTravesral(root, stk);
            return stk;
        }
    }

    private static Stack<Integer> convertTreeToPreOrderStack(BinaryTree<Integer> tree) {

        Stack<Integer> stk = new Stack<>();
        Node<Integer> root = tree.getRoot();
        if (root == null) {
            stk.push(null);
            return stk;
        } else {
            preOrderTravesral(root, stk);
            return stk;
        }
    }

    private static Stack<Integer> convertTreeToPostOrderStack(BinaryTree<Integer> tree) {

        Stack<Integer> stk = new Stack<>();
        Node<Integer> root = tree.getRoot();
        if (root == null) {
            stk.push(null);
            return stk;
        } else {
            postOrderTravesral(root, stk);
            return stk;
        }
    }

    private static void preOrderTravesral(Node<Integer> root, Stack<Integer> stk) {
        if (root == null)
            return;

        stk.push(root.getValue());
        preOrderTravesral(root.getLeftNode(), stk);
        preOrderTravesral(root.getRightNode(), stk);
    }

    private static void postOrderTravesral(Node<Integer> root, Stack<Integer> stk) {
        if (root == null)
            return;

        postOrderTravesral(root.getLeftNode(), stk);
        postOrderTravesral(root.getRightNode(), stk);
        stk.push(root.getValue());
    }

    private static void inorderTravesral(Node<Integer> root, Stack<Integer> stk) {

        if (root == null)
            return;

        inorderTravesral(root.getLeftNode(), stk);
        stk.push(root.getValue());
        inorderTravesral(root.getRightNode(), stk);
    }

    private static void print_stack(Stack<Integer> stk) {
        while (stk != null && !(stk.isEmpty())) {
            System.out.println(stk.pop());
        }
    }
}
