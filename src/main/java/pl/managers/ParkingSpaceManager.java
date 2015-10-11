package pl.managers;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_PL;
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
				setParkingSpaceFree(parkingSpaceButton, parkingSpace);
			} else {
				setParkingSpaceOccupy(parkingSpaceButton, parkingSpace);
			}
		}
		ParkingSpaceDAO.update(parkingSpace);
	}

	private void setParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton,
			ParkingSpace parkingSpace) {
		parkingSpaceButton.setOccupy();
		connectClientToParkingSpace(parkingSpace);
		printParkingPlaceOccupy(parkingSpace);
	}

	private Client clientWithOutParkingSpace;
	private void connectClientToParkingSpace(ParkingSpace parkingSpace) {
		clientWithOutParkingSpace = getClientWithOutParkingSpace();
		clientWithOutParkingSpace.setReserved(true);
		parkingSpace.setClient(clientWithOutParkingSpace);
		ParkingSpaceDAO.update(parkingSpace);
		ClientDAO.update(clientWithOutParkingSpace);
	}

	private void setParkingSpaceFree(ParkingSpaceButton parkingSpaceButton,
			ParkingSpace parkingSpace) {
		parkingSpaceButton.setFree();
		printParkingPlaceFreeSentence(parkingSpace);
		disconnectClientFromParkingSpace(parkingSpace);
	}

	private void disconnectClientFromParkingSpace(ParkingSpace parkingSpace) {
		parkingSpace.setClient(null);
	}

	private Client getClientWithOutParkingSpace() {
		do {
			client = ClientDAO.get(random.nextInt(numberOfClients) + 1);
		} while (client.reservedParkingSpace());

		return client;
	}

	private void printParkingPlaceFreeSentence(ParkingSpace parkingSpace) {
		parkingTextBoard.append(String.format(
				Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingNumber(), 
				parkingSpace.getClient().getId()));
	}

	private void printParkingPlaceOccupy(ParkingSpace parkingSpace) {
		parkingTextBoard.append(String.format(
				Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingNumber(),clientWithOutParkingSpace.getId()));
	}

	public void setOccupyByUser() {

	}

	public void setFreeByUser() {

	}
}
