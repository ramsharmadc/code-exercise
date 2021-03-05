package dsalgo.tree;

public class SingleThreadBinaryTree<T> extends ThreadedBinaryTree<T> {
    @Override
    public void insert(T val) {
        ThreadedBTNode<T> newNode = new ThreadedBTNode<T>(val);
        if (getRoot() == null) {
            setRoot(newNode);
        } else {
            insert((ThreadedBTNode<T>) getRoot(), newNode);
        }
    }

    private void insert(ThreadedBTNode<T> node, ThreadedBTNode<T> newNode) {
        if (node.compareTo(newNode.getValue()) >= 0) {
            if (node.getLeftNode() != null) {
                insert((ThreadedBTNode<T>) node.getLeftNode(), newNode);
            } else {
                node.setRightThread(false);
                newNode.setRightThread(false);
                insertIntoLeft(node, newNode);
            }
        } else {
            if (node.getRightNode() != null) {
                insert((ThreadedBTNode<T>) node.getRightNode(), newNode);
            } else {
                node.setRightThread(false);
                newNode.setRightThread(false);
                insertIntoRight(node, newNode);
            }
        }
    }

    private void insertIntoRight(ThreadedBTNode<T> node, ThreadedBTNode<T> newNode) {

        ThreadedBTNode<T> rightNode = new ThreadedBTNode<T>(newNode);
        rightNode.setRightThreadNode(node.getParent());
        rightNode.setParent(node);
        rightNode.setRightThread(true);

        node.setRightNode(rightNode);
    }

    private void insertIntoLeft(ThreadedBTNode<T> node, ThreadedBTNode<T> newNode) {

        ThreadedBTNode<T> leftNode = new ThreadedBTNode<T>(newNode);
        leftNode.setRightThreadNode(node);
        leftNode.setParent(node);
        leftNode.setRightThread(true);

        node.setLeftNode(leftNode);
    }

    @Override
    public Node<T> searchNode(T val) {

        return null;
    }

    @Override
    public void delete(T val) {

    }

    @Override
    public T getMax() {

        if (getRoot() == null)
            return null;

        else if (getRoot().getRightNode() == null)
            return getRoot().getValue();

        else
            return getMax(getRoot().getRightNode());
    }

    private T getMax(Node<T> rightNode) {

        if (rightNode.getRightNode() == null)
            return rightNode.getValue();

        else
            return getMax(rightNode.getRightNode());
    }

    @Override
    public T getMinimun() {

        if (getRoot() == null)
            return null;

        else if (getRoot().getLeftNode() == null)
            return getRoot().getValue();

        else
            return getMinimum(getRoot().getLeftNode());
    }

    private T getMinimum(Node<T> leftNode) {

        if (leftNode.getLeftNode() == null)
            return leftNode.getValue();

        else
            return getMinimum(leftNode.getLeftNode());
    }

    @Override
    public String printStringInOrder() {

        StringBuilder strB = new StringBuilder("[");

        if (getRoot() == null)
            return "Tree Empty Error";

        else
            traverseInOrder((ThreadedBTNode<T>) getRoot(), strB);

        return strB.append("]").toString();
    }

    private void traverseInOrder(ThreadedBTNode<T> node, StringBuilder strB) {

        if (node == null)
            return;

        if (node.isRightThread()) {
            strB.append(node.getValue() + ", ");
            strB.append(node.getRightThreadNode().getValue() + ", ");
        }

        traverseInOrder((ThreadedBTNode<T>) node.getLeftNode(), strB);
        traverseInOrder((ThreadedBTNode<T>) node.getRightNode(), strB);
    }
}
