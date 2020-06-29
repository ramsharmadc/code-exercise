package lang.threading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Print series 010203040506. Using multi-threading 1st thread will print only 0
 * 2nd thread will print only even numbers and 3rd thread print only odd
 * numbers.
 * 
 * @author ramsharma
 *
 */
public class ThreadSynch {

	private int st = 0;
	private static boolean flag;

	public static void main(String[] args) {

		ThreadSynch ths = new ThreadSynch();
		Thread printZero = new Thread(new ZeroThread(ths));
		Thread printOdd = new Thread(new OddThread(ths));
		Thread printEven = new Thread(new EvenThread(ths));

		// printZero.start();
		// printOdd.start();
		// printEven.start();

		ExecutorService exc = Executors.newFixedThreadPool(3);
		exc.submit(printZero);
		exc.submit(printOdd);
		exc.submit(printEven);

		exc.shutdown();
	}

	static class OddThread implements Runnable {

		private final ThreadSynch cb;

		public OddThread(ThreadSynch ths) {
			this.cb = ths;
		}

		@Override
		public void run() {
			for (int i = 1; i < 10; i = i + 2) {

				synchronized (cb) {

					while (cb.st != 1) {
						try {
							cb.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if (cb.st == 1) {
						System.out.print(i);
						// i += 2;
					}
					cb.st = 0;
					cb.notifyAll();
				}
				// cb.await();
			}
		}
	}

	static class EvenThread implements Runnable {

		private final ThreadSynch cb;

		public EvenThread(ThreadSynch ths) {
			this.cb = ths;
		}

		@Override
		public void run() {

			for (int i = 2; i < 10; i = i + 2) {

				synchronized (cb) {

					while (cb.st != 2) {
						try {
							cb.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if (cb.st == 2) {
						System.out.print(i);
						// i += 2;
					}
					cb.st = 0;
					cb.notifyAll();
				}
				// cb.await();
			}
		}
	}

	static class ZeroThread implements Runnable {

		private final ThreadSynch cb;

		public ZeroThread(ThreadSynch ths) {
			this.cb = ths;

		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {

				synchronized (cb) {

					while (cb.st != 0) {
						try {
							cb.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if (cb.st == 0) {
						System.out.print("0");
					}
					if (flag) {
						cb.st = 2;
						flag = false;
					} else {
						cb.st = 1;
						flag = true;
					}
					cb.notifyAll();
				}
			}
		}
	}
}
