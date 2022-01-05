package lang.java8.threading.concurrent.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ImplementingThreadPool {

    private final BlockingQueue<Runnable> bq;
    private final List<SimpleThread> threadPool = new ArrayList<SimpleThread>();

    public ImplementingThreadPool(int _numOfThreads, int _numOfTasks) {
        bq = new LinkedBlockingQueue<>(_numOfTasks);
        for (int i = 0; i <= _numOfThreads; i++) {
            threadPool.add(new SimpleThread(bq));
        }
    }

    public static void main(String[] args) {
        ImplementingThreadPool threadPoolService = new ImplementingThreadPool(10, 10);
        for (SimpleThread threadFromPool : threadPoolService.threadPool) {
            threadFromPool.start();
        }
    }
}


class SimpleThread extends Thread {
    private final BlockingQueue<Runnable> bq;
    private final boolean isStopped = false;

    public SimpleThread(BlockingQueue<Runnable> _bq) {
        bq = _bq;
    }

    @Override
    public void run() {
        while (!(isStopped())) {
            Runnable task = bq.remove();
            task.run();
        }
    }

    public boolean isStopped() {
        return this.isStopped;
    }
}
