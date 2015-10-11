package pl.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import pl.constantsandstrings.Names_PL;
import pl.frame.ParkingManagerFrame;

public class MainParkingClass {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				ParkingManagerFrame parkingManagerFrame=new ParkingManagerFrame();
			}
		});
		
		
	}

}
