package catalogue.web.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/kafkarest/producer")
public class KafkaRestController {

    @Autowired
    private LogWriter LOGGER;
    @Autowired
    private KafkaMessageProducer producer;

    @RequestMapping(method = RequestMethod.POST, value = "/simple")
    @ResponseBody
    public ResponseEntity<String> sendMsgToTopic(String message) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "sendMsgToTopic ", message);
            producer.sendMessage(message);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/greeting")
    @ResponseBody
    public ResponseEntity<String> sendMsgToTopicGreeting(Greeting message) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "sendMsgToTopicGreeting ", message);
            producer.sendGreetingMessage(message);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/partitioned")
    @ResponseBody
    public ResponseEntity<String> sendMsgToTopicPartitioned(String message, int partition) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "sendMsgToTopicPartitioned ", message);
            producer.sendMessageToPartition(message, partition);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/filtered")
    @ResponseBody
    public ResponseEntity<String> sendMsgToTopicFiltered(String message) throws Exception {
        try {
            LOGGER.log(KafkaRestController.class, "sendMsgToTopicFiltered ", message);
            producer.sendMessageToFiltered(message);
            return ResponseEntity.ok("Message Sent");
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }
}