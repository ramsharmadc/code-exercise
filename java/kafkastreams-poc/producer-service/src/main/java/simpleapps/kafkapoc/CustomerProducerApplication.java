package simpleapps.kafkapoc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import simpleapps.kafkapoc.producer.CustomerProducer;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class CustomerProducerApplication extends Application<ProducerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new CustomerProducerApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<ProducerConfiguration> bootstrap) {
    }

    @Override
    public void run(final ProducerConfiguration config, final Environment environment) {

        Properties configProperties = new Properties();
        configProperties.put(CLIENT_ID_CONFIG, config.clientId);
        configProperties.put(BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers);
        configProperties.put(KEY_SERIALIZER_CLASS_CONFIG, config.keySerializer);
        configProperties.put(VALUE_SERIALIZER_CLASS_CONFIG, config.customerSer);

        MessageProducer customerProducer = new CustomerProducer(configProperties);
        environment.lifecycle().manage(customerProducer);
        environment.jersey().register(new CustomerProducerApi(customerProducer));
    }
}
