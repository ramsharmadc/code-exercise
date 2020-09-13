package lang.jdk8.threading.concurrent.api;

public class ThreadSleep {

	public static void main(String[] args) {

		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {

			// Pause for 2 seconds
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread Interrupted");
			}

			System.out.println(importantInfo[i]);
		}
	}
}
