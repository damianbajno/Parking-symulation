package pl.threadManager;

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
	private List<ParkingSpaceButton> parkingSpaceButtonList = ParkingSpaceButtonList
			.getInstance();
	private TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces
			.getInstance();
	private Random random = new Random();
	private ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO();

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

	private int clientNumberOccupy;
	private void setParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton) {
		if ((clientNumberOccupy=parkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpaceButton
				.getParkingNumber()))!=0) {
			parkingSpaceButton.setOccupy();
			printParkingSpaceOccupySentence(parkingSpaceButton);
		} else {
			printParkingSpaceFailOccupySentence(parkingSpaceButton);
		}
	}

	private int clientNumberFree;
	private void setParkingSpaceFree(ParkingSpaceButton parkingSpaceButton) {
		if ((clientNumberFree=parkingSpaceDAO.parkingSpaceMakeFree(parkingSpaceButton
				.getParkingNumber()))!=0) {
			parkingSpaceButton.setFree();
			printParkingSpaceFreeSentence(parkingSpaceButton);
		} else {
			printParkingSpaceFailFreeSentence(parkingSpaceButton);
		}
	}

	private void printParkingSpaceFreeSentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber(),clientNumberFree));
		System.out.println(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber(), clientNumberFree));
	}

	private void printParkingSpaceFailFreeSentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber(), clientNumberFree) + " == FAIL == ");
		System.out.println(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Free,
						parkingSpaceButton.getParkingNumber(), clientNumberFree) + " == FAIL ==  ");
	}

	private void printParkingSpaceOccupySentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber(), clientNumberOccupy));

		System.out.println(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber(),clientNumberOccupy));
	}

	private void printParkingSpaceFailOccupySentence(
			ParkingSpaceButton parkingSpaceButton) {
		textBoardParkingSpaces.append(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber(),clientNumberOccupy) + " == FAIL ==  ");
		System.out.println(threadName
				+ "    "
				+ String.format(
						Names_PL.ParkingSpaceTransaction_Parking_Place_Occupy,
						parkingSpaceButton.getParkingNumber(), clientNumberOccupy) + " == FAIL  == ");
	}

}
