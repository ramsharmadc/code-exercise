package practice.javalang8.chroniclemap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

public class UseChronicleQueue {
    public static void main(String[] args) {
        
        try (ChronicleQueue queue = SingleChronicleQueueBuilder.single("queue-dir").build()) {
        
            // Obtain an ExcerptAppender
            ExcerptAppender appender = queue.acquireAppender();

            // Writes: {msg: TestMessage}
            appender.writeDocument(w -> w.write("msg").text("TestMessage"));

            // Writes: TestMessage
            appender.writeText("TestMessage");

            ExcerptTailer tailer = queue.createTailer();

            tailer.readDocument(w -> System.out.println("msg: " + w.read(() -> "msg").text()));

            assertEquals("TestMessage", tailer.readText());
        }
    }

}
