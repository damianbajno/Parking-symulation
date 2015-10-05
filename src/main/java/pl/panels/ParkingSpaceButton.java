package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.pojo.ParkingSpace;

public class ParkingSpaceButton {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private static int parkingSpaceNumberGenerator = 1;
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
	private ParkingSpace parkingSpace;
	private JButton parkingSpaceButton=new JButton();
	private int parkingSpaceNumber;
	
	public ParkingSpaceButton() {
		defaultSettings();
		sendToDataBase();
		parkingSpaceNumber=parkingSpaceNumberGenerator++;
	}

	private void defaultSettings() {
		parkingSpaceButton.setOpaque(true);
		parkingSpaceButton.setHorizontalAlignment(JLabel.CENTER);
		parkingSpaceButton.setPreferredSize(parkingSpaceDimension);
		parkingSpaceButton.setText(String.valueOf(parkingSpaceNumberGenerator));
		parkingSpaceButton.setBorder(new LineBorder(Color.BLACK, 2, false));
		parkingSpaceButton.setBackground(Color.GREEN);
		parkingSpaceButton.addActionListener(parkingSpaceListener);
	}

	private void sendToDataBase() {
		parkingSpace = new ParkingSpace(parkingSpaceNumberGenerator,
				200 + new Random().nextInt(200));
//		ParkingSpaceDAO.persist(parkingSpace);
	}

	public void setOccupied() {
		parkingSpaceButton.setBackground(Color.RED);
	}

	public void setFree() {
		parkingSpaceButton.setBackground(Color.GREEN);
	}

	public boolean isOccupied() {
		if (parkingSpaceButton.getBackground().equals(Color.RED))
			return true;
		else
			return false;
	}
	
	public JButton getParkingSpaceButton(){
		return parkingSpaceButton;
	}

	public int getParkingSpaceNumber() {
		return parkingSpaceNumber;
	}
	
	
}
