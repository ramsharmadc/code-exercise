package lang.java8.threading.concurrent.basic.InterThreadComm;

class Consumer implements Runnable {
    SharedQueue sharedQueue;

    Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        System.out.printf("Starting reading the shared queue...\n");
        while (true) {
            sharedQueue.get();
        }
    }
}


class Producer implements Runnable {
    SharedQueue sharedQueue;

    Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        System.out.printf("Starting writing to the shared queue...\n");
        int i = 0;
        while (true) {
            sharedQueue.put(i++);
        }
    }
}


class ProducerConsumerFixed {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();
        new Producer(sharedQueue);
        new Consumer(sharedQueue);
        System.out.println("Press Control-C to stop.");
    }
}


// A correct implementation of a producer and consumer.
class SharedQueue {
    int n;
    int waitFlag = 0;
    int maxRun = 20;

    synchronized int get() {
        if (waitFlag == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Get :: " + n);
        waitFlag = 0;
        notifyAll();
        return n;
    }

    synchronized void put(int n) {
        if (this.n < maxRun) {
            if (waitFlag == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }
            }
            this.n = n;
            waitFlag = 1;
            System.out.println("Put :: " + n);
            notifyAll();
        }
    }
}
