package pl.thread;

import java.util.ArrayList;
import java.util.Random;

import pl.constantsandstrings.Names_EN;
import pl.managers.ParkingSpaceManager;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.panels.ParkingTextBoard;

public class ParkingSpaceTransaction {

	private ArrayList<ParkingSpaceButton> parkingSpaceButtonList = ParkingButtonPanel
			.getParkingSpaceList();
	private ParkingTextBoard parkingTextBoard= ParkingTextBoard.getInstance();
	private Random random = new Random();

	private ParkingSpaceManager parkingSpaceManager=new ParkingSpaceManager();
	
	public ParkingSpaceTransaction() {

	}

	public void printTransactionStartOnBoard(Integer threadNumber){
		parkingTextBoard.append(String.format(Names_EN.ParkingSpaceTransaction_Start,threadNumber));
	}
	
	public void transaction() {
		int numberOfParkingSpaces = parkingSpaceButtonList.size()-1;
		int parkingSpaceNumber=random.nextInt(numberOfParkingSpaces)+1;
		parkingSpaceManager.changeParkingSpaceStatuByThread(parkingSpaceNumber);
	}

}
