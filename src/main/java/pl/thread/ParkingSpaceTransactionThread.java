package pl.thread;

import pl.constantsandstrings.Names_EN;

public class ParkingSpaceTransactionThread implements Runnable {

	private static ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction();
	private Integer threadNumber = 0;

	public ParkingSpaceTransactionThread() {
		System.out.println(threadNumber);
		threadAwait(1000);
	}

	public void run() {
		synchronized (threadNumber) {
			threadNumber++;
			parkingSpaceTransaction.printTransactionStartOnBoard(threadNumber);
		}
		for (int i = 0; i < 10; i++) {
			parkingSpaceTransaction.transaction();
			threadAwait(2000);
		}
	}

	private void threadAwait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.err.println(Names_EN.PARKINGMANAGERTHREAD_GetInterupted);
			e.printStackTrace();
		}
	}

}
