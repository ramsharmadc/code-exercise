package simpleapps.kafkapoc.consumer;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ConsumerConfiguration extends Configuration {

    @NotEmpty
    public String bootstrapServers;

    @NotEmpty
    public String clientId;

    @NotEmpty
    public String groupId = "my-consumer";

    @NotEmpty
    public String topicName = "my-topic";

    @NotEmpty
    public String keyDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";

    @NotEmpty
    public String valueDeserializer = "simpleapps.kafkapoc.serdes.CustomerEmployeeDeSerializer";

}
