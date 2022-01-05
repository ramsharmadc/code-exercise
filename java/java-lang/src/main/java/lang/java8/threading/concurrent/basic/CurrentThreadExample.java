package lang.java8.threading.concurrent.basic;

import java.util.Random;
import java.util.function.Consumer;

public class CurrentThreadExample {

    public final Consumer<Integer> currentThread = s -> System.out.println(s + "-" + new Random(3).nextInt());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CurrentThreadExample currentThreadExample = new CurrentThreadExample();
            currentThreadExample.currentThread.accept(currentThreadExample.hashCode());
        }
    }
}
