package pl.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import pl.constantsandstrings.Constants;

public class ThreadTracePanel extends JPanel {

    private static ThreadTracePanel mainThreadTracePanel;
    private ThreadLocal<ThreadTraceNestedPanel> threadTracePanelNestedLocal = new ThreadLocal<ThreadTracePanel.ThreadTraceNestedPanel>();

    public static ThreadTracePanel getInstance() {
	if (mainThreadTracePanel == null)
	    synchronized (ThreadTracePanel.class) {
		if (mainThreadTracePanel == null)
		    mainThreadTracePanel = new ThreadTracePanel();
	    }
	return mainThreadTracePanel;
    }

    private ThreadTracePanel() {
    }

    private int numberOfThreadPanels=0;
    public void createNestedPanel(String threadName) {
	
	ThreadTraceNestedPanel threadTraceNestedPanel = new ThreadTraceNestedPanel(
		threadName);
	
	mainThreadTracePanel.setLayout(new GridLayout(++numberOfThreadPanels, 1));
	mainThreadTracePanel.add(threadTraceNestedPanel);
	mainThreadTracePanel.repaint();
	threadTracePanelNestedLocal.set(threadTraceNestedPanel);
    }

    public void setNumberOfTotalLoops(int numberOfTotalLoops) {
	threadTracePanelNestedLocal.get().threadTraceStatisticPanel
		.setNumberOfTotalLoops(numberOfTotalLoops);
    }

    public void setNumberOfLoopsMade(int numberOfLoopsMade) {
	threadTracePanelNestedLocal.get().threadTraceStatisticPanel
		.setNumberOfLoopsMade(numberOfLoopsMade);
    }

    public void append(String text) {
	if (threadTracePanelNestedLocal.get()!=null){
	    threadTracePanelNestedLocal.get().threadTraceTextPanel
		.append(text);
	}
    }
    
    public void refreshThreadStatus(){
	if (threadTracePanelNestedLocal.get()!=null){
	    threadTracePanelNestedLocal.get().threadTraceStatisticPanel.refreshstatus();
	}
    }
    
    // //Nested Class////

    private class ThreadTraceNestedPanel extends JPanel {

	ThreadTraceTextPanel threadTraceTextPanel = new ThreadTraceTextPanel();
	ThreadTraceStatisticPanel threadTraceStatisticPanel = new ThreadTraceStatisticPanel();

	public ThreadTraceNestedPanel(String threadName) {

	    setLayout(new BorderLayout());
	    setName(threadName);
	    setBorder(BorderFactory.createTitledBorder(threadName+" - "+getDateTime()));

	    add(threadTraceTextPanel, BorderLayout.WEST);
	    JPanel jPanel=new JPanel();
	    jPanel.add(threadTraceStatisticPanel, BorderLayout.NORTH);
	    add(jPanel, BorderLayout.CENTER);

	}
    
	private String getDateTime(){
		DateTime dateTime=new DateTime(DateTimeZone.getDefault());
		DateTimeFormatter dateTimeFormatter=DateTimeFormat.forPattern("HH:mm:ss");
		return String.format(dateTime.toString(dateTimeFormatter));
	    }
    
    }
    
    
    

}
