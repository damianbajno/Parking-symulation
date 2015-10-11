package pl.panels;

import java.awt.Color;

import javax.swing.JButton;

import pl.constantsandstrings.Constants;

public class ParkingRoadButton extends JButton {

	public ParkingRoadButton() {
		setDefaultSettings();
	}

	private void setDefaultSettings() {
		setOpaque(true);
		setPreferredSize(Constants.parkingFieldDimension);
		setBackground(Color.GRAY);
		setEnabled(false);
		setBorder(null);
	}

}
