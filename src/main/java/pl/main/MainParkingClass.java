package pl.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import pl.constantsandstrings.Names_EN;
import pl.frame.ParkingManagerFrame;

public class MainParkingClass {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				ParkingManagerFrame parkingManagerFrame=new ParkingManagerFrame();
				parkingManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				parkingManagerFrame.setTitle(Names_EN.PARKINGMANAGER_TITLE_FRAME);
				parkingManagerFrame.pack();
				parkingManagerFrame.setVisible(true);
			}
		});
		
		
	}

}
