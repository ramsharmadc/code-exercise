package lang.threading.concurrent.basic.useofjoin;

public class Joiner extends Thread {

	private final Sleeper sleeper;

	public Joiner(final String name, final Sleeper sleeper) {

		super(name);
		this.sleeper = sleeper;
		start();
	}

	@Override
	public void run() {

		try {
			sleeper.join();
		} catch (final InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}
