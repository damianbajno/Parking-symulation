package pl.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;

public class ParkingField extends JButton {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	public static int parkingSpaceNumber = 1;
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();

	public ParkingField() {
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(parkingSpaceDimension);
	}

	public void setParkingSpace() {
		setText(String.valueOf(parkingSpaceNumber));
		setBorder(new LineBorder(Color.BLACK, 2, false));
		setBackground(Color.GREEN);
		addActionListener(parkingSpaceListener);
		parkingSpaceNumber++;
	}

	public void setRoad() {
		setBackground(Color.GRAY);
		setBorder(null);
	}

	public void setOccupied() {
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
	
	public boolean isParkingSpace() {
		if (getBackground().equals(Color.GREEN))
			return true;
		else
			return false;
	}
	
}
