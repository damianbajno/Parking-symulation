package pl.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import pl.button.ParkingSpaceButton;
import pl.constantsandstrings.Names_PL;

public class CreateOrChooseClientFrame extends JFrame implements ActionListener {

    private final String[] FRAME_TITLE = { "Wybierz istniejącego klienta",
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
		setTitle(Names_PL.CLIENT_OR_NEW_CLIENT_FRAME_TITLE_FRAME);
	}

	private void createButtons() {
		for (int i = 0; i < FRAME_TITLE.length; i++) {
			createButton(FRAME_TITLE[i]);
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
		if (titleFrameFromButton == FRAME_TITLE[0]) {
			chooseClientFrame = new ChooseClientFrame();
			this.dispose();
		} else {
			createClientFrame = new CreateClientFrame();
			this.dispose();
		}
	}
}
