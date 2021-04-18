package lang.java_8.threading.concurrent.api.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseLock {

    public static void main(String[] args) {
        /*
         * for (int i = 0; i < 100; i++) { new Thread(UseLock::startSomething).start(); }
         */

        ExecutorService threadExecutorService = Executors.newFixedThreadPool(2);

        Map<String, String> m1 = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            m1.put(String.valueOf(i), "str(" + i + ")");
        }

        for (int i = 0; i < 100; i++) {
            final String iStr = String.valueOf(i);
            threadExecutorService.submit(() -> UseLock.readSomething(iStr, m1));
        }
        /*
         * for (int i = 0; i < 100; i++) { final String iStr = String.valueOf(i);
         * threadExecutorService.submit(() -> UseLock.writeSomething(iStr, iStr + "_updated", m1));
         * }
         */

        Thread.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
    }

    private static void startSomething() {
        Lock l1 = new ReentrantLock();
        // l1.lock();

        // instead of lock() we can use tryLock()
        l1.tryLock();

        System.out.println("printing after lock 1 :: " + Thread.currentThread().getName());

        l1.unlock();

        Lock l2 = new ReentrantLock();
        l2.lock();

        System.out.println("printing after lock 2 :: " + Thread.currentThread().getName());

        l2.unlock();
    }

    public static void readSomething(String key, Map<String, String> repository) {
        ReadWriteLock l1 = new ReentrantReadWriteLock();
        String value;
        l1.readLock().tryLock();
        try {
            System.out.println("[" + Thread.currentThread().getId() + "] Reading repository:: "
                    + (value = repository.get(key)));
        } finally {
            l1.readLock().unlock();
        }
    }

    public static void writeSomething(String key, String value, Map<String, String> repository) {
        ReadWriteLock l1 = new ReentrantReadWriteLock();
        l1.writeLock().tryLock();
        try {
            System.out.println("[" + Thread.currentThread().getId() + "] Writing repository:: "
                    + repository.put(key, value));
        } finally {
            l1.writeLock().unlock();
        }
    }
}
