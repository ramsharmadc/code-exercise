package code.main.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunApp {

    public static void main(String[] args) {
      
        Thread.currentThread().setName(RunApp.class.getName());
        System.out.println("Thread-[" + Thread.currentThread() + "] started..");

        ExecutorService e = Executors.newFixedThreadPool(2);
        e.submit(new ConstantLoadProducer<Object>());
        e.submit(new ContantLoadConsumer<Object>());

        System.out.println("Thread-[" + Thread.currentThread() + "] waiting..");
        e.shutdown();
        
        try {
            System.out.println("waiting for program to terminate...");
            e.awaitTermination(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e1) {
            System.exit(0);
        }
//        ScheduledExecutorService schdlExtrSrvc = (ScheduledExecutorService) Executors.newSingleThreadExecutor();

    }
}
