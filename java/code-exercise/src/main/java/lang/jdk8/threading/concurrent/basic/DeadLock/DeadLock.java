package lang.jdk8.threading.concurrent.basic.DeadLock;

// An example of deadlock.
class A {
    synchronized void foo(final B b) {
        final String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");
        try {
            Thread.sleep(1);
        } catch (final Exception e) {
            System.out.println("A Interrupted");
        }
        System.out.println(name + " trying to call B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}


class B {
    synchronized void bar(final A a) {
        final String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");
        try {
            Thread.sleep(1);
        } catch (final Exception e) {
            System.out.println("B Interrupted");
        }
        System.out.println(name + " trying to call A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}


public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    DeadLock() {
        Thread.currentThread().setName("MainThread");
        final Thread t = new Thread(this, "RacingThread");
        t.start();
        a.foo(b); // get lock on a in this thread.
        System.out.println("Back in main thread");
    }

    public static void main(final String[] args) {
        new DeadLock();
    }

    @Override
    public void run() {

        b.bar(a); // get lock on b in other thread.
        System.out.println("Back in other thread");
    }
}
