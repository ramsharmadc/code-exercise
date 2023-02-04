package practice.javalang;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateNewThread {

    Lock objectsLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new SimpleThread();
        t1.start();

        Thread t2 = new Thread(new SimpleRunnableTask());
        t2.start();

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

        Executor executor = Executors.newSingleThreadExecutor();
    }
}
