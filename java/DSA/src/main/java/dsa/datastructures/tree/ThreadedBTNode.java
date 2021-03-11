package dsa.datastructures.tree;

public class ThreadedBTNode<T> extends Node<T> {

    private boolean leftThread;
    private boolean rightThread;
    private Node<T> leftThreadNode;
    private Node<T> rightThreadNode;

    public ThreadedBTNode() {

        super();
    }

    public ThreadedBTNode(Node<T> newNode) {

        super(newNode.getValue());
    }

    public ThreadedBTNode(T val) {

        super(val);
    }

    public boolean isLeftThread() {

        return this.leftThread;
    }

    public void setLeftThread(boolean leftThread) {

        this.leftThread = leftThread;
    }

    public boolean isRightThread() {

        return this.rightThread;
    }

    public void setRightThread(boolean rightThread) {

        this.rightThread = rightThread;
    }

    protected Node<T> getLeftThreadNode() {

        return this.leftThreadNode;
    }

    protected void setLeftThreadNode(Node<T> leftThreadNode) {

        this.leftThreadNode = leftThreadNode;
    }

    protected Node<T> getRightThreadNode() {

        return this.rightThreadNode;
    }

    protected void setRightThreadNode(Node<T> rightThreadNode) {

        this.rightThreadNode = rightThreadNode;
    }
}
