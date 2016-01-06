package pl.main;

import java.awt.EventQueue;

import pl.frame.MainParkingFrame;

public class MainParkingClass {

    public static void main(String[] args) {

	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		MainParkingFrame mainParkingFrame = new MainParkingFrame();
	    }
	});

    }

}
