import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintTask {

    private static SharedLock sharedLock = new SharedLock();

    public static void main(String[] args) {

        sharedLock.setSignalFlag(true);

        EvenNumberThread evenNumberThread = new EvenNumberThread(sharedLock);
        OddNumberThread oddNumberThread = new OddNumberThread(sharedLock);

        ExecutorService oddExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService evenExSvc = Executors.newSingleThreadExecutor();
        int i = 0;
        while (i++ < 1) {
            oddExecutorService.submit(oddNumberThread);
            evenExSvc.submit(evenNumberThread);
        }
        oddExecutorService.shutdown();
        evenExSvc.shutdown();

       /* Thread t1 = new Thread(oddNumberThread);
        Thread t2 = new Thread(evenNumberThread);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */
    }
}
