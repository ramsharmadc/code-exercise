package simpleapps.kafkapoc;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ProducerConfiguration extends Configuration {

    @NotEmpty
    public String bootstrapServers;

    @NotEmpty
    public String clientId;

    @NotEmpty
    public String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";

    @NotEmpty
    public String employeeSer = "simpleapps.kafkapoc.EmployeeSerializer";

    @NotEmpty
    public String customerSer = "simpleapps.kafkapoc.CustomerSerializer";
}
