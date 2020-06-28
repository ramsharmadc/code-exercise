package lang.threading.concurrent.basic;

import java.util.concurrent.TimeUnit;

public class StopThread {

	private static boolean stopRequested;

	public static void main(final String[] args) throws InterruptedException {
		
		final Thread backgroundThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while (!stopRequested()) {
					System.out.println(i); // the last stop point is always
											// different
					i++;
				}
			}
		});

		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		// stopRequested = true;
		requestStop();
	}

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}
}
