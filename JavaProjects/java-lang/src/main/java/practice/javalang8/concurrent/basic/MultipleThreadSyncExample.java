package practice.javalang8.concurrent.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Print series 010203040506. Using multi-threading 1st thread will print only 0 then 2nd thread will
 * print only even numbers and 3rd thread print only odd numbers.
 *
 * @author ramsharma
 */
public class MultipleThreadSyncExample {

    private static boolean flag;
    private int st = 0;

    public static void main(String[] args) {

        MultipleThreadSyncExample ths = new MultipleThreadSyncExample();
        Thread printZero = new Thread(new ZeroThread(ths));
        Thread printOdd = new Thread(new OddThread(ths));
        Thread printEven = new Thread(new EvenThread(ths));

        // printZero.start();
        // printOdd.start();
        // printEven.start();

        try  {
            ExecutorService exc = Executors.newFixedThreadPool(3);
            exc.submit(printZero);
            exc.submit(printOdd);
            exc.submit(printEven);

            exc.shutdown();
        }finally {
            System.out.println("Triage finished");

        }
    }

    static class OddThread implements Runnable {
        private final MultipleThreadSyncExample cb;
        public OddThread(MultipleThreadSyncExample ths) {
            this.cb = ths;
        }
        @Override
        public void run() {
            for (int i = 1; i < 10; i = i + 2) {
                synchronized (cb) {
                    while (cb.st != 1) {
                        try {
                            cb.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    // i += 2;
                    cb.st = 0;
                    cb.notifyAll();
                }
                // cb.await();
            }
        }
    }

    static class EvenThread implements Runnable {
        private final MultipleThreadSyncExample cb;
        public EvenThread(MultipleThreadSyncExample ths) {
            this.cb = ths;
        }
        @Override
        public void run() {
            for (int i = 2; i < 10; i = i + 2) {
                synchronized (cb) {
                    while (cb.st != 2) {
                        try {
                            cb.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    // i += 2;
                    cb.st = 0;
                    cb.notifyAll();
                }
                // cb.await();
            }
        }
    }

    static class ZeroThread implements Runnable {
        private final MultipleThreadSyncExample cb;
        public ZeroThread(MultipleThreadSyncExample ths) {
            this.cb = ths;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (cb) {
                    while (cb.st != 0) {
                        try {
                            cb.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("0");
                    if (flag) {
                        cb.st = 2;
                        flag = false;
                    } else {
                        cb.st = 1;
                        flag = true;
                    }
                    cb.notifyAll();
                }
            }
        }
    }
}
