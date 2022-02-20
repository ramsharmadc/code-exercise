package code.main.app.concurrency.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    private static final List<Future<Integer>> futureTasks = new LinkedList<>();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                Callable<Integer> callableTask = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return finalI + 1;
                    }
                };
                futureTasks.add(executorService.submit(callableTask));
            }

            for (Future<Integer> f : futureTasks) {
                System.out.println("waiting for future result....");
                try {
                    System.out.println(f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println("closing executor service..");
            executorService.shutdown();
        }
    }
}
