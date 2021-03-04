package dsa.tree;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestBinarySearchTree {

    @org.junit.Test
    public void testBasicOperations() {

        try {

            final BinaryTree<Integer> tree = new BinarySearchTree<>();
            tree.insert(50);
            tree.insert(20);
            tree.insert(10);
            tree.insert(30);
            tree.insert(70);
            tree.insert(60);
            tree.insert(90);

            System.out.println("INORDER :: " + tree.printStringInOrder());
            System.out.println("PREORDER :: " + tree.printStringPreOrder());
            System.out.println("POSTORDER :: " + tree.printStringPostOrder());
            System.out.println("MAX - " + tree.getMax());
            System.out.println("MIN - " + tree.getMinimun());

            // check if the root is correct
            System.out.format("[Given node = %d][Left child = %d][Right child = %d]\n",
                    tree.getRoot().getValue(), tree.getRoot().getLeftNode().getValue(),
                    tree.getRoot().getRightNode().getValue());

            // search test
            final Node<Integer> node = tree.searchNode(20);
            System.out.format("[Given node = %d][Left child = %d][Right child = %d]\n",
                    node.getValue(), node.getLeftNode().getValue(), node.getRightNode().getValue());

            // deleting a node, it should not be in tree
            tree.delete(20);

            final Node<Integer> nodeJustDeleted = tree.searchNode(70);
            System.out.format("[Given node = %d][Left child = %d][Right child = %d]\n",
                    nodeJustDeleted.getValue(), nodeJustDeleted.getLeftNode().getValue(),
                    nodeJustDeleted.getRightNode().getValue());

            System.out.println("INORDER :: " + tree.printStringInOrder());
            System.out.println("PREORDER :: " + tree.printStringPreOrder());
            System.out.println("POSTORDER :: " + tree.printStringPostOrder());

            System.out.format("[Given node = %d][Left child = %d][Right child = %d]\n",
                    tree.getRoot().getValue(), tree.getRoot().getLeftNode().getValue(),
                    tree.getRoot().getRightNode().getValue());
            System.out.format("[Given node = %d][Left child = %d][Right child = %d]\n",
                    tree.searchNode(30).getValue(),
                    (tree.searchNode(30).getLeftNode() != null
                            ? tree.searchNode(30).getLeftNode().getValue()
                            : 0),
                    (tree.searchNode(30).getRightNode() != null
                            ? tree.searchNode(30).getRightNode().getValue()
                            : 0));

            final BinaryTree<Character> treeOfCharacter = new BinarySearchTree<>();

            treeOfCharacter.insert('O');
            treeOfCharacter.insert('G');
            treeOfCharacter.insert('H');
            treeOfCharacter.insert('F');
            treeOfCharacter.insert('R');
            treeOfCharacter.insert('Q');
            treeOfCharacter.insert('T');

            System.out.println("INORDER :: " + treeOfCharacter.printStringInOrder());
            System.out.println("PREORDER :: " + treeOfCharacter.printStringPreOrder());
            System.out.println("POSTORDER :: " + treeOfCharacter.printStringPostOrder());

            System.out.println("MAX - " + treeOfCharacter.getMax());
            System.out.println("MIN - " + treeOfCharacter.getMinimun());

            // check if the root is correct
            System.out.format("[Given node = %c][Left child = %c][Right child = %c]\n",
                    treeOfCharacter.getRoot().getValue(),
                    treeOfCharacter.getRoot().getLeftNode().getValue(),
                    treeOfCharacter.getRoot().getRightNode().getValue());

            // search test
            final Node<Character> nodeOfChar = treeOfCharacter.searchNode('R');
            System.out.format("[Given node = %c][Left child = %c][Right child = %c]\n",
                    nodeOfChar.getValue(), nodeOfChar.getLeftNode().getValue(),
                    nodeOfChar.getRightNode().getValue());

            // deleting a node, it should not be in tree
            treeOfCharacter.delete('R');

            // Node<Character> nodeJustDeleted = tree.searchNode( 'R' ) ;
            // System.out.format(
            // "[Given node = %c][Left child = %c][Right child = %c]\n",
            // nodeJustDeleted.getValue(),
            // nodeJustDeleted.getLeftNode().getValue(),
            // nodeJustDeleted.getRightNode()
            // .getValue() ) ;

            System.out.println("INORDER :: " + treeOfCharacter.printStringInOrder());
            System.out.println("PREORDER :: " + treeOfCharacter.printStringPreOrder());
            System.out.println("POSTORDER :: " + treeOfCharacter.printStringPostOrder());

            System.out.format("[Given node = %c][Left child = %c][Right child = %c]\n",
                    treeOfCharacter.getRoot().getValue(),
                    treeOfCharacter.getRoot().getLeftNode().getValue(),
                    treeOfCharacter.getRoot().getRightNode().getValue());
            System.out.format("[Given node = %c][Left child = %c][Right child = %c]\n",
                    treeOfCharacter.searchNode('R').getValue(),
                    (treeOfCharacter.searchNode('R').getLeftNode() != null
                            ? treeOfCharacter.searchNode('R').getLeftNode().getValue()
                            : 0),
                    (treeOfCharacter.searchNode('R').getRightNode() != null
                            ? treeOfCharacter.searchNode('R').getRightNode().getValue()
                            : 0));
        } catch (final Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

    public void testPrintInReverseOrder() {

        // Integer tree
        final BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        System.out.println("IN - " + tree.printStringInOrder());
        System.out.println("PRE - " + tree.printStringPreOrder());
        System.out.println("POST - " + tree.printStringPostOrder());

        System.out.print("Reverse order : ");
        TreeUtils.printInReverseOrderStartingFromBottom(tree);
        System.out.println();

        // Character tree
        final BinaryTree<Character> treeStr = new BinarySearchTree<>();

        treeStr.insert('O');
        treeStr.insert('G');
        treeStr.insert('M');
        treeStr.insert('F');
        treeStr.insert('U');
        treeStr.insert('Z');
        treeStr.insert('P');

        System.out.println("IN - " + treeStr.printStringInOrder());
        System.out.println("PRE - " + treeStr.printStringPreOrder());
        System.out.println("POST - " + treeStr.printStringPostOrder());

        System.out.print("Reverse order : ");
        TreeUtils.printInReverseOrderStartingFromBottom(treeStr);

    }

    public void testCheckIfTwoIdenticalTrees() {

        // First tree
        final BinaryTree<Integer> treeOne = new BinarySearchTree<>();

        treeOne.insert(50);
        treeOne.insert(80);
        treeOne.insert(90);
        treeOne.insert(70);
        treeOne.insert(20);
        treeOne.insert(10);
        treeOne.insert(30);

        System.out.println("IN - " + treeOne.printStringInOrder());
        System.out.println("PRE - " + treeOne.printStringPreOrder());
        System.out.println("POST - " + treeOne.printStringPostOrder());

        // Second tree
        final BinaryTree<Integer> treeTwo = new BinarySearchTree<>();

        treeTwo.insert(50);
        treeTwo.insert(80);
        treeTwo.insert(90);
        treeTwo.insert(70);
        treeTwo.insert(20);
        treeTwo.insert(10);
        treeTwo.insert(30);
        treeTwo.insert(30);

        System.out.println("IN - " + treeTwo.printStringInOrder());
        System.out.println("PRE - " + treeTwo.printStringPreOrder());
        System.out.println("POST - " + treeTwo.printStringPostOrder());

        final boolean what = TreeUtils.checkIfIdenticalTrees(treeOne, treeTwo);
        System.out.println(what);
    }

    public void testCheckIfTwoNodesAreCousin() {

        final BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);

        System.out.println(tree.printStringInOrder());
        System.out.println(tree.printStringPostOrder());
        System.out.println(tree.printStringPreOrder());

        System.out.format("Are %d and %d cousins: ",
                tree.getRoot().getLeftNode().getLeftNode().getValue(),
                tree.getRoot().getRightNode().getLeftNode().getValue());
        System.out.println(TreeUtils.checkIfTwoNodesAreCousins(tree,
                tree.getRoot().getLeftNode().getLeftNode(),
                tree.getRoot().getRightNode().getLeftNode()));

        System.out.format("Are %d and %d cousins: ",
                tree.getRoot().getLeftNode().getRightNode().getValue(),
                tree.getRoot().getRightNode().getLeftNode().getValue());
        System.out.println(TreeUtils.checkIfTwoNodesAreCousins(tree,
                tree.getRoot().getLeftNode().getRightNode(),
                tree.getRoot().getRightNode().getLeftNode()));

        System.out.format("Are %d and %d cousins: ",
                tree.getRoot().getLeftNode().getRightNode().getValue(),
                tree.getRoot().getRightNode().getRightNode().getValue());
        System.out.println(TreeUtils.checkIfTwoNodesAreCousins(tree,
                tree.getRoot().getLeftNode().getRightNode(),
                tree.getRoot().getRightNode().getRightNode()));

        System.out.format("Are %d and %d cousins: ", tree.getRoot().getLeftNode().getValue(),
                tree.getRoot().getRightNode().getValue());
        System.out.println(TreeUtils.checkIfTwoNodesAreCousins(tree, tree.getRoot().getLeftNode(),
                tree.getRoot().getRightNode()));

        System.out.format("Are %d and %d siblings: ", tree.getRoot().getLeftNode().getValue(),
                tree.getRoot().getRightNode().getValue());
        System.out.println(TreeUtils.checkIfTwoNodesAreSiblings(tree, tree.getRoot().getLeftNode(),
                tree.getRoot().getRightNode()));
    }

    public void testPrintAllPathsOfATree() {

        final BinaryTree<Integer> treeOne = new BinarySearchTree<>();

        treeOne.insert(5);
        treeOne.insert(3);
        treeOne.insert(7);
        treeOne.insert(4);
        treeOne.insert(2);
        treeOne.insert(6);
        treeOne.insert(8);

        System.out.println("IN - " + treeOne.printStringInOrder());
        System.out.println("PRE - " + treeOne.printStringPreOrder());
        System.out.println("POST - " + treeOne.printStringPostOrder());

        TreeUtils.printAllPathOfTheTree(treeOne);
    }

    public void testSizeOfBinarySearchTree() {

        final BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        System.out.println("IN - " + tree.printStringInOrder());
        System.out.println("PRE - " + tree.printStringPreOrder());
        System.out.println("POST - " + tree.printStringPostOrder());

        final int sizeOne = TreeUtils.sizeOfBST(tree);
        final int sizeTwo = TreeUtils.sizeOfBSTRecursively(tree);

        System.out.println(sizeOne);
        System.out.println(sizeTwo);
    }

    public void testConvertTreeToList() {

        final BinaryTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(50);
        tree.insert(80);
        tree.insert(90);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);

        TreeUtils.convertToList(tree);
    }
}
