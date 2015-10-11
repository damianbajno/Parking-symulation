package pl.managers;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_EN;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceManager {
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();
	private int numberOfClients = ClientDAO.getAll().size();
	private Random random = new Random();
	private Client client;

	public ParkingSpaceManager() {

	}

	public synchronized void changeParkingSpaceStatuByThread(
			int parkingSpaceNumber) {
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
				.get(parkingSpaceNumber);
		ParkingSpace parkingSpace = ParkingSpaceDAO.get(parkingSpaceNumber);
		synchronized (parkingSpaceButton) {
			if (parkingSpace.isOccupy()) {
				makeParkingSpaceFree(parkingSpaceButton, parkingSpace);
			} else {
				makeParkingSpaceOccupy(parkingSpaceButton, parkingSpace);
			}
		}
		ParkingSpaceDAO.update(parkingSpace);
	}

	private void makeParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton,
			ParkingSpace parkingSpace) {
		parkingSpace.setOccupy();
		parkingSpaceButton.setOccupy();
		connectClientToParkingSpace(parkingSpace);
		printParkingPlaceOccupy(parkingSpaceButton);
	}

	private void connectClientToParkingSpace(ParkingSpace parkingSpace) {
		Client clientWithOutParkingSpace = getClientWithOutParkingSpace();
		clientWithOutParkingSpace.setParkingSpace(parkingSpace);
		ClientDAO.update(clientWithOutParkingSpace);
	}

	private void makeParkingSpaceFree(ParkingSpaceButton parkingSpaceButton,
			ParkingSpace parkingSpace) {
		parkingSpace.setFree();
		parkingSpaceButton.setFree();
		disconnectClientFromParkingSpace(parkingSpace);
		printParkingPlaceFreeSentence(parkingSpaceButton);
	}

	private void disconnectClientFromParkingSpace(ParkingSpace parkingSpace) {
		Client client2 = parkingSpace.getClient();
		if (client2 != null) {
			client2.setParkingSpace(null);
			ClientDAO.update(client2);
		}
	}

	private Client getClientWithOutParkingSpace() {
		do {
			client = ClientDAO.get(random.nextInt(numberOfClients) + 1);
		} while (client.reservedParkingSpace());

		return client;
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
