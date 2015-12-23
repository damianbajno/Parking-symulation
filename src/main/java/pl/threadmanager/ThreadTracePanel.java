package pl.threadmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import pl.panel.ThreadStatisticPanel;

public class ThreadTracePanel extends JPanel {

    private String threadName;

    public ThreadTracePanel() {
	
//	setBorder(BorderFactory.createTitledBorder(threadName));
	setLayout(new BorderLayout());
	createStatistic();
    }

    public void createStatistic(){
	ThreadTraceTextArea threadTraceTextArea=new ThreadTraceTextArea();
	ThreadStatisticPanel threadStatisticPanel=new ThreadStatisticPanel();
	
	add(threadTraceTextArea, BorderLayout.WEST);
	add(threadStatisticPanel, BorderLayout.EAST);
	
    }
    
    public String getThreadName() {
	return threadName;
    }

    public void setThreadName(String threadName) {
	this.threadName = threadName;
    }
}
