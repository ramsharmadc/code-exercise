package lang.java_8.threading.concurrent.basic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleCountryThreads {
    public static void main(String[] args) {
        String[] countries = {"France", "Germany", "India", "Britain"};

        /*
         * for (String s : countries) { new Greeter(s).start(); }
         */

        Arrays.asList(countries).parallelStream().map(s -> {
            new Greeter(s).start();
            return null;
        }).collect(Collectors.toList());
    }
}


class Greeter extends Thread {
    String name;

    public Greeter(String name) {
        super(Thread.currentThread().getId() + ": " + name + "-thread");
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello" + " " + name);
    }
}
