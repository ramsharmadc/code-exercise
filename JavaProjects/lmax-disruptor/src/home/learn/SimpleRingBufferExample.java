package home.learn;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class SimpleRingBufferExample {

	public static void main(String[] args) {
		System.out.println("Simple Ring Buffer running...");

		Executor executor = Executors.newFixedThreadPool(2);
		home.learn.SimpleDisruptor simpleDisruptor = new home.learn.SimpleDisruptor();

		Disruptor<home.learn.SimpleEvent> disruptor = simpleDisruptor.createDisruptor(
				home.learn.SimpleEvent.SIMPLE_EVENT_FACTORY, 32, ProducerType.MULTI, new BlockingWaitStrategy(),
				executor);
		disruptor.handleEventsWith(new home.learn.SimpleConsumer().getEventHandler());
		disruptor.start();

		RingBuffer<SimpleEvent> ringBuffer = disruptor.getRingBuffer();

		SimplePublisher publisher = new SimplePublisher(ringBuffer);
		publisher.publishToBuffer();

		AnotherSimplePublisher anotherPublisher = new AnotherSimplePublisher(ringBuffer);
		anotherPublisher.publishToBuffer();
	}
}