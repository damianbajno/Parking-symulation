package pl.panel;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import pl.constantsandstrings.Constants;

public class ThreadTraceTextPanel extends JPanel {
    private int numberOfWritedLines = 5;
    private JTextArea jTextArea = new JTextArea();

    public ThreadTraceTextPanel() {
	caretPolicy();
	jTextArea.setPreferredSize(new Dimension(
		Constants.PARKING_BOARD_TEXT_AREA_DIMENSION.width-50,
		Constants.PARKING_BOARD_TEXT_AREA_DIMENSION.height / 2));
	jTextArea.setLineWrap(true);
	
	JScrollPane jScrollPane=new JScrollPane(jTextArea);
	jScrollPane.setPreferredSize(new Dimension(
		Constants.PARKING_BOARD_TEXT_AREA_DIMENSION.width-50,
		Constants.PARKING_BOARD_TEXT_AREA_DIMENSION.height / 2));
	add(jScrollPane);
	
    }

    private void caretPolicy() {
	DefaultCaret caret = (DefaultCaret) jTextArea.getCaret();
	caret.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT);
    }

    public void append(String text) {
	jTextArea.setRows(jTextArea.getLineCount()+5);
	
	final String str1 = text;
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		jTextArea.append(str1);
		jTextArea.append("\n");
	    }
	});
    }

}
