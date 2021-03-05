package dsalgo.tree;

public class AdjustValueOfEachNodeInTree {

    public static void main(String[] args) {
        Tree<Integer> tr = new BinarySearchTree<Integer>();
        tr.insert(10);
        tr.insert(9);
        tr.insert(12);
        System.out.println(tr.printStringInOrder());
        updateWeight(tr.getRoot());
        System.out.println(tr.printStringInOrder());
    }

    public static void adjustDiffValue(Node<Integer> root) {
        if (root == null)
            return;
        updateWeight(root);
    }

    private static int updateWeight(Node<Integer> root) {
        if (root == null)
            return 0;

        int leftSubtreeWeight = updateWeight(root.getLeftNode());
        int rightSubtreeWeight = updateWeight(root.getRightNode());

        int currentRootValue = root.getValue();

        root.setValue(Math.abs(leftSubtreeWeight - rightSubtreeWeight));
        return currentRootValue + leftSubtreeWeight + rightSubtreeWeight;
    }
}
