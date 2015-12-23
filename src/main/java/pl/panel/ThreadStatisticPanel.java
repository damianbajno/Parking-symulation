package pl.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreadStatisticPanel extends JPanel {
    JLabel statisticTitleLabel=new JLabel("Thread Statistic");
    private String threadStatus;
    JLabel threadStatusLabel=new JLabel("Thread is"+threadStatus);
    JLabel numberOfLoopsMadeLabel=new JLabel("Number of Loops Made ");
    JTextField numberOfLoopsMadeTextFiled=new JTextField(6);
    JLabel numberOfTotalLoopsLabel=new JLabel("Number of Total Loops ");
    JTextField numberOfTotalLoopsTextFiled=new JTextField(6);
    
    public ThreadStatisticPanel() {
	add(statisticTitleLabel);
	
	add(threadStatusLabel);
	
	add(numberOfLoopsMadeLabel);
	add(numberOfLoopsMadeTextFiled);
	
	add(numberOfTotalLoopsLabel);
	add(numberOfTotalLoopsTextFiled);
    }
    
}
