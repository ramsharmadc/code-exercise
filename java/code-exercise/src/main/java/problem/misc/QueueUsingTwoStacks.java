package problem.misc;

/**
 * Keep 2 stacks, let's call them inbox and outbox. Queue: - Push the new element onto inbox Dequeue: - If
 * outbox is empty, refill it by popping each element from inbox and pushing it onto outbox - Pop and return
 * the top element from outbox Using this method, each element will be in each stack exactly once - meaning
 * each element will be pushed twice and popped twice, giving amortized constant time operations.
 */

import java.util.Stack;

public class QueueUsingTwoStacks<E> {

	private final Stack<E> inbox = new Stack<E>();
	private final Stack<E> outbox = new Stack<E>();

	public E dequeue() {

		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}

	public void queue(final E item) {

		inbox.push(item);
	}
}
