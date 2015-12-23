package pl.threadmanager;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import pl.constantsandstrings.Constants;

public class ThreadTraceTextArea extends JTextArea {
    private int numberOfWritedLines = 5;
    private JTextArea jTextArea=this;
    
    public ThreadTraceTextArea() {
	caretPolicy();
	setPreferredSize(Constants.PARKING_BOARD_TEXT_AREA_DIMENSION);
    }
    
    private void caretPolicy() {
	DefaultCaret caret = (DefaultCaret) getCaret();
	caret.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT);
    }

    public void append(String text) {
	this.setRows(numberOfWritedLines);
	// logger.info(text);

	final String str1 = text;
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		jTextArea.append(str1);

	    }
	});
    }

}
