package code.main.app.mock.cpu;

import java.io.File;

public abstract class Process implements Runnable {
    long processId;
    ProcState state;
    long timeSlices;
    Process parent;
    Process[] children;
    File[] openFiles;
    long addressSpace;

    enum ProcState {
        READY(0, "READY"),
        RUNNING(1, "RUNING"),
        WAITING(2, "WAITING"),
        NEW(3, "NEW"),
        TERMINATED(4, "TERMINATED");

        
        private String stateDesc;
        private int stateVal;

        ProcState(int i, String state) {
            this.stateDesc = state;
            this.stateVal = i;
        }

        public String getState() {
            return stateDesc +":"+stateVal;
        }
    }

}
