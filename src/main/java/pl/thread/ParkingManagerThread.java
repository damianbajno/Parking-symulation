package pl.thread;

import pl.constantsandstrings.Names_EN;

public class ParkingManagerThread implements Runnable {
	
	ParkingSpaceTransaction parkingSpaceTransaction=new ParkingSpaceTransaction();
	
	public ParkingManagerThread() {
		
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			parkingSpaceTransaction.transaction();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(Names_EN.ParkingManager_WATEK_INTERAPTED);
				e.printStackTrace();
			}
		}

	}
}
