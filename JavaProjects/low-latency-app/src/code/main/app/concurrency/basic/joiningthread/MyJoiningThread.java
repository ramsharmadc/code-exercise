package code.main.app.concurrency.basic.joiningthread;

import java.util.Random;

public class MyJoiningThread {

  public static void main(String[] args) {
    Thread[] threads = new Thread[5];

    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new MyJoiningThread().new MyTask(), "_joining_thread_" + i + "_");
      threads[i].start();
    }

    for (int i = 0; i < threads.length; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("[" + Thread.currentThread().getName() + "] All threads finished");
  }


  class MyTask implements Runnable {

    private Random randm = new Random(System.currentTimeMillis());

    @Override
    public void run() {
      long currentTime = System.currentTimeMillis();
      System.out.println("[" + Thread.currentThread().getName() + "] activated");
      for (int i = 0; i < 2000000000; i++) {
        randm.nextInt();
      }
      System.out.println("[" + Thread.currentThread().getName() + "] finished in "
          + (System.currentTimeMillis() - currentTime) + " ms");
    }
  }
}
