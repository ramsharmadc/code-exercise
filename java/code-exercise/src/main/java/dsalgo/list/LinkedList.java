package dsalgo.list;

public class LinkedList<T> implements ListADT<T> {

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    @Override
    public void addAll(final LinkedList<T> list) throws Exception {
        if ((this.getHead() == null) && (list.getHead() == null))
            throw new Exception("Both lists empty Exception");
        else if ((this.getHead() == null) && (list.getHead() != null)) {
            this.setHead(list.getHead());
        } else if ((this.getHead() != null) && (list.getHead() == null)) {
            list.setHead(this.getHead());
        } else {
            Node<T> tempHead = this.getHead();
            while (tempHead.getNext() != null) {
                tempHead = tempHead.getNext();
            }
            if (tempHead.getNext() == null) {
                tempHead.setNext(list.getHead());
                list.getHead().setPrevious(tempHead);
            }
        }
    }

    @Override
    public void delete(final int index) throws Exception {

        if (head == null)
            throw new Exception("List Empty.");

        if (index == 1)
            setHead(getHead().getNext());

        if (index == this.length()) {
            Node<T> tempHead = this.getHead();
            while (tempHead.getNext() != null) {
                tempHead = tempHead.getNext();
            }
            tempHead.getPrevious().setNext(null);
        }

        if (index > this.length())
            throw new Exception("Index out of bound Exception.");
        else {
            Node<T> tempHead = this.getHead();
            int idx = 1;

            while (tempHead.getNext() != null) {
                tempHead = tempHead.getNext();
                idx++;

                if (idx == index) {
                    break;
                }
            }

            if (idx == index) {
                tempHead.getPrevious().setNext(tempHead.getNext());
                tempHead.getNext().setPrevious(tempHead.getPrevious());
            }
        }
    }

    public void deleteFirst() throws Exception {
        if (this.getHead() == null)
            throw new Exception("List Empty.");

        if (this.getHead().getNext() == null)
            this.setHead(null);

        final Node<T> tempHead = this.getHead().getNext();
        this.setHead(tempHead);
    }

    public void deleteLast() throws Exception {

        delete(this.length());
    }

    @Override
    public Node<T> find(final Node<T> head, int n) {
        Node<T> p1 = head;
        Node<T> p2 = head;

        while ((p1.getNext() != null) && (n-- > 1)) {
            if ((p1.getNext() == null) || (n < 1))
                return null;
            else {
                p1 = p1.getNext();
            }
        }

        while (p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

    public Node<T> getHead() {

        return head;
    }

    public void setHead(final Node<T> head) {

        this.head = head;
    }

    private int getLength(Node<T> head) throws Exception {
        int len = 0;
        if (head == null)
            return 0;

        while (head.getNext() != null) {
            head = head.getNext();
            len++;
        }

        if (head != null) {
            len += 1;
        }

        return len;
    }

    @Override
    public void insert(final T val) {
        final Node<T> node = new Node<T>(val);

        if (this.getHead() == null) {
            node.setHead(this.getHead());
            node.setNext(null);
            node.setPrevious(this.getHead());
            this.setHead(new Node<>(node));
        } else {
            Node<T> temp = this.getHead();

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            node.setNext(null);
            node.setPrevious(temp);
            temp.setNext(node);
        }
    }

    @Override
    public void insert(final T[] nodes) {

        for (final T each : nodes) {
            insert(each);
        }
    }

    @Override
    public Node<T> insertAt(final T val, final int pos) throws Exception {

        final Node<T> node = new Node<>(val);

        if (this.getHead() == null) {
            node.setHead(this.getHead());
            node.setNext(null);
            node.setPrevious(this.getHead());
            this.setHead(new Node<>(node));
        } else {
            if ((pos > (this.length() + 1)) || (pos < 1))
                throw new Exception("Position out of length of the List. Try with in-range index");
            if (pos == 1) {
                node.setNext(this.getHead());
                node.setPrevious(null);
                this.getHead().setPrevious(node);
                this.setHead(node);
            } else if (pos == (this.length() + 1)) {
                Node<T> tempHead = this.getHead();
                while (tempHead.getNext() != null) {
                    tempHead = tempHead.getNext();
                }
                node.setPrevious(tempHead);
                node.setNext(null);
                tempHead.setNext(node);
            } else {
                int indx = 1;
                Node<T> tempHead = head;
                while (tempHead.getNext() != null) {
                    tempHead = tempHead.getNext();
                    indx++;

                    if (indx == pos) {
                        break;
                    }
                }

                node.setPrevious(tempHead.getPrevious());
                node.setNext(tempHead);
                tempHead.getPrevious().setNext(node);
                tempHead.setPrevious(node);
            }
        }

        return head;
    }

    public void insertAtBeginning() {

    }

    public boolean isEmpty() {

        return (this.head == null);
    }

    @Override
    public int length() throws Exception {

        final Node<T> head = this.getHead();

        return getLength(head);
    }

    private String listAsString() {

        final StringBuffer strBuff = new StringBuffer();
        if (this.getHead() != null) {

            Node<T> tempHead = this.getHead();

            strBuff.append("[");

            while (tempHead.getNext() != null) {

                strBuff.append(tempHead.getValue() + ",");
                tempHead = tempHead.getNext();
            }

            if (tempHead != null) {
                strBuff.append(tempHead.getValue());
            }

            strBuff.append("]");
        } else {
            strBuff.append("List Empty.");
        }

        return strBuff.toString();
    }

    @Override
    public void reverse() {

        Node<T> tempHead = this.getHead();

        while (tempHead.getNext() != null) {
            Node<T> parentNode = tempHead;
            Node<T> childNode = parentNode.getNext();

            parentNode.getNext().setNext(parentNode);
            // tempHead.setNext( null );

            parentNode = childNode;
            childNode = childNode.getNext();
            tempHead = tempHead.getNext();
        }
    }

    @Override
    public void showList() {

        if (this.getHead() != null) {

            Node<T> tempHead = this.getHead();

            System.out.print("[ ");

            while (tempHead.getNext() != null) {

                System.out.print(tempHead.getValue().toString() + ", ");
                tempHead = tempHead.getNext();
            }

            if (tempHead != null) {
                System.out.print(tempHead.getValue());
            }

            System.out.println(" ]");
        } else {
            System.out.println("List is Empty.");
        }
    }

    @Override
    public void sort() throws Exception {

        sortInAsc();
    }

    public void sort(final OrderBy order) throws Exception {

        switch (order) {
            case DESC:
                sortInDesc();
                break;
            case ASC:
                sortInAsc();
                break;
            default:
                break;
        }
    }

    private void sortInAsc() throws Exception {
        Node<T> tempHead = (this.getHead() != null) ? this.getHead() : null;

        if ((this.length() <= 1) || (tempHead == null))
            return;

        while (tempHead != null) {
            T smallest = tempHead.getValue();
            Node<T> tempNext = (tempHead.getNext() != null) ? tempHead.getNext() : null;

            while (tempNext != null) {
                final T currentVal = tempNext.getValue();

                if (Integer.valueOf(currentVal.toString()) < Integer.valueOf(smallest.toString())) {
                    tempNext.setValue(smallest);
                    tempHead.setValue(currentVal);
                    smallest = currentVal;
                }
                tempNext = (tempNext.getNext() != null) ? tempNext.getNext() : null;
            }
            tempHead = (tempHead.getNext() != null) ? tempHead.getNext() : null;
        }
    }

    private void sortInDesc() throws Exception {
        Node<T> tempHead = (this.getHead() != null) ? this.getHead() : null;
        if ((this.length() <= 1) || (tempHead == null))
            return;

        while (tempHead != null) {
            T smallest = tempHead.getValue();
            Node<T> tempNext = (tempHead.getNext() != null) ? tempHead.getNext() : null;

            while (tempNext != null) {
                final T currentVal = tempNext.getValue();

                if (Integer.valueOf(currentVal.toString()) > Integer.valueOf(smallest.toString())) {
                    tempNext.setValue(smallest);
                    tempHead.setValue(currentVal);
                    smallest = currentVal;
                }
                tempNext = (tempNext.getNext() != null) ? tempNext.getNext() : null;
            }
            tempHead = (tempHead.getNext() != null) ? tempHead.getNext() : null;
        }
    }

    @Override
    public String toString() {

        return this.listAsString();
    }

    enum OrderBy {
        ASC, DESC
    }
}
