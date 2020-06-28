package lang.threading.concurrent.basic.diningphilosophers;

public class Fork {

	private boolean free;

	public synchronized void dropTheFork() throws InterruptedException {

		setFree();
	}

	public void forkInUse() {

		free = false;
	}

	public synchronized void grabTheFork() throws InterruptedException {

		while (!isFree()) {
			wait();
		}
		forkInUse();
	}

	public boolean isFree() {

		return free;
	}

	public void setFree() {

		free = true;
	}
}
