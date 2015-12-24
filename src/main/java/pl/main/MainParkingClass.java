package pl.main;

import java.awt.EventQueue;

import pl.frame.MainParkingFrame;

public class MainParkingClass {

    public static void main(String[] args) {
	    
//	    final ConfigurableApplicationContext applicationContext=new ClassPathXmlApplicationContext("Configuration1.xml");
	    EventQueue.invokeLater(new Runnable() {
			
			public void run() {
			    	MainParkingFrame mainParkingFrame=new MainParkingFrame();
//				ThreadManagerFrame threadManagerFrame=new ThreadManagerFrame();
			}
		});
		
//		Thread threadTest=new Thread(new ThreadTest());
//		threadTest.start();
	
//	    applicationContext.close();
	}
    
    
}
