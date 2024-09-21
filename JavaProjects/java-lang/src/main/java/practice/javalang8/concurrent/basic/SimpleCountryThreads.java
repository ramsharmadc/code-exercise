package practice.javalang8.concurrent.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCountryThreads {
    public static void main(String[] args) {
        String[] countries = {"France", "Germany", "India", "Britain"};

        /*
         * for (String s : countries) { new Greeter(s).start(); }
         */

        List<Character> result = Arrays.asList(countries).parallelStream().map(s -> {
            Greeter g = new Greeter(s);
            g.start();
            return g.name.charAt(0);
        }).toList();

        result.forEach(System.out::println);
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
