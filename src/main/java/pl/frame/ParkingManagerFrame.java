package pl.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_EN;
import pl.panels.ParkingTextBoard;
import pl.panels.ParkingButtonPanel;

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
