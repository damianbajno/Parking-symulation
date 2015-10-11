package pl.managers;

import java.util.ArrayList;

import pl.constantsandstrings.Names_EN;
import pl.dao.ParkingSpaceDAO;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;
import pl.pojo.ParkingSpace;

public class ParkingSpaceManager {
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();

	public ParkingSpaceManager() {

	}

	public synchronized void changeParkingSpaceStatuByThread(
			int parkingSpaceNumber) {
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
				.get(parkingSpaceNumber);
		ParkingSpace parkingSpace = ParkingSpaceDAO.get(parkingSpaceNumber);
		synchronized (parkingSpaceButton) {
			if (parkingSpace.isOccupy()) {
				parkingSpace.setFree();
				parkingSpaceButton.setFree();
				printParkingPlaceFreeSentence(parkingSpaceButton);
			} else {
				parkingSpace.setOccupy();
				parkingSpaceButton.setOccupy();
				printParkingPlaceOccupy(parkingSpaceButton);
			}
		}
		ParkingSpaceDAO.update(parkingSpace);
	}

	private void printParkingPlaceFreeSentence(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(
				Names_EN.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingSpaceNumber()));
	}

	private void printParkingPlaceOccupy(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(
				Names_EN.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingSpaceNumber()));
	}

	public void setOccupyByUser() {

	}

	public void setFreeByUser() {

	}
}
