package practice.javalang8.concurrent.basic.producerconsumer;

class SharedLock {
    private int content;
    private int lockBit = 1;

    public synchronized int get() {
        while (lockBit == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        lockBit = 1;
        notifyAll();
        System.out.println("Consumed-" + content);
        return content;
    }

    public synchronized void put(int value) {
        while (lockBit == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        content = value;
        System.out.println("Produced-" + value);
        lockBit = 0;
        notifyAll();
    }
}


class Consumer extends Thread {
    private final SharedLock lock;

    public Consumer(SharedLock c) {
        lock = c;
    }

    @Override
    public void run() {
        lock.get();
        // try {
        // sleep((int) (Math.random() * 10));
        // } catch (InterruptedException e) {
        // }
    }
}


class Producer extends Thread {
    private final SharedLock lock;

    public Producer(SharedLock c) {
        lock = c;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            lock.put(i++);
            // try {
            // sleep((int) (Math.random() * 10));
            // } catch (InterruptedException e) {
            // }
        }
    }
}


public class ProducerConsumer {
    public static void main(String[] args) {
        SharedLock l = new SharedLock();
        Producer p = new Producer(l);
        Consumer c = new Consumer(l);
        p.start();
        c.start();
    }
}
