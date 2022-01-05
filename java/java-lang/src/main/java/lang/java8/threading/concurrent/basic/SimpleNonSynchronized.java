package lang.java8.threading.concurrent.basic;

public class SimpleNonSynchronized {

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new NonSynchronizedCounter(), "thread-" + i);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class NonSynchronizedCounter implements Runnable {

    int counter = 0;

    @Override
    public void run() {
        while (counter < 10) {
            System.out.println(
                    "[" + Thread.currentThread().getName() + "] counter before:: " + counter);
            counter++;
            System.out.println(
                    "[" + Thread.currentThread().getName() + "] counter after:: " + counter);
        }
    }
}
