package pl.panel;

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

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.button.ThreadButton;
import pl.constantsandstrings.Constants;
import pl.threadmanager.ParkingSpaceTransactionThread;

public class ThreadButtonPanel implements ActionListener {
    private Integer threadNumberGenerator = 0;
    private ParkingSpaceTransactionThread parkingSpaceTransactionThread = new ParkingSpaceTransactionThread();
    public static int numberOfLoops = Constants.DEFAULT_NUMBER_LOOPS;

    private JTextField numberThreadLoopsField;

    public JPanel createThreadButtonPanel() {

	JPanel threadButtonPanel = new JPanel();
	threadButtonPanel.setLayout(new GridLayout(10, 1, 30, 20));

	for (int i = 0; i < Constants.NUMBER_OF_THREAD_BUTTONS; i++) {
	    threadButtonPanel.add(createThreadButton());
	}

	JLabel numberThreadLoopsLabel = new JLabel("Number Thread Loops:");
	numberThreadLoopsField = new JTextField();
	numberThreadLoopsField.setText(String
		.valueOf(Constants.DEFAULT_NUMBER_LOOPS));

	threadButtonPanel.add(numberThreadLoopsLabel);
	threadButtonPanel.add(numberThreadLoopsField);
	threadButtonPanel
		.setPreferredSize(Constants.THREAD_BUTTON_PANEL_DIMENSION);

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

    public JButton createStatisticButton() {
	JButton statisticButton = new JButton("Thread Stattistic");
	statisticButton.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {

	    }
	});
	return statisticButton;
    }

    public void actionPerformed(ActionEvent e) {
	ThreadButton buttonThread = (ThreadButton) e.getSource();
	numberOfLoops = Integer.parseInt(numberThreadLoopsField.getText());
	buttonThread.setEnabled(false);
	parkingSpaceTransactionThread.startParkingSpaceThread(buttonThread);
    }

}
