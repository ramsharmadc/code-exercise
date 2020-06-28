package lang.threading.concurrent.basic.InterThreadComm;

class Consumer implements Runnable {
	SharedQueue sharedQueue;

	Consumer(SharedQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		while (true) {
			sharedQueue.get();
		}
	}
}

class ProducerConsumerFixed {
	public static void main(String args[]) {
		SharedQueue sharedQueue = new SharedQueue();
		new Producer(sharedQueue);
		new Consumer(sharedQueue);
		System.out.println("Press Control-C to stop.");
	}
}

class Producer implements Runnable {

	SharedQueue sharedQueue;

	Producer(SharedQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			sharedQueue.put(i++);
		}
	}
}

// A correct implementation of a producer and consumer.
class SharedQueue {
	int n;
	int waitFlag = 0;
	int maxRun = 2000000000;

	synchronized int get() {
		if (waitFlag == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}
		System.out.println("Get-" + n);
		waitFlag = 0;
		notifyAll();
		return n;
	}

	synchronized void put(int n) {
		if (this.n < maxRun) {
			if (waitFlag == 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("InterruptedException caught");
				}
			}
			this.n = n;
			waitFlag = 1;
			System.out.println("Put-" + n);
			notifyAll();
		}
	}
}
