package lang.java8.threading.concurrent.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class UseStampedLock {

    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    static StampedLock sl = new StampedLock();
    static Map<Long, Boolean> repeatedStamps = new HashMap<>();

    public static void main(String[] args) {

        IntStream.range(1, 10000).parallel()
                .forEach(x -> executorService.submit(UseStampedLock::getLock));

        executorService.shutdown();
    }

    static void getLock() {
        long l = sl.readLock();

        if (l == 0) {
            System.out.println("lock not acquired");
        }

        if (sl.isReadLocked()) {
            if (repeatedStamps.getOrDefault(l, false))
                System.out.println("stamp repeated:" + l);
            repeatedStamps.put(l, true);
            System.out.println("acquired Lock[stamp:" + l + "]");
        }

        try {
            sl.unlock(l);
        } catch (Exception e) {
            System.out.println("Exception while unlocking");
        } finally {
            System.out.println("releases Lock[stamp:" + l + "]");
        }
    }
}
