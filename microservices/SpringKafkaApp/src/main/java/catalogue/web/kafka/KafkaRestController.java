package catalogue.web.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/kafkarest/gen")
public class KafkaRestController {

    @Autowired
    private LogWriter LOGGER;
    @Autowired
    private KafkaMessageProducer producer;

    @RequestMapping(method = RequestMethod.POST, value = "/baeldung")
    @ResponseBody
    public ResponseEntity<String> sendMessage(String message) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "Sending message {0}", message);
            producer.sendMessage(message);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/greeting")
    @ResponseBody
    public ResponseEntity<String> sendMessage(Greeting message) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "Sending message {0}", message);
            producer.sendGreetingMessage(message);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }
}