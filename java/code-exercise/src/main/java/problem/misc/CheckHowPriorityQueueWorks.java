package problem.misc;

import java.util.IntSummaryStatistics;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheckHowPriorityQueueWorks {

	static Queue<Integer> priorityQ = new PriorityQueue<>();

	public static void main(String[] args) {
		
		priorityQ.add(51);
		priorityQ.offer(6);
		priorityQ.add(72);
		priorityQ.add(1);
		priorityQ.add(2);
		priorityQ.offer(3);
		priorityQ.offer(4);
		priorityQ.add(11);
		priorityQ.add(19);

		System.out.print("Elements in this queue are: ");
		System.out.println(priorityQ);

		// printing size of the queue
		System.out.println("Size of this queue is: " + priorityQ.size());
		

		IntSummaryStatistics summaryStats = priorityQ.stream().mapToInt(n -> n).summaryStatistics();
		System.out.println("\n" + summaryStats);

		// removing values based on priority and printing them
		System.out.print("Priority Queue: ");
		while (!priorityQ.isEmpty()) {
			System.out.print(priorityQ.remove() + " " + "");
		}

	}
}
