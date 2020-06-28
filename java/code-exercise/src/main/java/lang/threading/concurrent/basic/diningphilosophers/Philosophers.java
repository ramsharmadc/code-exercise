package lang.threading.concurrent.basic.diningphilosophers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosophers implements Runnable {

	private final Fork leftFork;
	private final Fork rightFork;
	private final int id;
	private final int ponderFactor;
	private final Random rand = new Random(47);

	public Philosophers(final Fork left, final Fork right, final int id, final int ponder) {

		leftFork = left;
		rightFork = right;
		this.id = id;
		ponderFactor = ponder;
	}

	public void pause() throws InterruptedException {

		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {
			System.out.println(this + " thinking...");

			try {
				pause();

				System.out.println(this + " feeling hungry ...");
				System.out.println(this + " grabbing right fork ...");
				rightFork.grabTheFork();
				System.out.println(this + " acquired right fork ...");

				System.out.println(this + " grabbing left fork ...");
				leftFork.grabTheFork();
				System.out.println(this + " acquired left fork ...");

				System.out.println(this + " eating ...");
				pause();

				rightFork.dropTheFork();
				leftFork.dropTheFork();

			} catch (final InterruptedException e) {

				System.out.println(this + " interruted...");
			}
		}
	}

	@Override
	public String toString() {

		return "Philosopher-" + id;
	}

}
