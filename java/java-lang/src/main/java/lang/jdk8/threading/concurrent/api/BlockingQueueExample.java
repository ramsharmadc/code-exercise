package lang.jdk8.threading.concurrent.api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    protected static BlockingQueue<Object> bq = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c1 = new Consumer();
        Consumer c2 = new Consumer();
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}


class Producer implements Runnable {
    int c = 0;

    @Override
    public void run() {
        while (true) {
            try {
                BlockingQueueExample.bq.put(produce());
                Thread.sleep(100); // uncomment this to see effect
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object produce() {
        c += 1;
        System.out.println("Produced-" + "Object" + (c) + "<Queue size:"
                + BlockingQueueExample.bq.size() + ">");
        return "Object" + (c);
    }
}


class Consumer implements Runnable {
    int c = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                consume(BlockingQueueExample.bq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(Object O) {
        System.out.println("Consumed-" + O);
    }
}
