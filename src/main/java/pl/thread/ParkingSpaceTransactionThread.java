package pl.thread;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;
import pl.managers.ParkingSpaceManager;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;
import pl.panels.ThreadButton;
import pl.panels.ThreadButtonPanel;

public class ParkingSpaceTransactionThread {

	private ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();
	private static int totalNumberLoops = 0;
	
	
	public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
		ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction(threadButton);
		Thread parkingSpaceManagerThread = new Thread(parkingSpaceTransaction);
		parkingSpaceManagerThread.setName(threadButton.getName());
		printTransactionStartOnBoard(parkingSpaceManagerThread.getName());
		parkingSpaceManagerThread.start();
	}

	public void printTransactionStartOnBoard(String threadName) {
		parkingTextBoard.append(String.format(
				Names_PL.ParkingSpaceTransaction_Start, threadName));
	}

	// //// NESTED CLASS /////

	private class ParkingSpaceTransaction implements Runnable {
		private Random random = new Random();
		private ThreadButton threadButton;
		
		public ParkingSpaceTransaction(ThreadButton threadButton) {
			super();
			this.threadButton = threadButton;
		}

		public void run() {
			int numberOfLoops = ThreadButtonPanel.numberOfLoops;
			for (int i = 0; i < numberOfLoops; i++) {
				transaction();
				threadAwait(20);
			}
			threadButton.setEnabled(true);
		}

		public synchronized void transaction() {
			int numberOfParkingSpaces = parkingSpaceButtonList.size() - 1;
			int parkingSpaceNumber = random.nextInt(numberOfParkingSpaces) + 1;
			totalNumberLoops++;
			parkingTextBoard.append(totalNumberLoops + "   "
					+ Thread.currentThread().getName() + "\n");
			parkingSpaceManager
					.changeParkingSpaceStatusByThread(parkingSpaceNumber);
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
}
