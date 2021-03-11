package dsa.datastructures.stack;

public class Stack<T> {
    private Node<T> tos = null;

    public boolean isEmpty() {
        return tos == null;
    }

    public T peek() {
        if (tos == null)
            return null;
        else
            return tos.getValue();
    }

    public T pop() throws Exception {
        if (tos == null)
            throw new Exception("Stack underflow");
        else {
            final T i = tos.getValue();
            tos = tos.getNext();
            return i;
        }
    }

    public void printStack() {
        if (tos == null) {
            System.out.println("Stack Empty !!");
        } else {
            while (tos.getNext() != null) {
                System.out.print(tos.getValue() + " ");
                tos = tos.getNext();
            }
            System.out.println(tos.getValue());
        }
    }

    public void push(final T item) {
        if (tos == null) {
            tos = new Node<T>();
            tos.setValue(item);
            tos.setNext(null);
            tos.setPrevious(null);
        } else {

            final Node<T> node = new Node<T>(item);
            node.setNext(tos);
            tos.setPrevious(node);
            tos = node;
        }
    }

    public static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T value;

        public Node() {

            setNext(null);
            setPrevious(null);
            setValue(null);
        }

        public Node(T item) {

            this();
            setValue(item);
        }

        /**
         * @return the next
         */
        public Node<T> getNext() {

            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node<T> next) {

            this.next = next;
        }

        /**
         * @return the previous
         */
        public Node<T> getPrevious() {

            return previous;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(Node<T> previous) {

            this.previous = previous;
        }

        /**
         * @return the value
         */
        public T getValue() {

            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(T value) {

            this.value = value;
        }

        @Override
        public String toString() {

            // TODO Auto-generated method stub
            return getValue().toString();
        }
    }
}
