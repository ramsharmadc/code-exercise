package simpleapps.kafkapoc.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import simpleapps.kafkapoc.model.Employee;

import java.util.Map;

public class EmployeeDeSerializer<T> implements Deserializer<Employee> {
    @Override
    public void configure(Map var1, boolean var2) {

    }

    @Override
    public Employee deserialize(String var1, byte[] var2) {
        ObjectMapper mapper = new ObjectMapper();
        Employee user = null;
        try {
            user = mapper.readValue(var2, Employee.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void close() {

    }
}
