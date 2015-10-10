package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.frame.ChooseClientFrame;
import pl.frame.CreateOrChooseClientFrame;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.tools.Tools;

public class ParkingSpaceListener implements ActionListener {

	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		ParkingSpaceButton parkingSpace = getParkingSpaceButton(e);
		if (parkingSpace.isOccupied())
			parkingSpace.setFree();
		else {
			parkingSpace.setOccupied();
			CreateOrChooseClientFrame createOrChooseClientFrame = new CreateOrChooseClientFrame();
		}
	}

	private ParkingSpaceButton getParkingSpaceButton(ActionEvent e) {
		JButton parkingSpaceButton= (JButton) e.getSource();
		Integer parkingSpaceNumber = Integer.valueOf(parkingSpaceButton.getText());
		ParkingSpaceButton parkingSpace = ParkingButtonPanel.getParkingSpaceList().get(parkingSpaceNumber);
		return parkingSpace;
	}

}
