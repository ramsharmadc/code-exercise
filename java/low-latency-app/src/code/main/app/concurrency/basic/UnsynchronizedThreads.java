package code.main.app.concurrency.basic;

public class UnsynchronizedThreads {

  public static void main(String[] args) {
    Thread[] threads = new Thread[2];

    // Running unsynchronized counter
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new UnSynchronizedCounter(), "_counter_thread_" + i + "_");
      threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Running unsynchronized counter
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new SynchronizedCounter(), "_counter_thread_" + i + "_");
      threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class UnSynchronizedCounter implements Runnable {

    private static int i = 0;

    @Override
    public void run() {
      while (i < 10) {
        System.out.println("[" + Thread.currentThread().getName() + "] before: " + i);
        i++;
        System.out.println("[" + Thread.currentThread().getName() + "] before: " + i);
      }
    }
  }

  static class SynchronizedCounter implements Runnable {

    private static int i = 0;

    @Override
    public void run() {
      while (i < 10) {
        synchronized (UnsynchronizedThreads.class) {
          System.out.println("[" + Thread.currentThread().getName() + "] before: " + i);
          i++;
          System.out.println("[" + Thread.currentThread().getName() + "] before: " + i);
        }
      }
    }
  }

}
