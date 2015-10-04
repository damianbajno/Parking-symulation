package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.frame.ClientFrame;
import pl.panels.ParkingSpaceButton;
import pl.tools.Tools;

public class ParkingSpaceListener implements ActionListener {

	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		ParkingSpaceButton parkingSpaceButton = (ParkingSpaceButton) e.getSource();
		if (parkingSpaceButton.isOccupied())
			parkingSpaceButton.setFree();
		else {
			parkingSpaceButton.setOccupied();
			ClientFrame clientFrame=new ClientFrame();
			System.out.println(Tools.makeFirstLetterUpper("dupa"));;
		}
	}

}
