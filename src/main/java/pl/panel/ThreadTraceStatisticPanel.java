package pl.panel;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.constantsandstrings.Constants;
import pl.tools.GBC;

public class ThreadTraceStatisticPanel extends JPanel  {
    
    private Thread.State threadStatus=Thread.currentThread().getState();
    
    private JLabel statisticTitleLabel = new JLabel("Thread Statistic");
    private JLabel threadStatusLabel = new JLabel("Thread is   " + threadStatus);
    
    private JLabel numberOfLoopsMadeLabel = new JLabel("Loops Made ");
    private JTextField numberOfLoopsMadeTextFiled = new JTextField(6);
    
    private JLabel numberOfTotalLoopsLabel = new JLabel("Total Loops ");
    private JTextField numberOfTotalLoopsTextFiled = new JTextField(6);

    public ThreadTraceStatisticPanel() {

	setLayout(new GridBagLayout());
	add(statisticTitleLabel, new GBC(0, 0).setInsets(2, 0, 2, 0));

	add(threadStatusLabel, new GBC(0, 1).setAnchor(GBC.WEST).setInsets(2, 0, 2, 0));

	add(numberOfLoopsMadeLabel, new GBC(0, 2).setAnchor(GBC.WEST));
	numberOfLoopsMadeTextFiled.setEditable(false);
	add(numberOfLoopsMadeTextFiled, new GBC(1, 2).setAnchor(GBC.CENTER));

	add(numberOfTotalLoopsLabel, new GBC(0, 3).setAnchor(GBC.WEST));
	numberOfTotalLoopsTextFiled.setEditable(false);
	add(numberOfTotalLoopsTextFiled, new GBC(1, 3).setAnchor(GBC.CENTER));

	setPreferredSize(new Dimension(
		Constants.THREAD_BUTTON_PANEL_DIMENSION.width+50,
		Constants.PARKING_BOARD_TEXT_AREA_DIMENSION.height / 2));

    }

    public void setNumberOfLoopsMade(int numberOfLoopsMade) {
        this.numberOfLoopsMadeTextFiled.setText(String.valueOf(numberOfLoopsMade));
    }

    public void setNumberOfTotalLoops(int numberOfTotalLoops) {
        this.numberOfTotalLoopsTextFiled.setText(String.valueOf(numberOfTotalLoops)) ;
    }

    public void refreshstatus(){
	this.threadStatus=Thread.currentThread().getState();
    }

}
