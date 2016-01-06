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
import pl.panel.ThreadTracePanel;

public class MainParkingFrame extends JFrame {

    private static final String PARKING_VISUALIZATION_TAB_TITLE = "Parking Visualization";
    private static final String THREAD_MANAGER_TAB_TITLE = "Thread Manager";
    private static final String THREAD_STATISTIC_TAB_TITLE = "Thread Statistic";
    private JTabbedPane parkingManagerPanel = new JTabbedPane();

    public MainParkingFrame() {
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
	parkingManagerPanel.addTab(PARKING_VISUALIZATION_TAB_TITLE, parkingButtonPanel);
    }

    
    private JPanel threadButtonsAndBoard;

    public void createTextBoardAndThreadButtons() {
	threadButtonsAndBoard = new JPanel(new BorderLayout());
	createParkingTextBoard();
	createThreadButtonsPanel();
	parkingManagerPanel.addTab(THREAD_MANAGER_TAB_TITLE, threadButtonsAndBoard);
    }

    public void createParkingTextBoard() {
	ParkingSpacesTextBoard parkingSpacesTextBoard = ParkingSpacesTextBoard
		.getInstance();
	JScrollPane parkingBoardPane = new JScrollPane(parkingSpacesTextBoard);
	parkingBoardPane.setPreferredSize(Constants.PARKING_BOARD_DIMENSION);
	parkingBoardPane
		.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	threadButtonsAndBoard.add(parkingBoardPane, BorderLayout.WEST);
    }

    public void createThreadButtonsPanel() {
	ThreadButtonPanel threadButtonPanel = new ThreadButtonPanel();
	JPanel threadButtonPanel1 = threadButtonPanel.createThreadButtonPanel();
	threadButtonsAndBoard.add(threadButtonPanel1, BorderLayout.EAST);
    }

    public void createThreadStatistic() {
	ThreadTracePanel threadTracePanel = ThreadTracePanel.getInstance();
	JScrollPane threadTraceScrollPanel = new JScrollPane(threadTracePanel);
	parkingManagerPanel.addTab(THREAD_STATISTIC_TAB_TITLE, threadTraceScrollPanel);
    }

}
