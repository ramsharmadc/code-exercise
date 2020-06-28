package lang.threading.concurrent.basic;

public class SimpleCountryThreads {
    public static void main(String[] args) {
        String[] countries = {"France", "Germany", "India", "Britain"};
        for (String s : countries) {
            new Greeter(s).start();
        }
    }
}

class Greeter extends Thread {
    String name;
    public Greeter(String name) {
        super(Thread.currentThread().getId()+": "+name + "-thread");
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello" + " " + name);
    }
}