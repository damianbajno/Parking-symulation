package pl.panel;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pl.constantsandstrings.Constants;
import pl.threadmanager.ParkingSpaceTransactionThread;
import pl.tools.GBC;

public class ParkingButtonPanel extends JPanel {

    private ParkingSpaceButtonList parkingSpaceButtons = ParkingSpaceButtonList
	    .getInstance();


    public ParkingButtonPanel() {
	createParkingFields();
    }


    private void createParkingFields() {
	setLayout(new GridBagLayout());
	for (int i = 0; i < Constants.PARKING_PANEL_ROWS; i++) {
	    for (int j = 0; j < Constants.PARKING_PANEL_COLUMNS; j++) {

		if (selectingRoadFields(i, j)) {
		    ParkingSpaceButton parkingSpaceButton = new ParkingSpaceButton();
		    add(parkingSpaceButton, new GBC(j, i));
		    parkingSpaceButtons.add(parkingSpaceButton);
		} else {
		    ParkingRoadButton parkingRoadButton = new ParkingRoadButton();
		    add(parkingRoadButton, new GBC(j, i));
		}
	
	    }
	}

    }


    private boolean selectingRoadFields(int i, int j) {
	return (i == 0) || (i > 0 & (i + 4) % 3 / 2 == 0 & j > 1);
    }

}
