package pl.main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import pl.constantsandstrings.Names_EN;
import pl.frame.ParkingManagerFrame;
import pl.thread.ParkingManagerThread;

public class MainParkingClass {
	private static ParkingManagerThread parkingManager=new ParkingManagerThread();
	
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
		
		Thread parkingManagerThread=new Thread(parkingManager);
		parkingManagerThread.start();

	}

}
