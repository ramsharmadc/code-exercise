package practice.javalang8.javalang;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateNewThread {

    private Lock objectsLock = new ReentrantLock();
   

    public static void main(String[] args) {
        Thread simpleThread = new SimpleThread();
        simpleThread.start();

        Thread runnabThread = new Thread(new SimpleRunnableTask());
        runnabThread.start();

        CreateNewThread createNewThread = new CreateNewThread();
        createNewThread.checkLocks(createNewThread);
    }

    static class SimpleThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running a thread extension");
        }
    }

    static class SimpleRunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Running a runnable task");
        }
    }

    public void checkLocks(CreateNewThread createNewThread) {
        Lock lockObj = new ReentrantLock();
        createNewThread.objectsLock.tryLock();
        lockObj.tryLock();
        System.out.println("implicitly acquired lock");
        lockObj.unlock();
        createNewThread.objectsLock.unlock();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new SimpleThread());
        executorService.submit(new SimpleRunnableTask());

        executorService.shutdown();
    }
}
