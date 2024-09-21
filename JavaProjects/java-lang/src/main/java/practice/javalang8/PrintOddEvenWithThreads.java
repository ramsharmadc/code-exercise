package practice.javalang8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintOddEvenWithThreads {

    private static SharedLock sharedLock = new SharedLock();

    public static void main(String[] args) {
        sharedLock.setSignalFlag(true);

        EvenNumberThread evenNumberThread = new EvenNumberThread(sharedLock);
        OddNumberThread oddNumberThread = new OddNumberThread(sharedLock);

        ExecutorService oddExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService evenExSvc = Executors.newSingleThreadExecutor();

        ExecutorService twoThreadsSvc = Executors.newFixedThreadPool(2);
        twoThreadsSvc.submit(oddNumberThread);
        twoThreadsSvc.submit(evenNumberThread);
        twoThreadsSvc.shutdown();

        // oddExecutorService.submit(oddNumberThread);
        // evenExSvc.submit(evenNumberThread);

        //oddExecutorService.shutdown();
        //evenExSvc.shutdown();

        /*
         * Thread t1 = new Thread(oddNumberThread);
         * Thread t2 = new Thread(evenNumberThread);
         * 
         * t1.start();
         * t2.start();
         * 
         * try {
         * t1.join();
         * t2.join();
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * 
         */
    }
}
