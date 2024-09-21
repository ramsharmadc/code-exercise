package code.main.app.mock.cpu;

import code.main.app.ExecutorServiceUtil;

public class CPU {

    ExecutorServiceUtil e = new ExecutorServiceUtil();

    public boolean execute(Process process) throws InterruptedException {
//        System.out.println("Executing proess with pid - " + process.processId);
        
        e.submitTask(process);
//        process.run();
        return true;
    }
}
