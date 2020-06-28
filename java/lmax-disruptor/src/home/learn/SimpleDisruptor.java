package home.learn;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;

class SimpleDisruptor {

	public Disruptor<SimpleEvent> createDisruptor(EventFactory<SimpleEvent> eventFactory,
                                                  int bufferSize,
                                                  ProducerType single,
                                                  BlockingWaitStrategy blockingWaitStrategy,
                                                  Executor executor) 
    {
        Disruptor<SimpleEvent> simpleEventDisruptor = new Disruptor<SimpleEvent>(
                eventFactory,
                bufferSize,
                executor,
                single,
                blockingWaitStrategy);
        
        return simpleEventDisruptor;
    }
}