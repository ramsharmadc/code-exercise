package practice.javalang8.concurrent.basic;

import java.util.stream.IntStream;

public class ExtendingThread extends Thread {

    // @Override
    /*
     * public void run() { // TODO Auto-generated method stub System.out.println("In run"); }
     */

    public ExtendingThread() {

        super("Thread");
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("ExtendingThread's main thread --- started");
        IntStream.range(0, 5).forEach(x -> {
            System.out.println("calling child's thread run ---");
            new ExtendingThread().start();
        });
        System.out.println("ExtendingThread's main thread --- ended");
    }

    @Override
    public synchronized void start() {

        System.out.println("In start");
    }

}
