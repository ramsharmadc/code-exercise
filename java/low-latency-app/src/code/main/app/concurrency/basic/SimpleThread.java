package code.main.app.concurrency.basic;

public class SimpleThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 100;
            while (i-- > 1) {
                System.out.print('y');
            }
        });
        t.start();
        int i = 100;
        while (i-- > 1) {
            System.out.print('x');
        }
    }
}
