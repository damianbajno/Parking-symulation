package pl.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;
import pl.panels.ParkingButtonPanel;
import pl.panels.TextBoardParkingSpaces;
import pl.panels.ThreadButtonPanel;

public class ParkingManagerFrame extends JFrame {
	JPanel parkingManagerPanel=new JPanel(new BorderLayout());
	

	public ParkingManagerFrame() {
		createParking();
		createParkingTextBorder();
		createThreadButtonsPanel();
		JScrollPane parkingManagerScrollPane=new JScrollPane(parkingManagerPanel);
		add(parkingManagerScrollPane);
		defaultSettings();
	}

	private void defaultSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Names_PL.PARKINGMANAGER_TITLE_FRAME);
		setMinimumSize(new Dimension(600, 600));
		pack();
		setVisible(true);
	}

	public void createParkingTextBorder() {
		TextBoardParkingSpaces textBoardParkingSpaces = TextBoardParkingSpaces.getInstance();
		JScrollPane parkingBoardPane = new JScrollPane(textBoardParkingSpaces);
		parkingBoardPane.setPreferredSize(Constants.ParkingManagerFrame_ParkingBorderPane);
		parkingBoardPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		parkingManagerPanel.add(parkingBoardPane, BorderLayout.WEST);
	}
	
	public void createParking() {
		ParkingButtonPanel parkingButtonPanel = new ParkingButtonPanel();
		parkingManagerPanel.add(parkingButtonPanel, BorderLayout.CENTER);
	}

	public void createThreadButtonsPanel(){
		ThreadButtonPanel threadButtonPanel = new ThreadButtonPanel();
		JPanel threadButtonPanel1 = threadButtonPanel.createThreadButtonPanel();
		parkingManagerPanel.add(threadButtonPanel1, BorderLayout.EAST);
	}
	
	
}
