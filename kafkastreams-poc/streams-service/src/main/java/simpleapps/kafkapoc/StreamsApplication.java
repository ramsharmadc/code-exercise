package simpleapps.kafkapoc;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simpleapps.kafkapoc.consumer.ConsumerConfiguration;
import simpleapps.kafkapoc.streams.KafkaStreamsExample;

public class StreamsApplication extends Application<ConsumerConfiguration> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(final String[] args) throws Exception {
        new StreamsApplication().run(args);
    }

    @Override
    public void run(final ConsumerConfiguration config, final Environment environment) {
        new KafkaStreamsExample().consume();
    }
}
