package pl.thread;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_PL;
import pl.managers.ParkingSpaceManager;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;

public class ParkingSpaceTransactionThread implements Runnable{
	private ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private Random random = new Random();
	private ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();

	
	public synchronized void startParkingSpaceThread() {
		Thread parkingSpaceManagerThread = new Thread(this);
		printTransactionStartOnBoard(parkingSpaceManagerThread.getName());
		parkingSpaceManagerThread.start();
	}

	public void printTransactionStartOnBoard(String threadName) {
		parkingTextBoard.append(String.format(
				Names_PL.ParkingSpaceTransaction_Start, threadName));
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			transaction();
			threadAwait(20);
		}
	}

	public synchronized void transaction() {
		int numberOfParkingSpaces = parkingSpaceButtonList.size() - 1;
		int parkingSpaceNumber = random.nextInt(numberOfParkingSpaces) + 1;
		parkingSpaceManager.changeParkingSpaceStatusByThread(parkingSpaceNumber);
	}

	private void threadAwait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.err.println(Names_PL.PARKINGMANAGERTHREAD_GetInterupted);
			e.printStackTrace();
		}
	}

}
