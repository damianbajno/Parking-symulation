package pl.threadManager;

import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class ThreadTextBoard extends JTextArea {

	public ThreadTextBoard() {
		caretPolicy();
		
	}

	/**
	 * 
	 */
	private void caretPolicy() {
		DefaultCaret caret = (DefaultCaret) getCaret();
		caret.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT);
	}

}
