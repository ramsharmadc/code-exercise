package lang.jdk8.threading.concurrent.basic.useofjoin;

public class Sleeper extends Thread {

	private final int duration;

	public Sleeper(final String name, final int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (final InterruptedException e) {
			System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}
