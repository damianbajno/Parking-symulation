package pl.thread;

import pl.constantsandstrings.Names_EN;

public class ParkingManagerThread implements Runnable {

	private static ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction();
	private Integer threadNumber=0;
	
	public ParkingManagerThread() {
			System.out.println(threadNumber);
	}

	public void run() {
		synchronized (threadNumber) {
			threadNumber++;
			parkingSpaceTransaction.printTransactionStartOnBoard(threadNumber);
		}
		for (int i = 0; i < 50; i++) {
			parkingSpaceTransaction.transaction();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.err.println(Names_EN.PARKINGMANAGERTHREAD_GetInterupted);
				e.printStackTrace();
			}
		}
	}
}
