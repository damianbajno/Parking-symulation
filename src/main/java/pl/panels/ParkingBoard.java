package pl.panels;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_EN;

public class ParkingBoard extends JTextArea {
	ParkingBoard parkingBoard;
	
	public ParkingBoard getInstance(){
	if (parkingBoard==null)
	{
		parkingBoard=new ParkingBoard();
		return parkingBoard;
	} else {
		return parkingBoard;
	}
	
	}
	
	public ParkingBoard() {
		
		setEditable(false);
		setFont(new Font(Font.SERIF, Font.PLAIN, 15));
		setPreferredSize(Constants.ParkingBoard_DIMENSION);
		setBorder(BorderFactory.createTitledBorder(Names_EN.ParkingBoard_PARKING_BOARD));
	}

}
