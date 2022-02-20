package home.learn;

import com.lmax.disruptor.RingBuffer;

class AnotherSimplePublisher {
    private RingBuffer<home.learn.SimpleEvent> ringBuffer;

    public AnotherSimplePublisher(RingBuffer<home.learn.SimpleEvent> simpleEventRingBuffer) {
        this.ringBuffer = simpleEventRingBuffer;
    }

    public void publishToBuffer() {
        for (int eventCount = 1; eventCount < 40; eventCount++) {
            long sequenceId = ringBuffer.next();
            home.learn.SimpleEvent simpleEvent = ringBuffer.get(sequenceId);

            System.out.println("AnotherSimpleEventPublisher - PUBLISH [Event: " + eventCount
                    + " at Sequence: "
                    + sequenceId + " oldEvent: " + simpleEvent.getValue() + "]");

            simpleEvent.setValue(eventCount);
            ringBuffer.publish(sequenceId);
        }
    }
}