package pl.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;

public class ParkingTextBoard extends JTextArea {
	private static ParkingTextBoard parkingTextBoard;

	public static ParkingTextBoard getInstance() {
		if (parkingTextBoard == null) {
			parkingTextBoard = new ParkingTextBoard();
			return parkingTextBoard;
		} else {
			return parkingTextBoard;
		}

	}

	public ParkingTextBoard() {

		setEditable(false);
		setFont(new Font(Font.SERIF, Font.PLAIN, 12));
		setPreferredSize(Constants.ParkingBoard_DIMENSION);
		setAutoscrolls(true);
		setLineWrap(true);
		setBorder(BorderFactory.createTitledBorder(null,
				Names_PL.ParkingBoard_PARKING_BOARD,
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, 
				new Font(Font.SERIF, Font.PLAIN,17)));
		DefaultCaret defaultCaret= (DefaultCaret) getCaret();
		defaultCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

	
	int numberOfWritedLines=5;
	@Override
	public void append(String str) {
		numberOfWritedLines++;
		setRows(numberOfWritedLines);
		super.append(str);
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return super.getRows();
	}

	@Override
	public void setRows(int rows) {
		// TODO Auto-generated method stub
		super.setRows(rows);
	}

	
	
}
