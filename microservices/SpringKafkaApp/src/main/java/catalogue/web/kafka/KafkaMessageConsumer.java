package catalogue.web.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class KafkaMessageConsumer {

//    public CountDownLatch latch = new CountDownLatch(3);
//    public CountDownLatch partitionLatch = new CountDownLatch(2);
//    public CountDownLatch filterLatch = new CountDownLatch(2);
//    public CountDownLatch greetingLatch = new CountDownLatch(1);

    @Autowired
    private LogWriter log;

    @KafkaListener(topics = "${message.topic.name}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        log.log(KafkaMessageConsumer.class, "Received Message in group 'foo': " + message);
        //latch.countDown();
    }

    @KafkaListener(topics = "${message.topic.name}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
    public void listenGroupBar(String message) {
        log.log(KafkaMessageConsumer.class, "Received Message in group 'bar': " + message);
        //latch.countDown();
    }

    @KafkaListener(topics = "${message.topic.name}", containerFactory = "headersKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.log(KafkaMessageConsumer.class, "Received Message: " + message + " from partition: " + partition);
        //latch.countDown();
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = {"0", "3"}), containerFactory = "partitionsKafkaListenerContainerFactory")
    public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.log(KafkaMessageConsumer.class, "Received Message: " + message + " from partition: " + partition);
        //this.partitionLatch.countDown();
    }

    @KafkaListener(topics = "${filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenWithFilter(String message) {
        log.log(KafkaMessageConsumer.class, "Received Message in filtered listener: " + message);
        //this.filterLatch.countDown();
    }

    @KafkaListener(topics = "${greeting.topic.name}", containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        log.log(KafkaMessageConsumer.class, "Received greeting message: " + greeting);
        //this.greetingLatch.countDown();
    }
}
