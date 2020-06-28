package code.main.app.mock.cpu;

import code.main.app.ExecutorServiceUtil;

public class CPU {

    private final int queueSize = 10;

    public boolean execute(Process process) throws InterruptedException {
//        System.out.println("Executing proess with pid - " + process.processId);
        ExecutorServiceUtil e = new ExecutorServiceUtil();
        e.submitTask(process);
//        process.run();
        return true;
    }
}
