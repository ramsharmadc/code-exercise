package dsa.problemsolving.test0921;

public class PrintNumbersUsing3Threads {

    public static void main(String[] args) {
        int c1 = 1;
        int c2 = 2;
        int c3 = 3;

        // while (true) {
        Thread t1 = new Thread(new MyTask(c1), "1T");
        Thread t2 = new Thread(new MyTask(c2), "2T");
        Thread t3 = new Thread(new MyTask(c3), "3T");
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // }


        /*
         * ThreadPoolExecutor exs = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); for (int i
         * = 0; i < 1000000; i++) { exs.submit(new MyTask(1));
         * System.out.println(exs.getQueue().size()); }
         *
         * try { System.out.println(exs.getQueue().size()); exs.awaitTermination(100,
         * TimeUnit.SECONDS); } catch (InterruptedException e) { e.printStackTrace(); }
         */
    }

    public static class MyTask implements Runnable {
        private final int count;

        public MyTask(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            System.out.print(Thread.currentThread().getName() + ":" + count + " ");
        }
    }
}
