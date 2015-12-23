package pl.panel;

import java.util.ArrayList;
import java.util.Random;

public class ParkingSpaceButtonList {
    private static ArrayList<ParkingSpaceButton> parkingSpaceButtons = new ArrayList<ParkingSpaceButton>();
    private static ParkingSpaceButtonList parkingSpaceButtonList;
    private ParkingSpacesTextBoard parkingSpacesTextBoard = ParkingSpacesTextBoard
	    .getInstance();

    private ParkingSpaceButtonList() {
    }

    public static ParkingSpaceButtonList getInstance() {
	if (parkingSpaceButtonList == null) {
	    synchronized (ParkingSpaceButtonList.class) {
		if (parkingSpaceButtonList == null)
		    ;
		parkingSpaceButtonList = new ParkingSpaceButtonList();
	    }
	}
	return parkingSpaceButtonList;
    }

    public ParkingSpaceButton get(int index) {
	ParkingSpaceButton parkingSpaceButton = parkingSpaceButtons.get(index);
	parkingSpaceButton.trylock();
	return parkingSpaceButton;
    }

    public int size() {
	return parkingSpaceButtons.size();
    }

    private Random random = new Random();

    public synchronized ParkingSpaceButton getRandomParkingSpace() {
	int parkingSpaceNumber;
	ParkingSpaceButton parkingSpaceButton;

	do {
	    parkingSpaceNumber = random.nextInt(parkingSpaceButtons.size());
	    parkingSpaceButton = parkingSpaceButtons.get(parkingSpaceNumber);

	} while (!parkingSpaceButton.trylock());
	parkingSpacesTextBoard.append("getRandomParkingSpace "
		+ Thread.currentThread().getName() + "parking= "
		+ parkingSpaceButton.getText() + " \n");
	return parkingSpaceButton;
    }

    public void add(ParkingSpaceButton parkingSpaceButton) {
	parkingSpaceButtons.add(parkingSpaceButton);
    }

}
