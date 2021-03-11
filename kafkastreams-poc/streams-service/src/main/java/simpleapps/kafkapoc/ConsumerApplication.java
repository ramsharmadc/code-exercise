package simpleapps.kafkapoc;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.consumer.ConsumerConfiguration;
import simpleapps.kafkapoc.consumer.CustomerEmployeeRecordConsumer;
import simpleapps.kafkapoc.consumer.MessageConsumer;

import java.util.Properties;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

public class ConsumerApplication extends Application<ConsumerConfiguration> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(final String[] args) throws Exception {
        new ConsumerApplication().run(args);
    }

    @Override
    public void run(final ConsumerConfiguration config, final Environment environment) {
        Properties configProperties = new Properties();
        configProperties.put(CLIENT_ID_CONFIG, config.clientId);
        configProperties.put(GROUP_ID_CONFIG, config.groupId);
        configProperties.put(BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers);
        configProperties.put(KEY_DESERIALIZER_CLASS_CONFIG, config.keyDeserializer);
        configProperties.put(VALUE_DESERIALIZER_CLASS_CONFIG, config.valueDeserializer);

        MessageConsumer messageConsumer = new CustomerEmployeeRecordConsumer(
                "topic-customer-employee", configProperties);
        messageConsumer.addListener(message -> logger.info("message received : {} ", message));
        environment.lifecycle().manage(messageConsumer);
    }
}
