package home.learn;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.lmax.disruptor.RingBuffer;

class SimplePublisher {

	private RingBuffer<SimpleEvent> ringBuffer;

	private static final Queue<SimpleEvent> Q = new LinkedBlockingQueue<>();

	public SimplePublisher(RingBuffer<SimpleEvent> simpleEventRingBuffer) {
		this.ringBuffer = simpleEventRingBuffer;
	}

	public void publishToBuffer() {

		for (int eventCount = 1; eventCount < 10; eventCount++) {

			long sequenceId = ringBuffer.next();
			SimpleEvent simpleEvent = ringBuffer.get(sequenceId);

			System.out.println("SimpleEventPublisher - PUBLISH [Event: " + eventCount + " at Sequence: " + sequenceId
					+ " oldEvent: " + simpleEvent.getValue() + "]");

			simpleEvent.setValue(eventCount);

			if (ringBuffer.hasAvailableCapacity(10)) {
				Q.add(simpleEvent);
			} else {
				ringBuffer.publish(sequenceId);
			}
		}
	}

	private void handleLoad() {
		for (SimpleEvent e : Q) {
			publishToBuffer();
		}
	}
}