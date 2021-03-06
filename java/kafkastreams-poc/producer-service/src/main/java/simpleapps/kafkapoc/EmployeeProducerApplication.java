package simpleapps.kafkapoc;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import simpleapps.kafkapoc.producer.EmployeeProducer;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class EmployeeProducerApplication extends Application<ProducerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmployeeProducerApplication().run(args);
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
        configProperties.put(VALUE_SERIALIZER_CLASS_CONFIG, config.employeeSer);

        MessageProducer employeeProducer = new EmployeeProducer(configProperties);
        environment.lifecycle().manage(employeeProducer);
        environment.jersey().register(new EmployeeProducerApi(employeeProducer));
    }
}
