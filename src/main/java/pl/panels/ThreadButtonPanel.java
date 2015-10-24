package pl.panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.constantsandstrings.Constants;
import pl.thread.ParkingSpaceTransactionThread;

public class ThreadButtonPanel implements ActionListener {
	private Integer threadNumberGenerator = 0;
	private ParkingSpaceTransactionThread parkingSpaceTransactionThread = new ParkingSpaceTransactionThread();
	private JPanel threadButtonPanel;
	public static int numberOfLoops = Constants.defoultNumberLoops;

	public ThreadButtonPanel() {

	}

	private JTextField numberThreadLoopsField;

	public JPanel createThreadButtonPanel() {
		JPanel threadButtonPanel = new JPanel();
		threadButtonPanel.setLayout(new GridLayout(10, 1, 30, 20));
		for (int i = 0; i < Constants.numberOfThreadButtons; i++) {
			threadButtonPanel.add(createThreadButton());
		}

		JLabel numberThreadLoopsLabel = new JLabel("Number Thread Loops:");
		numberThreadLoopsField = new JTextField();

		numberThreadLoopsField.setText(String
				.valueOf(Constants.defoultNumberLoops));

		threadButtonPanel.add(numberThreadLoopsLabel);
		threadButtonPanel.add(numberThreadLoopsField);
		return threadButtonPanel;
	}

	public JButton createThreadButton() {
		threadNumberGenerator++;
		ThreadButton buttonThread = new ThreadButton("Thread nr. "
				+ threadNumberGenerator);
		buttonThread.setName("Thread - " + threadNumberGenerator);
		buttonThread.setActionCommand(threadNumberGenerator.toString());
		buttonThread.addActionListener(this);
		return buttonThread;

	}

	public void actionPerformed(ActionEvent e) {
		ThreadButton buttonThread = (ThreadButton) e.getSource();
		System.out.println("Start Running =" + buttonThread.getText());
		numberOfLoops = Integer.parseInt(numberThreadLoopsField.getText());
		buttonThread.setEnabled(false);
		parkingSpaceTransactionThread.startParkingSpaceThread(buttonThread);
	}

}
