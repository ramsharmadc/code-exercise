package dsalgo.tree;

import java.util.Objects;

public class TreeRotator<T> {

    public void leftRotate(Tree<T> t, Node<T> x) {
        Node<T> y = x.getRightNode();
        x.setRightNode(y.getLeftNode());
        if (!(isSentinal(y.getLeftNode()))) {
            y.getLeftNode().setParent(x);
        }
        y.setParent(x.getParent());
        if (isSentinal(x.getParent())) {
            t.setRoot(y);
        } else if (x == x.getParent().getLeftNode()) {
            x.getParent().setLeftNode(y);
        } else {
            x.getParent().setRightNode(y);
        }
        y.setLeftNode(x);
        x.setParent(y);
    }

    public void rightRotate(Tree<T> t, Node<T> y) {
        Node<T> x = y.getLeftNode();
        x.setRightNode(y);
        x.setParent(y.getParent());
        y.setParent(x);
        y.setLeftNode(x.getRightNode());
    }

    private boolean isSentinal(Node<T> node) {
        return Objects.isNull(node);
    }
}
