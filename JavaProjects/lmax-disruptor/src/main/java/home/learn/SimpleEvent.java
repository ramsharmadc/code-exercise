package home.learn;

import com.lmax.disruptor.EventFactory;

public class SimpleEvent {

	public static final EventFactory<SimpleEvent> SIMPLE_EVENT_FACTORY = 
			new EventFactory<SimpleEvent>() {
		
		int ctr = 0;

		@Override
		public SimpleEvent newInstance() {
			System.out.println("Simple Event created using factory. Event# " + (++ctr));
			return new SimpleEvent();
		}
	};

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
