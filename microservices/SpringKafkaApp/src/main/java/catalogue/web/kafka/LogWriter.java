package catalogue.web.kafka;

import catalogue.web.KafkaApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogWriter {

    private final Logger log = LogManager.getLogger(KafkaApplication.class);

    public void log(Class<?> clazz, String message, Object... args) {
        StringBuilder stringBuilder = new StringBuilder("<" + clazz.getName() + "> ");
        stringBuilder.append(message+"; ");
        for (Object o : args) {
            stringBuilder.append(o.toString()+", ");
        }
    }

    public void log(Class<?> clazz, String message) {
        log.info("<" + clazz.getName() + "> " + message);
    }
}
