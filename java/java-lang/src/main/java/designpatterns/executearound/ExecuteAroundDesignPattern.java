package designpatterns.executearound;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ExecuteAroundDesignPattern {

    public final static Consumer<UsefulResource> resourceConsumer = (resource) -> {
        useResource(resource);
    };
    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        IntStream.range(0, 10).parallel().forEach(
                x -> resourceConsumer.accept(new SomeUsefulResource(count.incrementAndGet())));
    }

    private static void useResource(UsefulResource resource) {
        resource.open();
        resource.use();
        resource.close();
    }

    public interface UsefulResource {
        void open();

        void close();

        void use();
    }

    public static class SomeUsefulResource implements UsefulResource {

        private final int id;

        public SomeUsefulResource(int i) {
            this.id = i;
        }

        public void open() {
            System.out.println("Resource opened: " + this.id);
        }

        public void close() {
            System.out.println("Resource closed: " + this.id);
        }

        public void use() {
            System.out.println("Resource used: " + this.id);
        }
    }
}
