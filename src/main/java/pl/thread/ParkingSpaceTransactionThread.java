package pl.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import pl.constantsandstrings.Names_PL;
import pl.managers.ParkingSpaceManager;
import pl.panels.TextBoardParkingSpaces;
import pl.panels.ThreadButton;
import pl.panels.ThreadButtonPanel;

public class ParkingSpaceTransactionThread {

	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces.getInstance();

	private static AtomicInteger totalNumberLoops = new AtomicInteger(0);
	private ExecutorService parkingSpaceFixedThreadPool = Executors.newFixedThreadPool(4);

	public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
		ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction(threadButton);
		parkingSpaceFixedThreadPool.execute(parkingSpaceTransaction);
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
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
			ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();

			int numberOfLoops = ThreadButtonPanel.numberOfLoops;
			for (int i = 0; i < numberOfLoops; i++) {
				totalNumberLoops.incrementAndGet();
				parkingSpaceManager.changeParkingSpaceStatusByThread();
				sleep(10);
			}
			threadButton.setEnabled(true);
		}

		private void sleep(int time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				System.err.println(Names_PL.PARKINGMANAGERTHREAD_GetInterupted);
				e.printStackTrace();
			}
		}
	}
}
