package dsalgo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ramsharma on 04-06-2016.
 */
public class TreeTraversalByIteration {
    public static void main(String[] args) {
        final BinaryTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);

        tree.insert(20);
        tree.insert(60);
        tree.insert(40);
        tree.insert(80);
        tree.insert(25);
        tree.insert(300);
        tree.insert(100);
        tree.insert(2);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);

        System.out.print("IN-ORDER by recusrion:: ");
        System.out.print(tree.printStringInOrder() + "\n");

        System.out.print("IN-ORDER by iteration:: ");
        new TreeTraversalByIteration().inOrderIteration(tree.getRoot());

        System.out.print("\nPRE-ORDER by recusrion:: ");
        System.out.print(tree.printStringPreOrder() + "\n");

        System.out.print("PRE-ORDER by iteration:: ");
        new TreeTraversalByIteration().preOrderIteration(tree.getRoot());
    }

    public void inOrderIteration(Node<Integer> root) {
        Stack<Node<Integer>> stk = new Stack<>();
        Node<Integer> link = root;
        do {
            if (link != null) {
                stk.push(link);
                link = link.getLeftNode();
            } else {
                link = stk.pop();
                if (link != null) {
                    System.out.print(link.getValue() + " ");
                    link = link.getRightNode();
                    stk.push(link);
                    if (link != null)
                        link = link.getLeftNode();
                }
            }
        } while (stk.size() != 0);
    }

    public void preOrderIteration(Node<Integer> root) {
        Queue<Node<Integer>> q = new LinkedList<>();
        Node<Integer> link = null;
        q.add(root);
        do {
            link = q.poll();
            if (link != null) {
                System.out.print(link.getValue() + " ");
                q.add(link.getLeftNode());
                q.add(link.getRightNode());
            }
        } while (q.size() != 0);
    }
}
