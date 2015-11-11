package pl.panels;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pl.constantsandstrings.Constants;
import pl.thread.ParkingSpaceTransactionThread;
import pl.tools.GBC;

public class ParkingButtonPanel extends JPanel {

	private List<ParkingSpaceButton> parkingSpaceList = ParkingSpaceButtonList.getInstance();
	
	public ParkingButtonPanel() {
		createParkingFields();
	}

	private void createParkingFields() {
		setLayout(new GridBagLayout());
		for (int i = 0; i < Constants.ParkingPanel_ROWS; i++) {
			for (int j = 0; j < Constants.ParkingPanel_COLUMNS; j++) {
				if (selectingRoadFields(i, j)) {
					ParkingSpaceButton parkingSpaceButton=new ParkingSpaceButton();
					add(parkingSpaceButton, new GBC(j, i));
					parkingSpaceList.add(parkingSpaceButton);
				} else {
					ParkingRoadButton parkingRoadButton=new ParkingRoadButton();
					add(parkingRoadButton, new GBC(j, i));
				}
			}
		}
		
		ParkingSpaceTransactionThread parkingSpaceTransactionThread=new ParkingSpaceTransactionThread();
	}

	private boolean selectingRoadFields(int i, int j) {
		return (i == 0) || (i > 0 & (i + 4) % 3 / 2 == 0 & j > 1);
	}

}
