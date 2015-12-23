package pl.panel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.tools.GBC;

public class ThreadStatisticPanel extends JPanel {
    JLabel statisticTitleLabel=new JLabel("Thread Statistic");
    private String threadStatus;
    JLabel threadStatusLabel=new JLabel("Thread is  "+threadStatus);
    JLabel numberOfLoopsMadeLabel=new JLabel("Number of Loops Made ");
    JTextField numberOfLoopsMadeTextFiled=new JTextField(6);
    JLabel numberOfTotalLoopsLabel=new JLabel("Number of Total Loops ");
    JTextField numberOfTotalLoopsTextFiled=new JTextField(6);
    
    public ThreadStatisticPanel() {
	setLayout(new GridBagLayout());
	add(statisticTitleLabel, new GBC(0, 0).setInsets(5));
	
	add(threadStatusLabel, new GBC(0, 1).setAnchor(GBC.WEST));
	
	add(numberOfLoopsMadeLabel, new GBC(0, 2).setAnchor(GBC.WEST));
	numberOfLoopsMadeTextFiled.setEditable(false);
	add(numberOfLoopsMadeTextFiled, new GBC(1, 2).setAnchor(GBC.CENTER));
	
	add(numberOfTotalLoopsLabel, new GBC(0, 3).setAnchor(GBC.WEST));
	numberOfLoopsMadeTextFiled.setEditable(false);
	add(numberOfTotalLoopsTextFiled, new GBC(1, 3).setAnchor(GBC.CENTER));
    }
    
    
    public void threadStatisticActualization(){
	
    }
    
    
    
}
