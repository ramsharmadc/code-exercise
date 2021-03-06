package simpleapps.kafkapoc.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.Customer;
import simpleapps.kafkapoc.MessageProducer;

import java.util.Properties;

public class CustomerProducer implements MessageProducer<Customer> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Properties configProperties;

    private Producer<String, Customer> producer;

    public CustomerProducer(Properties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public void start() {
        this.producer = new KafkaProducer<>(configProperties);
    }

    @Override
    public void send(String topicName, String key, Customer value) {

        ProducerRecord<String, Customer> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                logger.info("Customer data [{}]:[{}] successfully sent", key, value);
            } else {
                logger.warn("Unable to send message with key [{}]: {}", key, exception.getMessage());
            }
        });
    }

    @Override
    public void stop() {
        this.producer.close();
    }

}
