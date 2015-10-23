package pl.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pl.thread.ParkingSpaceTransactionThread;

public class ThreadButtonPanel implements ActionListener {
	private static Integer threadNumberGenerator=0;
	ParkingSpaceTransactionThread parkingSpaceTransactionThread = new ParkingSpaceTransactionThread();
	private JPanel threadButtonPanel;
	
	public ThreadButtonPanel() {

	}

	public JButton createThreadButton(){
		threadNumberGenerator++;
		JButton buttonThread=new JButton("Thread nr. "+threadNumberGenerator);
		buttonThread.setActionCommand(threadNumberGenerator.toString());
		buttonThread.addActionListener(this);
		
		
		return buttonThread;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
}
