package lang.java_8.threading.concurrent.basic;

import java.util.concurrent.TimeUnit;

public class BartenderProblem {

    public static void main(String[] args) throws InterruptedException {
        Bartender bartender = new Bartender();
        Thread bartenderThread = new Thread(bartender, "Bartender-007");

        bartenderThread.start();

        TimeUnit.SECONDS.sleep(1);

        int customers = 5;

        for (int i = 0; i < customers; i++) {
            Customer customer = new Customer(bartenderThread, 1, bartenderThread.getName());
            Thread customerThread = new Thread(customer, "Customer-" + (i + 1));
            customerThread.start();
        }
    }
}


class Bartender implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                System.out.println("Thread:" + Thread.currentThread().getName() + " "
                        + "Bartender: zzz... errrr.. is something waiting?");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


class Customer implements Runnable {

    Thread bartender;
    long wait_time;
    String name;

    public Customer(Thread bartender, long wait_time, String name) {
        this.bartender = bartender;
        this.wait_time = wait_time;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName() + " "
                + "Is anyone here. Waiting for " + wait_time + " second");
        try {
            TimeUnit.SECONDS.sleep(wait_time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + " " + "Pressing bell..");
        bartender.interrupt();
    }
}
