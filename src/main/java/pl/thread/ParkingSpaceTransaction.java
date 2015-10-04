package pl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.constantsandstrings.Names_EN;
import pl.dao.ClientDAO;
import pl.panels.ParkingPanel;
import pl.panels.ParkingSpaceButton;
import pl.pojo.Client;

public class ParkingSpaceTransaction {

	private List<Client> clientList = ClientDAO.getAll();
	private ArrayList<ParkingSpaceButton> parkingSpaceList = ParkingPanel
			.getParkingSpaceList();
	private Random random = new Random();

	public ParkingSpaceTransaction() {

	}

	public void transaction() {

		ParkingSpaceButton parkingSpace;
		parkingSpace = parkingSpaceList.get(random.nextInt(56) + 1);
		synchronized (parkingSpace) {
			if (parkingSpace.isOccupied()) {
				parkingSpace.setFree();
				parkingPlaceOccupySentence(parkingSpace);
			} else {
				parkingSpace.setOccupied();
				parkingPlaceFreeSentence(parkingSpace);
			}
		}

	}

	private void parkingPlaceFreeSentence(ParkingSpaceButton parkingSpace) {
		System.out.printf(Names_EN.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingSpaceNumber());
		System.out.println();
	}

	private void parkingPlaceOccupySentence(ParkingSpaceButton parkingSpace) {
		System.out.printf(Names_EN.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingSpaceNumber());
		System.out.println();
	}

}
