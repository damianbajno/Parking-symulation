package pl.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;
import pl.panel.ParkingButtonPanel;
import pl.panel.ParkingSpacesTextBoard;
import pl.panel.ThreadButtonPanel;
import pl.threadmanager.ThreadTracePanel;

public class ParkingFrame extends JFrame {
	private JTabbedPane parkingManagerPanel=new JTabbedPane();
	
	public ParkingFrame() {
	    	createTextBoardAndThreadButtons();
		createParking();
		createThreadStatistic();
		defaultSettings();
	}

	private void defaultSettings() {
		add(parkingManagerPanel);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Names_PL.PARKING_TITLE_FRAME);
		pack();
		setVisible(true);
	}

	public void createParking() {
		ParkingButtonPanel parkingButtonPanel = new ParkingButtonPanel();
		parkingManagerPanel.addTab("Parking Visualization",parkingButtonPanel);
	}
	
		JPanel threadButtonsAndBoard;
	
	public void createTextBoardAndThreadButtons(){
	    	threadButtonsAndBoard=new JPanel(new BorderLayout());
	    	createParkingTextBoard();
	    	createThreadButtonsPanel();
	    	parkingManagerPanel.addTab("Thread Manager", threadButtonsAndBoard);
	}
	
	public void createParkingTextBoard() {
		ParkingSpacesTextBoard parkingSpacesTextBoard = ParkingSpacesTextBoard.getInstance();
		JScrollPane parkingBoardPane = new JScrollPane(parkingSpacesTextBoard);
		parkingBoardPane.setPreferredSize(Constants.PARKING_BOARD_DIMENSION);
		parkingBoardPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		threadButtonsAndBoard.add(parkingBoardPane, BorderLayout.WEST);
	}
	
	public void createThreadButtonsPanel(){
		ThreadButtonPanel threadButtonPanel = new ThreadButtonPanel();
		JPanel threadButtonPanel1 = threadButtonPanel.createThreadButtonPanel();
		threadButtonsAndBoard.add(threadButtonPanel1, BorderLayout.EAST);
	}

	public void createThreadStatistic(){
	    ThreadTracePanel threadTracePanel=new ThreadTracePanel();
	    
	    parkingManagerPanel.addTab("Thread Statistic", threadTracePanel);
	}
	
}
