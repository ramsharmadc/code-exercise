package simpleapps.kafkapoc.consumer;

import io.dropwizard.lifecycle.Managed;

public interface MessageConsumer<T> extends Managed {

    void addListener(MessageListener listener);

    interface MessageListener<T> {

        void onMessage(T message);

    }
}
