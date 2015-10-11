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
	private static ParkingSpaceButton parkingSpaceButton1; 
	
	public ParkingSpaceListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		ParkingSpaceButton parkingSpaceButton = getParkingSpaceButton(e);
		if (parkingSpaceButton.isOccupied())
			parkingSpaceButton.setFree();
		else {
			CreateOrChooseClientFrame createOrChooseClientFrame = new CreateOrChooseClientFrame();
		}
	}

	private ParkingSpaceButton getParkingSpaceButton(ActionEvent e) {
		JButton parkingSpaceButton= (JButton) e.getSource();
		Integer parkingSpaceNumber = Integer.valueOf(parkingSpaceButton.getText());
		parkingSpaceButton1 = ParkingButtonPanel.getParkingSpaceList().get(parkingSpaceNumber);
		return parkingSpaceButton1;
	}

	public static ParkingSpace getSelectedParkingSpace() {
		int parkingSpaceNumber = parkingSpaceButton1.getParkingSpaceNumber();
		return ParkingSpaceDAO.get(parkingSpaceNumber);
				
	}

	
	
}
