package pl.thread;


public class ParkingManagerThread implements Runnable {
	
	private static ParkingSpaceTransaction parkingSpaceTransaction=new ParkingSpaceTransaction();
	
	public ParkingManagerThread() {
		
	}

	public void run() {
		
		
		for (int i = 0; i < 30; i++) {
			parkingSpaceTransaction.transaction();
		}

	}
}
