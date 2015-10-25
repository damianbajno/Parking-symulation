package pl.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import pl.constantsandstrings.Names_PL;
import pl.managers.ParkingSpaceManager;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.TextBoardParkingSpaces;
import pl.panels.ThreadButton;
import pl.panels.ThreadButtonPanel;

public class ParkingSpaceTransactionThread {

	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces.getInstance();
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();
	private static AtomicInteger totalNumberLoops = new AtomicInteger(0);
	private ExecutorService parkingSpaceFixedThreadPool = Executors.newFixedThreadPool(2);
	
	public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
		ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction(threadButton);
		printTransactionStartOnBoard(threadButton.getName());
		parkingSpaceFixedThreadPool.execute(parkingSpaceTransaction);
	}

	public void printTransactionStartOnBoard(String threadName) {
		textBoardParkingSpaces.append(String.format(
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
			}
			textBoardParkingSpaces.append(Thread.currentThread().getName()+ " -- STOP ---");
			threadButton.setEnabled(true);
		}

		public synchronized void transaction() {
			int numberOfParkingSpaces = parkingSpaceButtonList.size() - 1;
			int parkingSpaceNumber = random.nextInt(numberOfParkingSpaces) + 1;
			totalNumberLoops.incrementAndGet();
//			textBoardParkingSpaces.append(totalNumberLoops + "   "
//					+ Thread.currentThread().getName() + "\n");
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
