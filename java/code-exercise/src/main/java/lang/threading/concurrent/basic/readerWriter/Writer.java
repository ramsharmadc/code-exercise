package lang.threading.concurrent.basic.readerWriter;

public class Writer {

    public static void main(final String[] args) {

        System.out.println("Thread: " + Thread.currentThread().getThreadGroup() + "" +
                Thread.currentThread().getName());

        Thread t = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getThreadGroup() + "" +
                    Thread.currentThread().getName());

        });

        t.start();
    }
}
