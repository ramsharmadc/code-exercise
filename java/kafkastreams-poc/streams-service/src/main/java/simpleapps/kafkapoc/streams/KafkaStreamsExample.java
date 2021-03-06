package simpleapps.kafkapoc.streams;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.model.Customer;
import simpleapps.kafkapoc.model.CustomerEmployeeComposition;
import simpleapps.kafkapoc.model.Employee;
import simpleapps.kafkapoc.serdes.CustomizedSerDesFactory;

import java.util.Properties;

public class KafkaStreamsExample {
    private static final Logger logger = LoggerFactory.getLogger(KafkaStreamsExample.class);

    public void consume() {
        final KafkaStreams streams = getOutputStream();
        streams.cleanUp();
        streams.start();

        // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    public static KafkaStreams getOutputStream() {

        final Properties streamsConfiguration = new Properties();

        // Give the Streams application a unique name.
        // The name must be unique in the Kafka cluster against which the application is run.
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "global-tables-example");
        streamsConfiguration.put(StreamsConfig.CLIENT_ID_CONFIG, "global-tables-example-client");

        // Where to find Kafka broker(s).
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        streamsConfiguration.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams-global-tables");

        // Set to earliest so we don't miss any data that arrived in the topics before the process
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        streamsConfiguration.put("default.deserialization.exception.handler", LogAndContinueExceptionHandler.class);

        final StreamsBuilder builder = new StreamsBuilder();

        final KStream<String, Employee> employeeStream = builder.
                stream("my-topic", Consumed.with(Serdes.String(), CustomizedSerDesFactory.employeeSerde()));

        final GlobalKTable<String, Customer>
                customers = builder.globalTable("topic-customer",
                Materialized.<String, Customer, KeyValueStore<Bytes, byte[]>>as("customer-db-storage")
                        .withKeySerde(Serdes.String())
                        .withValueSerde(CustomizedSerDesFactory.customerSerde()));

        final KStream<String, CustomerEmployeeComposition> customerOrdersStream = employeeStream.join(customers,
                new KeyValueMapper<String, Employee, String>() {
                    @Override
                    public String apply(String orderId, Employee employee) {
                        logger.info("Joining records [{}] on [{}]", employee, orderId);
                        return String.valueOf(orderId);
                    }
                },
                new ValueJoiner<Employee, Customer, CustomerEmployeeComposition>() {
                    @Override
                    public CustomerEmployeeComposition apply(Employee emp, Customer customer) {
                        CustomerEmployeeComposition customerEmployeeComposition =
                                new CustomerEmployeeComposition(
                                        customer.getId(), customer.getName(), emp.getId(), emp.getName());
                        logger.info("Created result: [{}]", customerEmployeeComposition);
                        return customerEmployeeComposition;
                    }
                });

        employeeStream.foreach((x, Y) -> System.out.println("employeeStream: " + Y.toString()));

//         write the enriched order to the enriched-order topic
        customerOrdersStream.to("topic-customer-employee",
                Produced.with(Serdes.String(), CustomizedSerDesFactory.customerEmployeeCompositionSerde()));

        return new KafkaStreams(builder.build(), streamsConfiguration);
    }
}
