package dsa.queue;

public class Queue<T> {

    private Node<T> front = null;
    private Node<T> rear = null;

    public T dequeue() {

        if (front == null)
            return null;
        else {
            final Node<T> tempFront = front;
            front = tempFront.getNext();

            return tempFront.getValue();
        }
    }

    public T peek() {
        if (front == null)
            return null;
        return front.getValue();
    }

    public String display() throws Exception {

        StringBuilder displayStr = new StringBuilder();

        Node<T> tempFront = front;

        if (front == null) {
            System.out.println();
        } else {
            while (tempFront.getNext() != null) {

                displayStr.append(tempFront.getValue() + " ");
                System.out.print(tempFront.getValue() + " ");
                tempFront = tempFront.getNext();
            }

            displayStr.append(tempFront.getValue() + " ");
            System.out.print(tempFront.getValue());
            System.out.println();
        }

        return displayStr.toString();
    }

    public void enqueue(final T item) {

        if (front == null) {

            rear = new Node<T>(item);

            // rear.setValue(item);
            rear.setAhead(null);
            rear.setNext(null);

            front = rear;
        } else {

            Node<T> temp = front;

            while (temp.getNext() != null) {

                temp = temp.getNext();
            }

            final Node<T> node = new Node<T>(item);

            // node.setValue(item);
            node.setAhead(temp);
            node.setNext(null);

            rear = node;

            temp.setNext(rear);
        }
    }

    public boolean isEmpty() {

        return (front == null);
    }

    public int size() {

        final Node<T> tempFront = front;

        return size(0, tempFront);
    }

    private int size(final int _count, final Node<T> _front) {

        if (_front == null)
            return _count;

        return size((_count + 1), _front.getNext());
    }

    @Override
    public String toString() {
        try {
            return display();
        } catch (Exception e) {
            return "";
        }
    }

    // iterative method
    private int size(Node<T> tempFront) {

        int count = 0;
        if (tempFront == null) {
            return count;
        } else {
            do {
                count += 1;
                tempFront = tempFront.getNext();
            } while (tempFront.getNext() != null);
            return count;
        }

    }

    public static class Node<T> {

        private Node<T> ahead;
        private Node<T> next;
        private T value;

        public Node() {

            this.ahead = null;
            this.next = null;
            this.value = null;
        }

        public Node(final T item) {

            this.value = item;
            this.ahead = null;
            this.next = null;
        }

        /**
         * @return the first
         */
        public Node<T> getAhead() {

            return ahead;
        }

        /**
         * @param first the first to set
         */
        public void setAhead(final Node<T> ahead) {

            this.ahead = ahead;
        }

        /**
         * @return the last
         */
        public Node<T> getNext() {

            return next;
        }

        /**
         * @param last the last to set
         */
        public void setNext(final Node<T> next) {

            this.next = next;
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
        public void setValue(final T value) {

            this.value = value;
        }

        @Override
        public String toString() {

            // TODO Auto-generated method stub
            return getValue().toString();
        }
    }
}
