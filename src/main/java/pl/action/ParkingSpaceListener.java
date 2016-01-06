package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.button.ParkingSpaceButton;
import pl.dao.ParkingSpaceDAO;
import pl.frame.CreateOrChooseClientFrame;
import pl.pojo.ParkingSpace;

public class ParkingSpaceListener implements ActionListener {
	private static ParkingSpaceButton parkingSpaceButton; 
	private ParkingSpaceDAO parkingSpaceDAO=ParkingSpaceDAO.getInstance();
	
	public void actionPerformed(ActionEvent e) {
		parkingSpaceButton= (ParkingSpaceButton) e.getSource();
		if (parkingSpaceButton.isFree())
			parkingSpaceButton.setFree();
		else {
			CreateOrChooseClientFrame createOrChooseClientFrame = new CreateOrChooseClientFrame();
		}
	}

	public ParkingSpace getSelectedParkingSpace() {
		int parkingSpaceNumber = parkingSpaceButton.getParkingNumber();
		return parkingSpaceDAO.get(parkingSpaceNumber);
				
	}
	
}
