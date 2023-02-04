package catalogue.web;

import catalogue.web.kafka.KafkaProducerTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"catalogue"})
public class KafkaApplication {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        KafkaProducerTest kafkaProducerTest = context.getBean(KafkaProducerTest.class);
        kafkaProducerTest.test();

         context.close();

        //SpringApplication.run(KafkaApplication.class, args);
    }
}
