package dsa;

//import static java.lang.Thread.onSpinWait;

/**
 * int[] arr = {3, 5, 1, 8}
 * output: 4
 * <p>
 * output-
 * 4 -> 5
 * 5 -> 25
 * 2 -> 25
 * 25 -> -1
 * 3 -> 10
 * 10 -> -1
 * <p>
 * {5, 25, 25, -1, 10, -1}
 * <p>
 * <p>
 * <p>
 * 2 3 4 5 10 25
 * <p>
 * 4 -> 5 10 25
 * 5 -> 2 25 10
 */
public class Test1 {

    private static boolean signal = false;
    private final static Object lock = new Object();
    private final static int limit = 20;

    public static void main(String[] args) {

        Thread oddThread = new Thread(new OddTask(1, 2));
        Thread evenThread = new Thread(new EvenTask(2, 2));


        oddThread.start();

        evenThread.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static class EvenTask implements Runnable {

        private final int seed;
        private final int step;
        private int nextNumber;
        private int count = 0;
        public EvenTask(int seed, int step) {
            this.seed = seed;
            this.step = step;
            this.nextNumber = seed;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (count < limit) {
                    while (!signal) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if (signal) {
                        System.out.format("Even thread : %s\n", nextNumber);
                        nextNumber += step;
                        signal = false;
                        count++;
                        lock.notify();
                    }

                }
            }
        }
    }

    static class OddTask implements Runnable {

        private final int seed;
        private final int step;
        private int nextNumber;
        private int count = 0;

        public OddTask(int seed, int step) {
            this.seed = seed;
            this.step = step;
            this.nextNumber = seed;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (count < limit) {
                    while (signal) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (!signal) {
                        System.out.format("Odd thread : %s\n", nextNumber);
                        nextNumber += step;
                        signal = true;
                        count++;
                        lock.notify();
                    }

                }
            }
        }
    }
}
