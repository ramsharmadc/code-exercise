package simpleapps.kafkapoc.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.Employee;
import simpleapps.kafkapoc.MessageProducer;

import java.util.Properties;

public class EmployeeProducer implements MessageProducer<Employee> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Properties configProperties;

    private Producer<String, Employee> producer;

    public EmployeeProducer(Properties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public void start() {
        this.producer = new KafkaProducer<>(configProperties);
    }

    @Override
    public void send(String topicName, String key, Employee value) {

        ProducerRecord<String, Employee> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                logger.info("Employee data [{}]:[{}] successfully sent", key, value.toString());
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
