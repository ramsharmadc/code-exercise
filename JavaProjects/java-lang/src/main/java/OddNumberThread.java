public class OddNumberThread implements Runnable{

    private int addCtr = 1;
    private SharedLock sharedLock;

    public OddNumberThread(SharedLock sharedLock) {
        this.sharedLock =sharedLock;
    }

    public void run(){

        while(true) {
            if (sharedLock.getSignal() == true) {
                System.out.println(Thread.currentThread().getName() + ":: " + addCtr);
                addCtr += 2;
                sharedLock.setSignalFlag(false);
            }
        }

        /*synchronized (sharedLock) {
            //while(addCtr < 100) {
                if (!sharedLock.singalFlag.get()) {
                    try {
                        sharedLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":: " + addCtr);
                    addCtr += 2;
                    sharedLock.setSignalFlag(false);
                    sharedLock.notify();
                }
            //}
        }*/
    }
}
