package dsa.queue;

public class TestQueue {

    public static void main(final String[] args) {

        new TestQueue().checkQueue();
    }

    public void checkQueue() {

        try {
            final Queue q = new Queue();

            for (int i = 0; i < 10; i++) {
                q.enqueue(i + 1);
            }

            q.display();

            for (int i = 0; i < 2; i++) {

                q.dequeue();
            }

            q.display();
        } catch (final Exception e) {
            System.out.println("Error occurred :: " + e.getMessage() + "\n Try Again");
        }
    }

}
