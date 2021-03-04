package dsa.tree;

import dsa.list.LinkedList;
import dsa.list.ListADT;
import dsa.queue.Queue;
import dsa.stack.Stack;
import dsa.util.CommonUtils;

public class TreeUtils {
    public static void main(String[] args) throws InstantiationException {
        try {
            // testCloneTree();
            // testAdjustingTreeNodes();

            BinaryTree<Integer> tree = new BinarySearchTree<>();

            tree.insert(50);
            tree.insert(80);
            tree.insert(90);
            tree.insert(70);
            tree.insert(20);
            tree.insert(10);
            tree.insert(30);

            tree.insert(5);
            // System.out.println(TreeUtils.checkIfBinarySearchTree(tree));

            System.out.println(TreeUtils.checkIfBST(tree));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testAdjustingTreeNodes() throws Exception {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);

        String str = tree.printStringInOrder();
        String[] a = str.split(" ");
        int[] inOrdStk = new int[a.length];
        int i = 0;

        for (String s : a) {
            if (!s.isEmpty()) {
                inOrdStk[i++] = new Integer(s);
            }
        }

        System.out.println(CommonUtils.arrayAsString(inOrdStk, "|"));

        adjustNodes(tree.getRoot(), inOrdStk);

        str = tree.printStringInOrder();
        System.out.println(str);
    }

    private static void testCloneTree() throws InstantiationException, IllegalAccessException {

        BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        System.out.println("TREE TRAVERSAL IN-ORDER:: " + tree.printStringInOrder());

        BinaryTree<Integer> clone = clone(tree);

        System.out.println("CLONED TREE TRAVERSAL IN-ORDER:: " + clone.printStringInOrder());

        tree.setRoot(new Node<Integer>(5));
        System.out.println("CLONED TREE TRAVERSAL IN-ORDER:: " + tree.printStringInOrder());
        System.out.println("CLONED TREE TRAVERSAL IN-ORDER:: " + clone.printStringInOrder());

    }

    public static void convertTreeToList() {

        BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        System.out.println("TREE IN POST ORDER:: " + tree.printStringPostOrder());

        ListADT<Integer> listFromTree = TreeUtils.convertToList(tree);

        System.out.print("LIST FROM TREE::");
        listFromTree.showList();
    }

    public static void findLowestCommonAncestor() {
        System.out.println("In findLowestCommonAncestor()\n");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        System.out.println("TREE IN POST ORDER:: " + tree.printStringPostOrder());
        System.out.println("TREE IN PRE ORDER:: " + tree.printStringPreOrder());
        System.out.println();
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 10, 30,
                TreeUtils.lowestCommonAncestor(tree, 10, 30));
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 50, 90,
                TreeUtils.lowestCommonAncestor(tree, 50, 90));
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 10, 20,
                TreeUtils.lowestCommonAncestor(tree, 10, 20));
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 10, 90,
                TreeUtils.lowestCommonAncestor(tree, 10, 90));
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 80, 90,
                TreeUtils.lowestCommonAncestor(tree, 80, 90));
        System.out.format("Lowest Common Ancestor of %d and %d is: %d. \n", 90, 70,
                TreeUtils.lowestCommonAncestor(tree, 90, 70));
    }

    public static void testSingleThreadedBinaryTree() {

        Tree<Integer> threadTree = new SingleThreadBinaryTree<>();

        threadTree.insert(6);
        threadTree.insert(3);
        threadTree.insert(1);
        threadTree.insert(5);
        threadTree.insert(8);
        threadTree.insert(7);
        threadTree.insert(11);
        threadTree.insert(9);
        threadTree.insert(13);

        System.out.println(threadTree.getMax());
        System.out.println(threadTree.getMinimun());

        System.out.println(threadTree.printStringPostOrder());

        System.out.println(threadTree.printStringInOrder());
    }

    /**
     * to print in reverse order from bottom i.e. for the given tree. if In Order is : 10 20 30 50
     * 70 80 90 Pre Order is : 50 20 10 30 80 70 90 Post Order is : 10 30 20 70 90 80 50 then
     * Reverse Order would be : 10 30 70 90 20 80 50
     *
     * @param tree
     * @author ram sharma
     * @since 02/August/2014
     */
    public static void printInReverseOrderStartingFromBottom(
            final BinaryTree<? extends Object> tree) {
        Node<? extends Object> root = tree.getRoot();
        final Stack<Node<? extends Object>> myStk = new Stack<>();
        final Queue<Node<? extends Object>> myQ = new Queue<>();
        myQ.enqueue(root);

        // first take root and enqueue its right then left child
        do {
            root = myQ.dequeue();
            myStk.push(root);

            if (root.getRightNode() != null) {
                myQ.enqueue(root.getRightNode());
            }
            if (root.getLeftNode() != null) {
                myQ.enqueue(root.getLeftNode());
            }
        } while (!myQ.isEmpty());

        myStk.printStack();
    }

    public static int sizeOfBST(final BinaryTree<? extends Object> tree) {
        int size = 0;
        if (!(isEmpty(tree))) {
            Node<? extends Object> root = tree.getRoot();
            final Queue<Node<? extends Object>> myQ = new Queue<>();
            final Queue<Node<? extends Object>> intermeidateQ = new Queue<>();
            intermeidateQ.enqueue(root);
            do {
                root = intermeidateQ.dequeue();
                myQ.enqueue(root);

                if (root.getLeftNode() != null) {
                    intermeidateQ.enqueue(root.getLeftNode());
                }

                if (root.getRightNode() != null) {

                    intermeidateQ.enqueue(root.getRightNode());
                }
            } while (!(intermeidateQ.isEmpty()));

            size = myQ.size();
        }

        return size;
    }

    public static boolean isEmpty(final BinaryTree<? extends Object> tree) {

        return ((tree == null) || (tree.getRoot() == null));
    }

    private static boolean checkIfIdenticalTrees(final Node<? extends Object> leftTree,
                                                 final Node<? extends Object> rightTree) {
        // we can do it comparing the in-order of both order
        if ((leftTree == null) && (rightTree == null))
            return true;

        if ((leftTree != null) && (rightTree != null)) {
            return leftTree.getValue().equals(rightTree.getValue())
                    && checkIfIdenticalTrees(leftTree.getLeftNode(), rightTree.getLeftNode())
                    && checkIfIdenticalTrees(leftTree.getRightNode(), rightTree.getRightNode());
        } else
            return false;
    }

    public static boolean checkIfIdenticalTrees(final BinaryTree<Integer> treeOne,
                                                final BinaryTree<Integer> treeTwo) {

        return checkIfIdenticalTrees(treeOne.getRoot(), treeTwo.getRoot());
    }

    public static int sizeOfBSTRecursively(final BinaryTree<Integer> tree) {
        return size(tree.getRoot());
    }

    private static int size(final Node<Integer> root) {
        if (root == null)
            return 0;
        else
            return size(root.getLeftNode()) + size(root.getRightNode()) + 1;
    }

    public static void printAllPathOfTheTree(final BinaryTree<Integer> treeOne) {
        // TODO Auto-generated method stub
    }

    public static int levelOf(final Node<Integer> root, final Node<Integer> a) {
        return levelOf(root, a, 1);
    }

    private static int levelOf(final Node<Integer> root, final Node<Integer> a, final int level) {
        if (root == null)
            return 0;
        if (root.compareTo(a.getValue()) == 0)
            return level;
        final int l = levelOf(root.getLeftNode(), a, (level + 1));
        if (l != 0)
            return l;
        return levelOf(root.getRightNode(), a, (level + 1));
    }

    public static boolean checkIfTwoNodesAreCousins(final BinaryTree<Integer> tree,
                                                    final Node<Integer> a, final Node<Integer> b) {
        return (levelOf(tree.getRoot(), a) == levelOf(tree.getRoot(), b))
                && !(checkIfTwoNodesAreSiblings(tree, a, b));
    }

    public static boolean checkIfTwoNodesAreSiblings(final BinaryTree<Integer> tree,
                                                     final Node<Integer> a, final Node<Integer> b) {
        if (tree.getRoot() == null)
            return false;
        return checkIfTwoNodesAreSiblings(tree.getRoot(), a, b);
    }

    private static boolean checkIfTwoNodesAreSiblings(final Node<Integer> root,
                                                      final Node<Integer> a, final Node<Integer> b) {
        if ((root != null) && (root.getLeftNode() != null) && (root.getRightNode() != null)) {
            return (((root.getLeftNode().getValue() == a.getValue())
                    && (root.getRightNode().getValue() == b.getValue()))
                    || ((root.getLeftNode().getValue() == b.getValue())
                    && (root.getRightNode().getValue() == a.getValue()))
                    || (checkIfTwoNodesAreSiblings(root.getRightNode(), a, b))
                    || (checkIfTwoNodesAreSiblings(root.getLeftNode(), a, b)));
        } else {
            return false;
        }
    }

    public static boolean checkIfBinarySearchTree(final BinaryTree<Integer> tree) {
        if (tree != null) {
            return checkIfBinarySearchTree(tree.getRoot());
        } else {
            return false;
        }
    }

    // this is simple but WRONG, because a large node down the left path may be
    // bigger than root but smaller than its immediate parent
    private static boolean checkIfBinarySearchTree(final Node<Integer> root) {
        // an empty tree is a Binary Search Tree
        if (root == null)
            return true;

        // only root is a binary tree
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return true;
        } else {
            return (root.getValue() > root.getLeftNode().getValue())
                    && (root.getValue() < root.getRightNode().getValue())
                    && checkIfBinarySearchTree(root.getLeftNode())
                    && checkIfBinarySearchTree(root.getRightNode());
        }
    }

    public static boolean checkIfBST(Tree t) {
        String s = t.printStringInOrder();
        System.out.println("Inorder => " + s);
        int prev = -1;
        for (String x : s.split(" ")) {
            if (Integer.valueOf(x) < prev)
                return false;
            prev = Integer.valueOf(x);
        }
        return true;
    }

    /**
     * This will create a circular link list which will contain the nodes of the tree in increasing
     * order(In-Order traversal of tree)
     *
     * @return
     */
    public static <T> ListADT<T> convertToList(final Tree<T> binarySearchTree) {
        ListADT<T> list = new LinkedList<>();
        if ((binarySearchTree != null) && (binarySearchTree.getRoot() != null)) {
            list = convertToList(binarySearchTree.getRoot(), list);
        }
        return list;
    }

    private static <T> ListADT<T> convertToList(final Node<T> root, final ListADT<T> list) {
        if (root == null)
            return null;
        convertToList(root.getLeftNode(), list);
        list.insert(root.getValue());
        convertToList(root.getRightNode(), list);
        return list;
    }

    /**
     * We can solve this problem using BST properties. We can recursively traverse the BST from
     * root. The main idea of the solution is, while traversing from top to bottom, the first node n
     * we encounter with value between n1 and n2, i.e., n1 < n < n2 or same as one of the n1 or n2,
     * is LCA of n1 and n2 (assuming that n1 < n2). So just recursively traverse the BST in, if
     * node's value is greater than both n1 and n2 then our LCA lies in left side of the node, if
     * it's is smaller than both n1 and n2, then LCA lies on right side. Otherwise root is LCA
     * (assuming that both n1 and n2 are present in BST)
     */
    public static <T> T lowestCommonAncestor(final BinarySearchTree<T> tree, final T node1,
                                             final T node2) {
        if ((tree != null) && (tree.getRoot() != null)) {
            return lowestCommonAncestor(tree.getRoot(), node1, node2);
        } else {
            throw new RuntimeException("TREE IS EMPTY");
        }
    }

    private static <T> T lowestCommonAncestor(final Node<T> root, final T node1, final T node2) {
        if (root == null)
            return null;
        if ((root.compareTo(node1) > 0) && (root.compareTo(node2) > 0)) {
            return lowestCommonAncestor(root.getLeftNode(), node1, node2);
        } else if ((root.compareTo(node1) < 0) && (root.compareTo(node2) < 0)) {
            return lowestCommonAncestor(root.getRightNode(), node1, node2);
        } else {
            return root.getValue();
        }
    }

    public static <T> BinaryTree<T> clone(Tree<T> tree)
            throws InstantiationException, IllegalAccessException {
        BinarySearchTree<T> clonedTree = new BinarySearchTree<>();
        if (tree.getRoot() != null) {
            Node<T> clonedRoot = new Node<T>();
            clonedRoot.setValue(tree.getRoot().getValue());
            clonedTree.setRoot(clonedRoot);
            clone(tree.getRoot(), clonedRoot);
        }
        return clonedTree;
    }

    private static <T> void clone(Node<T> root, Node<T> c_root) {
        if (root == null)
            return;
        Node<T> c_left = null, c_right = null;
        if (root.getLeftNode() != null) {
            c_left = new Node<T>();
            c_left.setValue(root.getLeftNode().getValue());
        }
        if (root.getRightNode() != null) {
            c_right = new Node<T>();
            c_right.setValue(root.getRightNode().getValue());
        }
        c_root.setValue(root.getValue());
        c_root.setLeftNode(c_left);
        c_root.setRightNode(c_right);
        clone(root.getLeftNode(), c_root.getLeftNode());
        clone(root.getRightNode(), c_root.getRightNode());
    }

    public static void adjustNodes(Node<Integer> node, int[] a) {
        try {
            if (node == null)
                return;
            adjustNodes(node.getLeftNode(), a);
            // System.out.println( node.getValue() );
            node.setValue(getAdjustedValue(node.getValue(), a));
            // System.out.println( node.getValue() );
            adjustNodes(node.getRightNode(), a);
        } catch (Exception e) {
        }
    }

    private static Integer getAdjustedValue(Integer value, int[] a) {
        for (int i : a) {
            if (value >= i) {
                value += i;
            }
        }
        return value;
    }
}
