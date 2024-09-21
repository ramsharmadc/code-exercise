package practice.javalang8;

import java.util.concurrent.atomic.AtomicBoolean;

public class SharedLock {

    public static AtomicBoolean singalFlag = new AtomicBoolean(false);

    public boolean getSignal(){
        return singalFlag.get();
    }

    public void setSignalFlag(boolean flag){
        SharedLock.singalFlag.set(flag);
    }
}
