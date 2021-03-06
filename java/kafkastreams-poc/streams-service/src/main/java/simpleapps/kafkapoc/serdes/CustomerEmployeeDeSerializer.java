package simpleapps.kafkapoc.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import simpleapps.kafkapoc.model.CustomerEmployeeComposition;

import java.util.Map;

public class CustomerEmployeeDeSerializer implements Deserializer<CustomerEmployeeComposition> {

    private JsonDeSerializer<CustomerEmployeeComposition> jsonDeSerializer =
            new JsonDeSerializer<CustomerEmployeeComposition>(CustomerEmployeeComposition.class);

    @Override
    public void configure(Map var1, boolean var2) {

    }

    @Override
    public CustomerEmployeeComposition deserialize(String var1, byte[] var2) {
        ObjectMapper mapper = new ObjectMapper();
        CustomerEmployeeComposition user = null;
        try {
            user = mapper.readValue(var2, CustomerEmployeeComposition.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void close() {

    }
}
