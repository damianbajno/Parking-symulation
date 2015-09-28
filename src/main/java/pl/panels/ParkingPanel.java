package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.tools.GBC;

public class ParkingPanel extends JPanel {

	private static final Dimension parkingSpaceDimension = new Dimension(50, 50);
	ArrayList<JLabel> parkingFields = new ArrayList<JLabel>();

	public ParkingPanel() {
		createParkingSpace();
	}

	private void createParkingSpace() {
		setLayout(new GridBagLayout());
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				JLabel parkingField = new JLabel();
				parkingField.setOpaque(true);
				parkingField.setHorizontalAlignment(JLabel.CENTER);
				setParkingFieldsSettingsDifferFromPlace(parkingField, i, j);
				parkingField.setPreferredSize(parkingSpaceDimension);
				add(parkingField, new GBC(j, i));
				parkingFields.add(parkingField);
			}
		}
	}

	
	private static int parkingSpaceNumber = 1;
	private void setParkingFieldsSettingsDifferFromPlace(JLabel parkigFields, int i, int j) {
		if (selectingRoadFields(i, j)) {
			parkigFields.setText(String.valueOf(parkingSpaceNumber));
			parkingSpaceNumber++;
			parkigFields.setBackground(Color.GREEN);
		} else {
			parkigFields.setBackground(Color.GRAY);
		}

	}

	private boolean selectingRoadFields(int i, int j) {
		return (i == 0) || (i > 0 & i % 2 == 0 & j > 1);
	}
}
