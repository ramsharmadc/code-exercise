package code.main.app;

import java.util.concurrent.LinkedBlockingQueue;

public class LoadQueue {

    private final static LinkedBlockingQueue<Object> loadQueue = new LinkedBlockingQueue<Object>();
    private final static ExecutorServiceUtil exUtil = new ExecutorServiceUtil();

    public void add(Object obj) {

        exUtil.submitTask(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Producing.." + obj);
            loadQueue.add(obj);
        });
//        loadQueue.add(obj);
    }

    public void get() {
        exUtil.submitTask(() -> {
            System.out.println("[" + Thread.currentThread().getName() + "] Consumed -" + loadQueue.poll() + ". Waiting...");
        });
    }

}
