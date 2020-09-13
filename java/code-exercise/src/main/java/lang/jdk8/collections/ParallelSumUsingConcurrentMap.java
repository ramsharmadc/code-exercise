package lang.jdk8.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelSumUsingConcurrentMap {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> simpleMapSum = parallelSum(new HashMap<>(), 10);
        List<Integer> concurrentMapSum = parallelSum(new ConcurrentHashMap<>(), 10);
        System.out.println(simpleMapSum.stream().mapToInt(x -> x).sum());
        System.out.println(concurrentMapSum.stream().mapToInt(x -> x).sum());
    }

    static List<Integer> parallelSum(Map<String, Integer> map, int executionTimes) throws InterruptedException {
        List<Integer> sumList = new ArrayList<>(1000);
        for (int i = 0; i < executionTimes; i++) {
            map.put("test", 0);
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                executorService.execute(() -> {
                    for (int k = 0; k < 10; k++) {
                        map.computeIfPresent("test", (key, value) -> value + 1);
                    }
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            sumList.add(map.get("test"));
        }
        return sumList;
    }
}