package practice.javalang8.threading.concurrent.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseExecutorService {

    public static void main(final String[] args) {

        final ExecutorService exSrvc = Executors.newSingleThreadExecutor();

        exSrvc.execute(() -> {
            int i = 0;
            while (i++ < 10) {
                System.out.println("In thread");
            }

            if (i > 10) {
                exSrvc.shutdown();
            }
        });
    }
}
