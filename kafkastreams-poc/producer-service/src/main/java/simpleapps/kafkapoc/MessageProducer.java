package simpleapps.kafkapoc;

import io.dropwizard.lifecycle.Managed;

public interface MessageProducer<T> extends Managed {

    void send(String topicName, String key, T value);
}
