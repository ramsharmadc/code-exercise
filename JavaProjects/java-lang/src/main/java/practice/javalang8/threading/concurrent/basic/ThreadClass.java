package practice.javalang8.threading.concurrent.basic;

public class ThreadClass implements Runnable {

    private final Thread t;
    private final String ThreadName;

    public ThreadClass(String Name) {
        ThreadName = Name;
        t = new Thread(this, Name);
        System.out.println("Child Thread: " + t.getName());
        t.start();
        // run();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(ThreadName + "-" + i);
                // Thread.sleep(100);
            }
        } catch (Exception E) {
            System.out.println("Child Thread Interrupted.");
        }
    }
}
