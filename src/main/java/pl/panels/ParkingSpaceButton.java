package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceButton extends JButton {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
	private static int parkingSpaceNumberGenerator = 0;
	private int parkingSpaceNumber;

	public ParkingSpaceButton() {
		parkingSpaceNumber = parkingSpaceNumberGenerator++;
		defaultSettings();
		setParkingSpaceStatus();
	}

	private void defaultSettings() {
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(parkingSpaceDimension);
		setText(String.valueOf(parkingSpaceNumberGenerator));
		setBorder(new LineBorder(Color.BLACK, 2, false));
		addActionListener(parkingSpaceListener);
	}

	/**
	 * 
	 */
	private void setParkingSpaceStatus() {
		ParkingSpace parkingSpace = ParkingSpaceDAO
				.get(parkingSpaceNumberGenerator);
		if (parkingSpace.isOccupy())
			setBackground(Color.RED);
		else
			setBackground(Color.GREEN);
	}

	public void setOccupy() {
		setBackground(Color.RED);
	}

	public void setFree() {
		setBackground(Color.GREEN);
	}

	public boolean isOccupied() {
		if (getBackground().equals(Color.RED))
			return true;
		else
			return false;
	}

	public int getParkingSpaceNumber() {
		return parkingSpaceNumber;
	}

}
