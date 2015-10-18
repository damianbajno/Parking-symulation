package pl.thread;

import pl.constantsandstrings.Names_PL;
import pl.panels.ParkingTextBoard;

public class ParkingSpaceTransactionThread{
	private ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();
	private static ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction();

	public ParkingSpaceTransactionThread() {
		startParkingSpaceThread();
		
//		startParkingSpaceThread();
	}

	private void startParkingSpaceThread() {
		ParkingSpaceTransaction parkingSpaceTransaction=new ParkingSpaceTransaction();
		Thread parkingSpaceManagerThread=new Thread(parkingSpaceTransaction);
		printTransactionStartOnBoard(parkingSpaceManagerThread.getName());
		parkingSpaceManagerThread.start();
	}

	public void printTransactionStartOnBoard(String threadName) {
		parkingTextBoard.append(String.format(
				Names_PL.ParkingSpaceTransaction_Start, threadName));
	}

	
}
