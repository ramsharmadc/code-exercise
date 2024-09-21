package code.main.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtil {
    
    private final static int threadCount = 2;

    public ExecutorServiceUtil() {
        for (int i = 0; i < threadCount; i++)
            threadPool[i] = Executors.newCachedThreadPool();
    }

    private final static ExecutorService[] threadPool = new ExecutorService[threadCount];

    public void submitTask(Runnable task) {
        threadPool[index(task.hashCode())].submit(task);
    }

    private int index(int bckt) {
        return bckt % threadCount;
    }
}
