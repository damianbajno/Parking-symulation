package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.dao.ParkingSpaceDAO;
import pl.frame.ChooseClientFrame;
import pl.frame.CreateOrChooseClientFrame;
import pl.panel.ParkingButtonPanel;
import pl.panel.ParkingSpaceButton;
import pl.pojo.ParkingSpace;
import pl.tools.MassageTextUtils;

public class ParkingSpaceListener implements ActionListener {
	private static ParkingSpaceButton parkingSpaceButton; 
	private ParkingSpaceDAO parkingSpaceDAO=ParkingSpaceDAO.getInstance();
	
	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

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
