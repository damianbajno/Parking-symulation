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

    private static final String THREAD_STATISTIC_BUTTON_TITLE = "Thread Statistic";

    private static final String NUMBER_THREAD_LOOPS_LABEL_TITLE = "Number Thread Loops:";

    public static int numberOfLoops = Constants.DEFAULT_NUMBER_LOOPS;

    private ParkingSpaceTransactionThread parkingSpaceTransactionThread = new ParkingSpaceTransactionThread();
    private JTextField numberLoopsTextField;

    private Integer threadNumberGenerator = 0;

    public JPanel createThreadButtonPanel() {

	JPanel threadButtonPanel = new JPanel();
	threadButtonPanel.setLayout(new GridLayout(10, 1, 30, 20));

	for (int i = 0; i < Constants.NUMBER_OF_THREAD_BUTTONS; i++) {
	    threadButtonPanel.add(createThreadButton());
	}

	JLabel numberThreadLoopsLabel = new JLabel(NUMBER_THREAD_LOOPS_LABEL_TITLE);
	numberLoopsTextField = new JTextField();
	numberLoopsTextField.setText(String
		.valueOf(Constants.DEFAULT_NUMBER_LOOPS));

	threadButtonPanel.add(numberThreadLoopsLabel);
	threadButtonPanel.add(numberLoopsTextField);
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
	JButton statisticButton = new JButton(THREAD_STATISTIC_BUTTON_TITLE);
	statisticButton.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {

	    }
	});
	return statisticButton;
    }

    public void actionPerformed(ActionEvent e) {
	ThreadButton buttonThread = (ThreadButton) e.getSource();
	numberOfLoops = Integer.parseInt(numberLoopsTextField.getText());
	buttonThread.setEnabled(false);
	parkingSpaceTransactionThread.startParkingSpaceThread(buttonThread);
    }

}
