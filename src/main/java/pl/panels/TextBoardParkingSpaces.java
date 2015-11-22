package pl.panels;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;

public class TextBoardParkingSpaces extends JPanel {
	private static TextBoardParkingSpaces textBoardParkingSpaces;
	private static JTextArea jTextArea=new JTextArea();
	
	public synchronized static TextBoardParkingSpaces getInstance() {
		if (textBoardParkingSpaces == null) {
			textBoardParkingSpaces = new TextBoardParkingSpaces();
			textBoardParkingSpaces.addJTextArea();
			return textBoardParkingSpaces;
		} else {
			return textBoardParkingSpaces;
		}

	}

	private TextBoardParkingSpaces() {
		jTextArea.setEditable(false);
		jTextArea.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
		jTextArea.setPreferredSize(Constants.ParkingManagerFrame_ParkingBorderPane);
		jTextArea.setAutoscrolls(true);
		jTextArea.setLineWrap(true);
		jTextArea.setBorder(BorderFactory.createTitledBorder(null,
				Names_PL.ParkingBoard_PARKING_BOARD,
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, 
				new Font(Font.SERIF, Font.PLAIN,17)));
		DefaultCaret defaultCaret= (DefaultCaret) jTextArea.getCaret();
		defaultCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

	private void addJTextArea(){
		textBoardParkingSpaces.add(jTextArea);
	}
	
	private AtomicInteger numberOfWritedLines=new AtomicInteger(5);
	public void append(String str) {
		jTextArea.setRows(numberOfWritedLines.incrementAndGet());
		setRows(numberOfWritedLines.get());
		final String str1=str;
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				jTextArea.append(str1);
				
			}
		});
	}

	public int getRows() {
		// TODO Auto-generated method stub
		return jTextArea.getRows();
	}

	public void setRows(int rows) {
		// TODO Auto-generated method stub
		jTextArea.setRows(rows);
	}

	
	
}
