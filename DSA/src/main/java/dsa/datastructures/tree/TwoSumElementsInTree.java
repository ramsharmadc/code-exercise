package dsa.datastructures.tree;

import dsa.datastructures.queue.Queue;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the
 * BST such that their sum is equal to the given target.
 *
 * @author ramsharma
 */
public class TwoSumElementsInTree {

    public static void main(String[] args) {

        int t = 12;
        BinarySearchTree<Integer> b = new BinarySearchTree<>();
        b.insert(5);
        b.insert(3);
        b.insert(6);
        b.insert(2);
        b.insert(4);
        b.insert(7);

        System.out.println("IN-ORDER => " + b.printStringInOrder());

        boolean ifExists2Elements = checkIfTwoMakeSum(b.getRoot(), t);
        System.out.println("Does two elements make sum => " + ifExists2Elements);
    }

    public static boolean checkIfTwoMakeSum(Node<Integer> root, int t) {

        Set<Integer> s = new HashSet<>();
        Queue<Node<Integer>> q = new Queue<>();
        q.enqueue(root);

        while (!q.isEmpty()) {
            Node<Integer> n = q.dequeue();
            Node<Integer> l = n.getLeftNode();
            Node<Integer> r = n.getRightNode();

            if (s.contains(t - n.getValue())) {
                System.out.println(t - n.getValue() + " " + n.getValue());
                return true;
            } else
                s.add(n.getValue());

            if (l != null)
                q.enqueue(l);
            if (r != null)
                q.enqueue(r);
        }

        return false;
    }
}
