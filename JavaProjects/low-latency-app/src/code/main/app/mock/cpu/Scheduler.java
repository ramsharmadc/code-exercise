package code.main.app.mock.cpu;

import java.util.HashMap;
import java.util.Map;

public final class Scheduler {

    public final static Scheduler instance = new Scheduler();
    private final CPU cpu = new CPU();
    private final Map<Long, Process> pollingQueue = new HashMap<>();

    public void schedule(Process proc) throws InterruptedException {
        System.out.println("Scheduling Process. pid - " + proc.processId + "]");

        pollingQueue.put(proc.processId, proc);

        System.out.println("Waiting...");
        //        Thread.currentThread().wait(100);
        cpu.execute(proc);
    }

    public void start() {

    }
}
