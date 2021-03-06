package simpleapps.kafkapoc.consumer;

import com.google.common.collect.ImmutableList;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.model.CustomerEmployeeComposition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerEmployeeRecordConsumer implements MessageConsumer<CustomerEmployeeComposition> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String topicName;
    private final Properties configProperties;
    private final int pollTimeoutMs = 100;
    private final List<MessageListener> listeners = new ArrayList<>();

    private KafkaConsumer<String, CustomerEmployeeComposition> consumer;

    public CustomerEmployeeRecordConsumer(String topicName, Properties configProperties) {
        this.topicName = topicName;
        this.configProperties = configProperties;
    }

    public void addListener(MessageListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void start() {
        this.consumer = new KafkaConsumer<>(configProperties);
        this.consumer.subscribe(ImmutableList.of(topicName));

        new Thread(() -> {
            try {
                while (true) {
                    ConsumerRecords<String, CustomerEmployeeComposition> records =
                            consumer.poll(Duration.ofMillis(pollTimeoutMs));
                    for (ConsumerRecord<String, CustomerEmployeeComposition> record : records) {
                        listeners.forEach(listener -> listener.onMessage(record.value()));
                    }
                }
            } catch (WakeupException ex) {
                logger.info("Consumer thread stopped");
            } finally {
                consumer.close();
            }
        }).start();
    }

    @Override
    public void stop() {
        logger.info("Shutting down consumer...");
        consumer.wakeup();
    }
}