package practice.javalang8;

public class EvenNumberThread implements Runnable {
    private int evenCtr = 2;
    private SharedLock sharedLock;

    public EvenNumberThread(SharedLock sharedLock) {
        this.sharedLock = sharedLock;
    }

    public void run() {
        // synchronized (sharedLock) {
        while (evenCtr < 101) {
            if (sharedLock.getSignal() == false) {
                System.out.println(Thread.currentThread().getName() + ":: " + evenCtr);
                evenCtr += 2;
                sharedLock.setSignalFlag(true);
            }
        }
        // while (evenCtr < 100) {
        // if (sharedLock.singalFlag.get()) {
        /*
         * try {
         * sharedLock.wait();
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         */
        // } else {
        /*
         * try {
         * Thread.sleep(100);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * System.out.println(Thread.currentThread().getName() + ":: " + evenCtr);
         * evenCtr += 2;
         * sharedLock.setSignalFlag(true);
         * sharedLock.notify();
         */

        // }
        // }
        // }
    }
}
