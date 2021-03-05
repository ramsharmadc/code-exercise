package techprep;

import dsalgo.tree.Node;

public class CheckIfBST {

    public static boolean checkIfBST(Node<Integer> root) {
        if (root == null) return true;
        return root.getLeftNode() != null && root.getRightNode() != null &&
                root.getLeftNode().getValue() < root.getValue() &&
                root.getRightNode().getValue() > root.getValue()
                && checkIfBST(root.getRightNode())
                && checkIfBST(root.getLeftNode());
    }
}
