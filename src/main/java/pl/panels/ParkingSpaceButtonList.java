package pl.panels;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParkingSpaceButtonList {
	private static List<ParkingSpaceButton> parkingSpaceButtonList;

	private ParkingSpaceButtonList() {
	}

	public static List<ParkingSpaceButton> getInstance(){
		if (parkingSpaceButtonList==null){
			synchronized (ParkingSpaceButtonList.class) {
				if (parkingSpaceButtonList==null)
				parkingSpaceButtonList=new ArrayList<ParkingSpaceButton>();
			}
		}
		return parkingSpaceButtonList;
	}
	
	
	public ParkingSpaceButton get(int index) {
		ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
				.get(index);
		parkingSpaceButton.lock();
		return parkingSpaceButton;
	}

	public int size() {
		return parkingSpaceButtonList.size();
	}

	public synchronized ParkingSpaceButton getRandomParkingSpace() {
		Random random = new Random();
		int parkingSpaceNumber;
		ParkingSpaceButton parkingSpaceButton;

		do {
			parkingSpaceNumber = random.nextInt(parkingSpaceButtonList.size());
			parkingSpaceButton = parkingSpaceButtonList.get(parkingSpaceNumber);
		} while (parkingSpaceButton.isLock());
		parkingSpaceButton.lock();
		return parkingSpaceButton;
	}
	
	public void add(ParkingSpaceButton parkingSpaceButton){
		parkingSpaceButtonList.add(parkingSpaceButton);
	}

}
