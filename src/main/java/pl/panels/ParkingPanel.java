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
import pl.tools.GBC;

public class ParkingPanel extends JPanel {

	private static final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private static ArrayList<JButton> parkingFieldList = new ArrayList<JButton>();
	private ParkingSpaceListener parkingSpaceListener=new ParkingSpaceListener();
	
	public ParkingPanel() {
		createParkingSpace();
	}

	private void createParkingSpace() {
		setLayout(new GridBagLayout());
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 13; j++) {
				JButton parkingField = new JButton();
				parkingField.setOpaque(true);
				parkingField.setHorizontalAlignment(JLabel.CENTER);
				setParkingFieldsSettingsDifferFromPlace(parkingField, i, j);
				parkingField.setPreferredSize(parkingSpaceDimension);
				add(parkingField, new GBC(j, i));
				parkingFieldList.add(parkingField);
			}
		}
	}

	
	private static int parkingSpaceNumber = 1;
	private void setParkingFieldsSettingsDifferFromPlace(JButton parkingField, int i, int j) {
		if (selectingRoadFields(i, j)) {
			parkingField.setText(String.valueOf(parkingSpaceNumber));
			parkingField.setBorder(new LineBorder(Color.BLACK, 2, false));
			parkingSpaceNumber++;
			parkingField.setBackground(Color.GREEN);
			parkingField.addActionListener(parkingSpaceListener);
		} else {
			parkingField.setBackground(Color.GRAY);
			parkingField.setBorder(null);
		}

	}

	private boolean selectingRoadFields(int i, int j) {
		return (i == 0) || (i > 0 & (i+4) % 3/2 == 0 & j > 1);
	}
}

