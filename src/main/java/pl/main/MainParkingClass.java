package pl.main;

import java.awt.EventQueue;

import pl.frame.ParkingManagerFrame;
import pl.threadManager.ThreadManagerFrame;
import pl.tools.ThreadTest;

public class MainParkingClass {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				ParkingManagerFrame parkingManagerFrame=new ParkingManagerFrame();
//				ThreadManagerFrame threadManagerFrame=new ThreadManagerFrame();
			}
		});
		
//		Thread threadTest=new Thread(new ThreadTest());
//		threadTest.start();
		
	}

}
