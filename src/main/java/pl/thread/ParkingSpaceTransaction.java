package pl.thread;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_EN;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;

public class ParkingSpaceTransaction {

	private ArrayList<ParkingSpaceButton> parkingSpaceList = ParkingButtonPanel
			.getParkingSpaceList();
	private Random random = new Random();
	private ParkingSpaceButton parkingSpace;
	private ParkingTextBoard parkingTextBoard; 
	
	public ParkingSpaceTransaction() {
		parkingTextBoard = ParkingTextBoard.getInstance();
	}

	public void transaction() {
		int numberOfParkingSpace = parkingSpaceList.size()-1;
		parkingSpace = parkingSpaceList.get(random.nextInt(numberOfParkingSpace) + 1);
		changeParkingSpaceStatus(parkingSpace);
	}

	/**
	 * @param parkingSpace
	 */
	private void changeParkingSpaceStatus(ParkingSpaceButton parkingSpace) {
		synchronized (parkingSpace) {
			if (parkingSpace.isOccupied()) {
				parkingSpace.setFree();
				parkingPlaceFreeSentence(parkingSpace);
			} else {
				parkingSpace.setOccupied();
				parkingPlaceOccupySentence(parkingSpace);
			}
		}
	}

	private void parkingPlaceFreeSentence(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingSpaceNumber()));
	}

	private void parkingPlaceOccupySentence(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingSpaceNumber()));
	}

}
