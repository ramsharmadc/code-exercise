package dsa.tree;

public interface Tree<T> extends Cloneable {

    void insert(T val);

    Node<T> searchNode(T val);

    void delete(T val);

    T getMax();

    T getMinimun();

    Node<T> getRoot();

    void setRoot(Node<T> node);

    String printStringPreOrder();

    String printStringInOrder();

    String printStringPostOrder();
}
