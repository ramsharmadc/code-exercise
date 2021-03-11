package dsa.datastructures.list;

public interface ListADT<T> {
    void addAll(LinkedList<T> list) throws Exception;

    void delete(int index) throws Exception;

    Node<T> find(Node<T> head, int n);

    void insert(T val);

    void insert(T[] nodes);

    Node<T> insertAt(T val, int pos) throws Exception;

    int length() throws Exception;

    void reverse();

    void showList();

    void sort() throws Exception;
}
