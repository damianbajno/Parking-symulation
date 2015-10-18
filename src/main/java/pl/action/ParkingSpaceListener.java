package pl.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.dao.ParkingSpaceDAO;
import pl.frame.ChooseClientFrame;
import pl.frame.CreateOrChooseClientFrame;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingSpaceButton;
import pl.pojo.ParkingSpace;
import pl.tools.Tools;

public class ParkingSpaceListener implements ActionListener {
	private static ParkingSpaceButton parkingSpaceButton; 
	
	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		parkingSpaceButton= (ParkingSpaceButton) e.getSource();
		if (parkingSpaceButton.isOccupy())
			parkingSpaceButton.setFree();
		else {
			CreateOrChooseClientFrame createOrChooseClientFrame = new CreateOrChooseClientFrame();
		}
	}

	public static ParkingSpace getSelectedParkingSpace() {
		int parkingSpaceNumber = parkingSpaceButton.getParkingSpaceNumber();
		return ParkingSpaceDAO.get(parkingSpaceNumber);
				
	}

	
	
}
