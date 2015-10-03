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
import pl.panels.ParkingBoard;
import pl.panels.ParkingPanel;

public class ParkingManagerFrame extends JFrame {

	

	public ParkingManagerFrame() {
		setLayout(new BorderLayout());
		
		createParking();
		createParkingTextBorder();
	}

	public void createParking() {
		ParkingPanel parkingPanel=new ParkingPanel();
		JScrollPane parkingScrollPane=new JScrollPane(parkingPanel);
		add(parkingScrollPane, BorderLayout.EAST);
	}
	
	public void createParkingTextBorder() {
		ParkingBoard parkingBoard=new ParkingBoard();
		JScrollPane parkingBoardPane=new JScrollPane(parkingBoard);
		
		add(parkingBoardPane, BorderLayout.CENTER);
	}
	
}
