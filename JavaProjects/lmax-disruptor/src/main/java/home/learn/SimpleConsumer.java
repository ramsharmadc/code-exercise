package home.learn;

import com.lmax.disruptor.EventHandler;

public class SimpleConsumer {

	@SuppressWarnings("unchecked")
	public EventHandler<SimpleEvent>[] getEventHandler() {

		EventHandler<SimpleEvent> simpleEventEventHandler = (event, sequence, endOfBatch) -> {
			System.out.println("CONSUME [Event: " + event.getValue() + " | Sequence Id: " + sequence + "]");
		};

		return new EventHandler[] { simpleEventEventHandler };
	}
}