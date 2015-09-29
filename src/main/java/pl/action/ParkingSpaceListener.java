package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.panels.ParkingField;

public class ParkingSpaceListener implements ActionListener {

	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		ParkingField parkingField = (ParkingField) e.getSource();
		if (parkingField.isOccupied())
			parkingField.setFree();
		else
			parkingField.setOccupied();
	}

}
