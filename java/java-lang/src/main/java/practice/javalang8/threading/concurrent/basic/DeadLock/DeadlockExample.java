package practice.javalang8.threading.concurrent.basic.DeadLock;

import java.util.Random;

public class DeadlockExample implements Runnable {

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new DeadlockExample(), "_thread_dl-1");
        Thread myThread2 = new Thread(new DeadlockExample(), "_thread_dl-2");

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            boolean b = random.nextBoolean();

            if (b) {
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] trying to lock resource 1");
                synchronized (resource1) {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] locked resource 1");
                }
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] trying to lock resource 2");
                synchronized (resource2) {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] locked resource 2");
                }
            } else {
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] trying to lock resource 2");
                synchronized (resource2) {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] locked resource 2");
                }
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] trying to lock resource 1");
                synchronized (resource1) {
                    System.out.println(
                            "[" + Thread.currentThread().getName() + "] locked resource 1");
                }
            }
        }
    }
}
