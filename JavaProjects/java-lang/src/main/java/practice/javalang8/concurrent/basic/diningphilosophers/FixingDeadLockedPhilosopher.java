package practice.javalang8.concurrent.basic.diningphilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixingDeadLockedPhilosopher {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {

        final int ponder = 5;
        final int SIZE = 5;

        final ExecutorService exec = Executors.newCachedThreadPool();

        final Fork[] forks = new Fork[SIZE];

        for (int i = 0; i < SIZE; i++) {
            forks[i] = new Fork();
        }

        for (int j = 0; j < SIZE; j++) {
            if (j < (SIZE - 1)) {
                exec.execute(new Philosophers(forks[j], forks[((j + 1) % SIZE)], j, ponder));
            } else {
                exec.execute(new Philosophers(forks[j - 1], forks[j], j, ponder));
            }
        }

        TimeUnit.MILLISECONDS.sleep(SIZE);
        exec.shutdownNow();
    }
}
