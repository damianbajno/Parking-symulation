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
	private String threadName=Thread.currentThread().getName();
	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel.getParkingSpaceList();
	private static int numberOfClients = ClientDAO.getAll().size();
	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces.getInstance();
	private Random random = new Random();
	private ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO();
	private ClientDAO clientDAO = new ClientDAO();

	public ParkingSpaceManager() {

	}

	private int numberOfParkingSpaces = parkingSpaceButtonList.size() - 1;
	int parkingSpaceNumber;

	public void changeParkingSpaceStatusByThread() {
		parkingSpaceNumber = random.nextInt(numberOfParkingSpaces) + 1;
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList.get(parkingSpaceNumber - 1);
		ParkingSpace parkingSpace = parkingSpaceDAO.get(parkingSpaceNumber);
		if (parkingSpace.isOccupy()) {
			setParkingSpaceFree(parkingSpaceButton, parkingSpace);
		} else {
			setParkingSpaceOccupy(parkingSpaceButton, parkingSpace);
		}
	}

	private synchronized void setParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton, ParkingSpace parkingSpace) {
		if (parkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpace, getClientWithOutParkingSpace())) {
			parkingSpaceButton.setOccupy();
			printParkingSpaceOccupySentence(parkingSpace);
		}
	}

	Client client;

	public Client getClientWithOutParkingSpace() {
		do {
			client = clientDAO.get(random.nextInt(numberOfClients) + 1);
		} while (client.reservedParkingSpace());
		return client;
	}

	private synchronized void setParkingSpaceFree(ParkingSpaceButton parkingSpaceButton, ParkingSpace parkingSpace) {
		printParkingSpaceFreeSentence(parkingSpace);
		if (parkingSpaceDAO.parkingSpaceMakeFree(parkingSpace))
		parkingSpaceButton.setFree();
	}

	private synchronized void printParkingSpaceFreeSentence(ParkingSpace parkingSpace) {
		textBoardParkingSpaces.append(threadName+"\n    "+String.format(Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingNumber(), parkingSpace.getClient().getId()));
	}

	private synchronized void printParkingSpaceOccupySentence(ParkingSpace parkingSpace) {
		textBoardParkingSpaces.append(threadName+"\n    "+String.format(Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingNumber(), parkingSpace.getClient().getId()));
	}

}
