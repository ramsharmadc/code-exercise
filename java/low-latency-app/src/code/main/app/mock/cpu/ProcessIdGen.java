package code.main.app.mock.cpu;

import java.util.concurrent.atomic.AtomicLong;

public final class ProcessIdGen {

    public final static ProcessIdGen instance = new ProcessIdGen();

    private static AtomicLong id = new AtomicLong(0);

    public long getUniqueId() {
        return id.incrementAndGet();
    }
}
