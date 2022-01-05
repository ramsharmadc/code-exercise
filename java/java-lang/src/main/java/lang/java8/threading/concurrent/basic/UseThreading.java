package lang.java8.threading.concurrent.basic;

public class UseThreading {

    public static void main(final String[] args) {

        final Thread t = Thread.currentThread();
        System.out.println("Current Thread: " + t);

        t.setName("Name Changed Thread.");
        System.out.println("After changing the name: " + t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                // Thread.sleep(100);
            }

        } catch (final Exception e) {
            System.out.print("Main Thread interrupted.");
        }

        new ThreadClass("First Child");
        new ThreadClass("Second Child");
        new ThreadClass("Third Child");
        new ThreadClass("Fourth Child");
    }
}
