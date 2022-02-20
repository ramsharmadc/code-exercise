package code.main.app;

public class ConstantLoadProducer<T> implements Runnable {

    @Override
    public void run() {
        LoadQueue q = new LoadQueue();

        int i = 0;

        while (i++<10)
            q.add(new Integer(i));
    }
}
