package dsa.tree;

/**
 * In-order traversal of a Binary tree is either be done using recursion or with the use of a
 * auxiliary stack. The idea of threaded binary trees is to make in-order traversal faster and do it
 * without stack and without recursion. A binary tree is made threaded by making all right child
 * pointers that would normally be NULL point to the in-order successor of the node (if it exists).
 * There are two types of threaded binary trees. Single Threaded: Where a NULL right pointers is
 * made to point to the in-order successor (if successor exists) Double Threaded: Where both left
 * and right NULL pointers are made to point to in-order predecessor and in-order successor
 * respectively. The predecessor threads are useful for reverse in-order traversal and postorder
 * traversal.
 *
 * @param <T>
 * @author lenovo
 */
public abstract class ThreadedBinaryTree<T> extends BinaryTree<T> {

    @Override
    public abstract void insert(T val);

    @Override
    public abstract Node<T> searchNode(T val);

    @Override
    public abstract void delete(T val);

    @Override
    public abstract T getMax();

    @Override
    public abstract T getMinimun();
}
