package pl.threadManager;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;

public class ThreadManagerFrame extends JFrame {

	public ThreadManagerFrame() {
		defaultSettings();

	}

	public void createCardPanel() {
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());

		for (int i = 0; i < Constants.numberOfThread; i++) {

			ThreadCardPanel threadCardPanel = new ThreadCardPanel();
			cardPanel.add(threadCardPanel, i);

		}
	}

	
	private void defaultSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Names_PL.threadManagerFrame_THREAD_MANAGER);
		pack();
		setVisible(true);
	}


}
