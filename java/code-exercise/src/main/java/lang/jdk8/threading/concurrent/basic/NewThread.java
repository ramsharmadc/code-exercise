package lang.jdk8.threading.concurrent.basic;

public class NewThread implements Runnable {

	private static int taskCount = 0;
	private final int id = taskCount++;
	protected int countDown = 10; // Default

	public NewThread() {
	}

	public NewThread(final int countDown) {
		this.countDown = countDown;
	}

	public static void main(final String[] args) {
		final NewThread newThread = new NewThread(15);
		newThread.run();
		final Thread t = new Thread(new NewThread(15));
		t.start(); // a new thread started
		// but the current thread i.e. main is still working. so it will print
		// the nxt line
		System.out.println("I am the main thread ---");
	}

	@Override
	public void run() {
		System.out.println("Just entered in new thread's run() ---");
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
}
