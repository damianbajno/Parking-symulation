package pl.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;

public class ParkingField {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private static int parkingSpaceNumber = 1;
	private JButton parkingField;
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
	private boolean isPrakingSpace=false;
	
	public ParkingField() {
		parkingField = new JButton();
		parkingField.setOpaque(true);
		parkingField.setHorizontalAlignment(JLabel.CENTER);
		parkingField.setPreferredSize(parkingSpaceDimension);
	}

	public void setParkingSpace() {
		parkingField.setText(String.valueOf(parkingSpaceNumber));
		parkingField.setBorder(new LineBorder(Color.BLACK, 2, false));
		parkingSpaceNumber++;
		parkingField.setBackground(Color.GREEN);
		parkingField.addActionListener(parkingSpaceListener);
		isPrakingSpace=true;
	}

	public void setRoad() {
		parkingField.setBackground(Color.GRAY);
		parkingField.setBorder(null);
	}

	public JButton getParkingField() {
		return parkingField;
	}

	public boolean isParkingSpace(){
		return isPrakingSpace;
	}
}
