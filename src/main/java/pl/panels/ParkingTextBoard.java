package pl.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_EN;

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
		setFont(new Font(Font.SERIF, Font.PLAIN, 7));
		setPreferredSize(Constants.ParkingBoard_DIMENSION);
		setBorder(BorderFactory
				.createTitledBorder(Names_EN.ParkingBoard_PARKING_BOARD));
	}

}
