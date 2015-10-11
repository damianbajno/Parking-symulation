package pl.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pl.constantsandstrings.Names_PL;
import pl.panels.ParkingSpaceButton;

public class CreateOrChooseClientFrame extends JFrame implements ActionListener {
	private String[] frameTitle = { "Wybierz istniejącego klienta",
			"Stwórz nowego klienta" };
	
	public CreateOrChooseClientFrame() {
		setLayout(new GridLayout(2, 1));
		createButtons();
		defaultSettings();
	}

	public void defaultSettings() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setTitle(Names_PL.ClientOrNewClientFrame_TITLE_FRAME);
	}

	private void createButtons() {
		for (int i = 0; i < frameTitle.length; i++) {
			createButton(frameTitle[i]);
		}
	}

	public void createButton(String text) {
		JButton button = new JButton(text);
		button.setActionCommand(text);
		button.addActionListener(this);
		add(button);
	}

	private ChooseClientFrame chooseClientFrame;
	private CreateClientFrame createClientFrame;

	public void actionPerformed(ActionEvent e) {
		String titleFrameFromButton = e.getActionCommand();
		if (titleFrameFromButton == frameTitle[0]) {
			chooseClientFrame = new ChooseClientFrame();
			this.dispose();
		} else {
			createClientFrame = new CreateClientFrame();
			this.dispose();
		}
	}
}
