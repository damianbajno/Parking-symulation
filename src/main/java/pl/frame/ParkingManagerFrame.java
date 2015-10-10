package pl.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_EN;
import pl.panels.ParkingButtonPanel;
import pl.panels.ParkingTextBoard;

public class ParkingManagerFrame extends JFrame {

	

	public ParkingManagerFrame() {

		setLayout(new BorderLayout());
		createParking();
		createParkingTextBorder();
		defaultSettings();
	}

	private void defaultSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Names_EN.PARKINGMANAGER_TITLE_FRAME);
		pack();
		setVisible(true);
	}

	public void createParking() {
		ParkingButtonPanel parkingButtonPanel = new ParkingButtonPanel();
		JScrollPane parkingScrollPane = new JScrollPane(parkingButtonPanel);
		add(parkingScrollPane, BorderLayout.EAST);
	}

	public void createParkingTextBorder() {
		ParkingTextBoard parkingTextBoard = ParkingTextBoard.getInstance();
		JScrollPane parkingBoardPane = new JScrollPane(parkingTextBoard);
		parkingBoardPane.setPreferredSize(Constants.ParkingManagerFrame_ParkingBorderPane);
		parkingBoardPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(parkingBoardPane, BorderLayout.CENTER);
	}

}
