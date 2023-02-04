package catalogue.web.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaMessageProducer {

    @Autowired
    private LogWriter log;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    @Value(value = "${partitioned.topic.name}")
    private String partitionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;

    public void sendMessage(String message) {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.log(KafkaMessageProducer.class, "Sent message [" + message + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.log(KafkaMessageProducer.class, "Unable to send message [" + message + "] due to : " + ex.getMessage());
            }
        });
    }

    // sending message to a specific partition of a topic 'partitioned'
    public void sendMessageToPartition(String message, int partition) {

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(partitionedTopicName, partition, null, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.log(KafkaMessageProducer.class,
                        "Sent message [" + message + "] on partition [" + partition + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.log(KafkaMessageProducer.class, "Unable to send message [" + message + "] due to : " + ex.getMessage());
            }
        });
    }

    // sending message to topic 'filtered'
    public void  sendMessageToFiltered(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(filteredTopicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.log(KafkaMessageProducer.class, "Sent message [" + message + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.log(KafkaMessageProducer.class, "Unable to send message [" + message + "] due to : " + ex.getMessage());
            }
        });
    }

    // sending message to topic 'greeting'
    public void sendGreetingMessage(Greeting greeting) {
        ListenableFuture<SendResult<String, Greeting>> future = greetingKafkaTemplate.send(greetingTopicName, greeting);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {
            @Override
            public void onSuccess(SendResult<String, Greeting> result) {
                log.log(KafkaMessageProducer.class, "Sent message [" + greeting.toString() + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.log(KafkaMessageProducer.class, "Unable to send message [" + greeting.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
