package pl.panels;

import java.awt.Dimension;

import javax.swing.JButton;

public class ThreadButton extends JButton {
	String threadState = Thread.State.NEW.toString();

	public ThreadButton(String text) {
		super(text);
		setPreferredSize(new Dimension(30,50));
	}

	public void changeState(Thread.State state) {
		String buttonText = this.getText();
		String replacedButtonText=null;
		for (Thread.State state1 : Thread.State.values()) {
			if (buttonText.contains(state1.toString())) {
				replacedButtonText = buttonText.replace(state1.toString(),
						state.toString());
			}
		}
		this.setText(replacedButtonText);
	}

}
