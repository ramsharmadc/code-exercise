package lang.jdk8.threading.concurrent.basic;

public class Example01 implements Runnable {
    private static volatile int count = 0;

    public Example01() {
        System.out.println("Thread start up.");
    }

    public static void main(final String[] args) throws InterruptedException {
        final Example01 newObj = new Example01();
        final Thread th1 = new Thread(newObj);
        final Thread th2 = new Thread(newObj);
        final Thread th3 = new Thread(newObj);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

        System.out.println("Thread End.");
    }

    public synchronized void print() {
        for (; count <= 20; count++) {
            System.out.print(count + "|");
        }
    }

    // @Override
    public void run() {
        print();
    }
}
