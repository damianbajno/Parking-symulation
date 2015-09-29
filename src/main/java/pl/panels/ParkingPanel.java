package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.constantsandstrings.Constants;
import pl.tools.GBC;

public class ParkingPanel extends JPanel {

	private static ArrayList<ParkingField> parkingFieldList = new ArrayList<ParkingField>();

	public ParkingPanel() {
		createParkingSpace();
	}

	private void createParkingSpace() {
		setLayout(new GridBagLayout());
		for (int i = 0; i < Constants.ParkingPanel_ROWS; i++) {
			for (int j = 0; j < Constants.ParkingPanel_COLUMNS; j++) {
				ParkingField parkingField = new ParkingField();
				setRoadOrPrakingSpace(parkingField, i, j);
				add(parkingField, new GBC(j, i));
				if (parkingField.isParkingSpace())
					parkingFieldList.add(parkingField);
			}
		}
	}

	private void setRoadOrPrakingSpace(ParkingField parkingField, int i, int j) {
		if (selectingRoadFields(i, j)) {
			parkingField.setParkingSpace();
		} else {
			parkingField.setRoad();
		}

	}

	private boolean selectingRoadFields(int i, int j) {
		return (i == 0) || (i > 0 & (i + 4) % 3 / 2 == 0 & j > 1);
	}
}
