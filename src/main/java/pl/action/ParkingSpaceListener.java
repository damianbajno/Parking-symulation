package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.frame.ClientFrame;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.tools.Tools;

public class ParkingSpaceListener implements ActionListener {

	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		JButton parkingSpaceButton= (JButton) e.getSource();
		Integer parkingSpaceNumber = Integer.valueOf(parkingSpaceButton.getText());
		ParkingSpaceButton parkingSpace = ParkingButtonPanel.getParkingSpaceList().get(parkingSpaceNumber);
		if (parkingSpace.isOccupied())
			parkingSpace.setFree();
		else {
			parkingSpace.setOccupied();
			ClientFrame clientFrame=new ClientFrame();
			System.out.println(Tools.makeFirstLetterUpper("dupa"));;
		}
	}

}
