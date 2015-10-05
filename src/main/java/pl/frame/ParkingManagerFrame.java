package pl.frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingTextBoard;

public class ParkingManagerFrame extends JFrame {

	

	public ParkingManagerFrame() {
		setLayout(new BorderLayout());
		
		createParking();
		createParkingTextBorder();
	}

	public void createParking() {
		ParkingButtonPanel parkingButtonPanel=new ParkingButtonPanel();
		JScrollPane parkingScrollPane=new JScrollPane(parkingButtonPanel);
		add(parkingScrollPane, BorderLayout.EAST);
	}
	
	public void createParkingTextBorder() {
		ParkingTextBoard parkingTextBoard=ParkingTextBoard.getInstance();
		JScrollPane parkingBoardPane=new JScrollPane(parkingTextBoard);
		
		add(parkingBoardPane, BorderLayout.CENTER);
	}
	
}
