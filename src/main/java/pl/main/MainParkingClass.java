package pl.main;

import java.awt.EventQueue;

import pl.frame.ParkingFrame;

public class MainParkingClass {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				ParkingFrame parkingFrame=new ParkingFrame();
//				ThreadManagerFrame threadManagerFrame=new ThreadManagerFrame();
			}
		});
		
//		Thread threadTest=new Thread(new ThreadTest());
//		threadTest.start();
		
	}

}
