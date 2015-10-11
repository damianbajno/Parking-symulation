package pl.panels;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import pl.constantsandstrings.Constants;
import pl.thread.ParkingSpaceManagerThread;
import pl.tools.GBC;

public class ParkingButtonPanel extends JPanel {

	private static ArrayList<ParkingSpaceButton> parkingSpaceList = new ArrayList<ParkingSpaceButton>();
	
	public ParkingButtonPanel() {
		createParkingFields();
		startParkingManagerThread();
		startParkingManagerThread();
	}

	private void createParkingFields() {
		setLayout(new GridBagLayout());
		for (int i = 0; i < Constants.ParkingPanel_ROWS; i++) {
			for (int j = 0; j < Constants.ParkingPanel_COLUMNS; j++) {
				if (selectingRoadFields(i, j)) {
					ParkingSpaceButton parkingSpaceButton=new ParkingSpaceButton();
					add(parkingSpaceButton.getParkingSpaceButton(), new GBC(j, i));
					parkingSpaceList.add(parkingSpaceButton);
				} else {
					ParkingRoadButton parkingRoadButton=new ParkingRoadButton();
					add(parkingRoadButton, new GBC(j, i));
				}
			}
		}
	}

	private void startParkingManagerThread() {
//		ExecutorService transactionFixedThreadPool = Executors.newFixedThreadPool(2);
//		transactionFixedThreadPool.submit(task)
		
		ParkingSpaceManagerThread parkingManager=new ParkingSpaceManagerThread();
		Thread parkingManagerThread=new Thread(parkingManager);
		parkingManagerThread.start();
	}

	private boolean selectingRoadFields(int i, int j) {
		return (i == 0) || (i > 0 & (i + 4) % 3 / 2 == 0 & j > 1);
	}

	public static ArrayList<ParkingSpaceButton> getParkingSpaceList() {
		return parkingSpaceList;
	}

}
