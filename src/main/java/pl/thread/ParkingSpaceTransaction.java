package pl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.constantsandstrings.Names_EN;
import pl.dao.ClientDAO;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;
import pl.pojo.Client;
import pl.tables.ClientTableModel;

public class ParkingSpaceTransaction {

	private ArrayList<ParkingSpaceButton> parkingSpaceList = ParkingButtonPanel
			.getParkingSpaceList();
	private Random random = new Random();
	private ParkingSpaceButton parkingSpace;
	private ParkingTextBoard parkingTextBoard= ParkingTextBoard.getInstance(); 
	
	
	public ParkingSpaceTransaction() {

	}

	public void printTransactionStartOnBoard(Integer threadNumber){
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Start,threadNumber));
	}
	
	public void transaction() {
		int numberOfParkingSpace = parkingSpaceList.size()-1;
		parkingSpace = parkingSpaceList.get(random.nextInt(numberOfParkingSpace) + 1);
		changeParkingSpaceStatus(parkingSpace);
	}

	private synchronized void changeParkingSpaceStatus(ParkingSpaceButton parkingSpaceButton) {
			if (parkingSpaceButton.isOccupied()) {
				parkingSpaceButton.setFree();
				printParkingPlaceFreeSentence(parkingSpaceButton);
			} else {
				parkingSpaceButton.setOccupy();
				printParkingPlaceOccupy(parkingSpaceButton);
			}
	}
	
	private void printParkingPlaceFreeSentence(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Parking_Place_Free,
				parkingSpace.getParkingSpaceNumber()));
	}

	private void printParkingPlaceOccupy(ParkingSpaceButton parkingSpace) {
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Parking_Place_Occupy,
				parkingSpace.getParkingSpaceNumber()));
	}

}
