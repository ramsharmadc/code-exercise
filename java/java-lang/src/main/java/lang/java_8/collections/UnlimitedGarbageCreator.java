package lang.java_8.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class UnlimitedGarbageCreator {

    private final ExecutorService service = Executors.newWorkStealingPool();

    private final BlockingQueue blockingQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {
        UnlimitedGarbageCreator unlimitedGarbageCreator = new UnlimitedGarbageCreator();

        unlimitedGarbageCreator.service.submit(() -> {
            try {
                unlimitedGarbageCreator.createGarbage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        unlimitedGarbageCreator.service.submit(() -> {
            try {
                unlimitedGarbageCreator.useGarbage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (true) {

        }
    }

    public void createGarbage() throws InterruptedException {
        while (true) {
            System.out.println("Thread-[" + Thread.currentThread().getName() + "-"
                    + Thread.currentThread().getId() + "]-> Garbage out");
            blockingQueue.put("garbage");
        }
    }

    public void useGarbage() throws InterruptedException {
        while (true) {
            Object garbage = blockingQueue.take();
            System.out.println("Thread-[" + Thread.currentThread().getName() + "-"
                    + Thread.currentThread().getId() + "]-> Garbage in");
        }
    }
}
