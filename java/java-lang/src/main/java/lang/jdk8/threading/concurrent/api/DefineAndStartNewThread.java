package lang.jdk8.threading.concurrent.api;

import java.lang.Thread.State;

public class DefineAndStartNewThread {

    public static void main(String[] args) {

        RunnableTask t = new RunnableTask();
        new Thread(t).start();
        // Thread.currentThread().stop();
        ThreadTask th = new ThreadTask();
        th.start();

        long id = Thread.currentThread().getId();
        String nm = Thread.currentThread().getName();
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        State ts = Thread.currentThread().getState();

        System.out.println(id + "-" + nm + "-" + tg + "-" + ts);
    }
}


class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("I am Runnable");
    }
}


class ThreadTask extends Thread {
    @Override
    public void run() {
        System.out.println("I am a Thread");
    }
}
