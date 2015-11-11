package pl.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.constantsandstrings.Names_PL;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingSpaceButtonList;
import pl.panels.TextBoardParkingSpaces;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceManager {
	private String threadName = Thread.currentThread().getName();
	private List<ParkingSpaceButton> parkingSpaceButtonList = ParkingSpaceButtonList.getInstance();
	private static int numberOfClients = ClientDAO.getAll().size();
	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces
			.getInstance();
	private Random random = new Random();
	private ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO();
	private ClientDAO clientDAO = new ClientDAO();

	public ParkingSpaceManager() {

	}

	private int numberOfParkingSpaces = parkingSpaceButtonList.size() - 1;
	int parkingSpaceNumber;

	public void changeParkingSpaceStatusByThread() {
		parkingSpaceNumber = random.nextInt(numberOfParkingSpaces) + 1;
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
				.get(parkingSpaceNumber - 1);
		if (parkingSpaceButton.isOccupy()) {
			setParkingSpaceFree(parkingSpaceButton);
		} else {
			setParkingSpaceOccupy(parkingSpaceButton);
		}
	}

	private void setParkingSpaceOccupy(
			ParkingSpaceButton parkingSpaceButton) {
		if (parkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpaceButton
				.getParkingNumber())) {
			parkingSpaceButton.setOccupy();
			printParkingSpaceOccupySentence(parkingSpaceButton);
		} else {
			printParkingSpaceFailOccupySentence(parkingSpaceButton);
		}
	}

	private void setParkingSpaceFree(
			ParkingSpaceButton parkingSpaceButton) {
		if (parkingSpaceDAO.parkingSpaceMakeFree(parkingSpaceButton
				.getParkingNumber())) {
			parkingSpaceButton.setFree();
			printParkingSpaceFreeSentence(parkingSpaceButton);
		} else {
			printParkingSpaceFailFreeSentence(parkingSpaceButton);
		}
	}

	private void printParkingSpaceFreeSentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "\n    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber()));
	}

	private void printParkingSpaceFailFreeSentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "\n    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber())+"  FAIL   ");
	}
	
	private void printParkingSpaceOccupySentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "\n    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber()));
	}
	
	private void printParkingSpaceFailOccupySentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "\n    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber())+"  FAIL   ");
	}

}
