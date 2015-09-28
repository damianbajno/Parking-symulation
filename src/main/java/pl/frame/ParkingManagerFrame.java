package pl.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.panels.ParkingPanel;

public class ParkingManagerFrame extends JFrame {

	public ParkingManagerFrame() {
		setLayout(new BorderLayout());
		
		createParking();
	}

	public void createParking() {
		ParkingPanel parkingPanel=new ParkingPanel();
		JScrollPane parkingScrollPane=new JScrollPane(parkingPanel);
		add(parkingScrollPane, BorderLayout.EAST);
	}

}
