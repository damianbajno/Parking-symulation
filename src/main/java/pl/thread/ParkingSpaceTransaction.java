package pl.thread;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_PL;
import pl.managers.ParkingSpaceManager;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;

public class ParkingSpaceTransaction implements Runnable {

	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private Random random = new Random();
	private ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();

	public ParkingSpaceTransaction() {

	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			transaction();
			threadAwait(200);
		}
	}

	public void transaction() {
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
