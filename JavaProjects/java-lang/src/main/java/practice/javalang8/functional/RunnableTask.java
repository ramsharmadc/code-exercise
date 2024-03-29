package practice.javalang8.functional;

import java.util.concurrent.TimeUnit;

public class RunnableTask {

    public static void main(String[] args) {
        Runnable r = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        r.run();

        Thread t = new Thread(r);
        t.start();
    }
}
