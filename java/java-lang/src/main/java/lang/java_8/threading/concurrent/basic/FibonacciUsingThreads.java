package lang.java_8.threading.concurrent.basic;

public class FibonacciUsingThreads implements Runnable {

    int n;

    public FibonacciUsingThreads() {
        n = 10;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        FibonacciUsingThreads fbTh = new FibonacciUsingThreads();
        for (int i = 0; i < 5; i++) {
            new Thread(fbTh).start();
        }
        // System.out.println("Program finished...");
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Starting....");
            // System.out.println(new FibonacciUsingThreads().fibRec(n));
            System.out.println("Ending....");
        }
    }
}
