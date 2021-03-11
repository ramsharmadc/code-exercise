package simpleapps.kafkapoc.serdes;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import simpleapps.kafkapoc.model.Employee;
import simpleapps.kafkapoc.model.Customer;
import simpleapps.kafkapoc.model.CustomerEmployeeComposition;

public final class CustomizedSerDesFactory {

    static public final class EmployeeSerde
            extends Serdes.WrapperSerde<Employee> {
        public EmployeeSerde() {
            super(new JsonSerializer<>(),
                    new JsonDeSerializer<Employee>(Employee.class));
        }
    }

    static public final class CustomerSerde
            extends Serdes.WrapperSerde<Customer> {
        public CustomerSerde() {
            super(new JsonSerializer<>(),
                    new JsonDeSerializer<Customer>(Customer.class));
        }
    }


    static public final class CustomerEmployeeSerdes
            extends Serdes.WrapperSerde<CustomerEmployeeComposition> {
        public CustomerEmployeeSerdes() {
            super(new JsonSerializer<>(),
                    new JsonDeSerializer<CustomerEmployeeComposition>(CustomerEmployeeComposition.class));
        }
    }

    public static Serde<Employee> employeeSerde() {
        return new CustomizedSerDesFactory.EmployeeSerde();
    }

    public static Serde<Customer> customerSerde() {
        return new CustomizedSerDesFactory.CustomerSerde();
    }

    public static Serde<CustomerEmployeeComposition> customerEmployeeCompositionSerde() {
        return new CustomizedSerDesFactory.CustomerEmployeeSerdes();
    }
}
