package code.main.app.os.examples;

public class Driver {

  public static void main(String[] args) throws InterruptedException {

    final int limit = 1000000;

    Sum sumObject = new Sum();
    Thread thrd = new Thread(new Summation(limit, sumObject));
    thrd.start();

    Sum sumObject2 = new Sum();
    Thread thrd2 = new Thread(new Summation(limit, sumObject2));
    thrd2.start();

    System.out.format("{%s} waiting for child threads, [%s, %s] to die\n",
        Thread.currentThread().getName(), thrd.getName(), thrd2.getName());

    // Main thread will stop running till "thread(s)", on which the main thread is joining, dies
    // join is called on the running thread and it makes the main thread join on the same

    thrd.join();
    // thrd2.join();

    System.out.format("{%s} done waiting for child thread{%s}\n", Thread.currentThread().getName(),
        thrd.getName());
    System.out.format("The sum of {%d} numbers is {%d}\n", limit, sumObject.getSum());
    System.out.format("The sum of {%d} numbers is {%d}\n", limit, sumObject2.getSum());


  }
}
