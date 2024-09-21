package practice.javalang8.javalang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChildClassOfImmutable extends OneImmutableClass {

    public static void main(String[] args) {
        new ChildClassOfImmutable().startThreads();
    }

    public void mutateParent() {
        this.getCreatedOn().setYear(2013);
    }

    public void startThreads() {
        ExecutorService[] fastThreads = new ExecutorService[10];

        for (int i = 0; i < 10; i++) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            fastThreads[i] = executorService;
        }

        for (int i = 0; i < 1000; i++) {
            ExecutorService executorService = getExecutorService(fastThreads, i);
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running task in thread -> " + Thread.currentThread());
                }
            });
        }

        for (int i = 0; i < 1000; i++) {
            ExecutorService executorService = getExecutorService(fastThreads, i);
            executorService.shutdown();
        }
    }

    public ExecutorService getExecutorService(ExecutorService[] fastThreads, int i) {
        int n = i % 10;
        ExecutorService executorService = fastThreads[n];
        return executorService;
    }
}
