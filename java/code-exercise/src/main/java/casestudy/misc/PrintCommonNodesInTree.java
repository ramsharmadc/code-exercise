package casestudy.misc;

import dsa.tree.BinarySearchTree;
import dsa.tree.BinaryTree;
import dsa.tree.Node;

import java.util.Stack;

public class PrintCommonNodesInTree {
    private static final Stack<Integer> stk_1 = new Stack<>();
    private static final Stack<Integer> stk_2 = new Stack<>();

    public static void main(String[] args) {
        // first tree
        BinaryTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        System.out.println(tree.printStringInOrder());

        // second tree
        BinaryTree<Integer> tree2 = new BinarySearchTree<>();
        tree2.insert(20);
        tree2.insert(15);
        tree2.insert(12);
        tree2.insert(25);
        tree2.insert(60);
        tree2.insert(10);
        tree2.insert(54);
        System.out.println(tree2.printStringInOrder());
        findCommonNodes(tree, tree2);
    }

    private static void findCommonNodes(BinaryTree<Integer> t1, BinaryTree<Integer> t2) {
        inorderTraversalTree1(t1.getRoot());
        inorderTraversalTree2(t2.getRoot());

        while (!stk_2.isEmpty() && !stk_1.isEmpty()) {
            if (stk_1.peek().equals(stk_2.peek())) {
                stk_1.pop();
                stk_2.pop();
            }

        }
    }

    private static void inorderTraversalTree1(Node<Integer> node) {
        Node<Integer> root = node;
        try {
            if (root == null)
                return;
            inorderTraversalTree1(root.getLeftNode());
            stk_1.push(root.getValue());
            inorderTraversalTree1(root.getRightNode());
        } catch (Exception e) {
        }
    }

    private static void inorderTraversalTree2(Node<Integer> node) {
        Node<Integer> root = node;
        try {
            if (root == null)
                return;
            inorderTraversalTree2(root.getLeftNode());
            stk_2.push(root.getValue());
            inorderTraversalTree2(root.getRightNode());
        } catch (Exception e) {
        }
    }
}
