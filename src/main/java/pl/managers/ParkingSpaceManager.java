package pl.managers;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_PL;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.TextBoardParkingSpaces;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceManager {
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private static int numberOfClients = ClientDAO.getAll().size();
	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces.getInstance();
	private Random random = new Random();

	public ParkingSpaceManager() {

	}

	public synchronized void changeParkingSpaceStatusByThread(
			int parkingSpaceNumber) {
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
				.get(parkingSpaceNumber - 1);
		ParkingSpace parkingSpace = ParkingSpaceDAO.get(parkingSpaceNumber);
		if (parkingSpace.isOccupy()) {
			setParkingSpaceFree(parkingSpaceButton, parkingSpace);
		} else {
			setParkingSpaceOccupy(parkingSpaceButton, parkingSpace);
		}
	}

	private synchronized void setParkingSpaceOccupy(
			ParkingSpaceButton parkingSpaceButton, ParkingSpace parkingSpace) {
		parkingSpaceButton.setOccupy();
		ParkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpace,
				getClientWithOutParkingSpace());
//		printParkingSpaceOccupySentence(parkingSpace);
	}

	Client client;

	public Client getClientWithOutParkingSpace() {
		do {
			client = ClientDAO.get(random.nextInt(numberOfClients) + 1);
		} while (client.reservedParkingSpace());
		return client;
	}

	private synchronized void setParkingSpaceFree(
			ParkingSpaceButton parkingSpaceButton, ParkingSpace parkingSpace) {
		parkingSpaceButton.setFree();
//		printParkingSpaceFreeSentence(parkingSpace);
		ParkingSpaceDAO.parkingSpaceMakeFree(parkingSpace);
	}

	private synchronized void printParkingSpaceFreeSentence(
			ParkingSpace parkingSpace) {
		textBoardParkingSpaces.append(String.format(
				Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingNumber(), parkingSpace.getClient()
						.getId()));
	}

	private synchronized void printParkingSpaceOccupySentence(
			ParkingSpace parkingSpace) {
		textBoardParkingSpaces.append(String.format(
				Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingNumber(), parkingSpace.getClient()
						.getId()));
	}

}
