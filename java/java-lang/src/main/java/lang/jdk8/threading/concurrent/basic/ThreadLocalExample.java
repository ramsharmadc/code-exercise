package lang.jdk8.threading.concurrent.basic;

public class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private final int value;

    public ThreadLocalExample(int val) {
        this.value = val;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadLocalExample(i), "_thread_local_" + i);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        threadLocal.set(value);
        Integer intVal = threadLocal.get();
        System.out.println("[" + Thread.currentThread().getName() + "]: " + intVal);
    }

}
