package pl.threadmanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;
import pl.panel.ParkingSpacesTextBoard;
import pl.panel.ThreadButton;
import pl.panel.ThreadButtonPanel;

public class ParkingSpaceTransactionThread {

    private ParkingSpacesTextBoard parkingSpacesTextBoard=ParkingSpacesTextBoard.getInstance();
    
    public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
	ParkingSpaceThread parkingSpaceThread = new ParkingSpaceThread(
		threadButton);
	parkingSpaceThread.start();

    }

    // //// NESTED CLASS /////

    private class ParkingSpaceThread extends Thread {
	private ThreadButton threadButton;

	public ParkingSpaceThread(ThreadButton threadButton) {
	    super();
	    this.threadButton = threadButton;
	    this.setName(threadButton.getName());
	}

	public void run() {
	    
	    int numberOfLoopsMade = 0;
	    int numberOfLoopsToMake = ThreadButtonPanel.numberOfLoops;
	    ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction();

	    try {

		parkingSpacesTextBoard.append(this.getName()+" Start \n");
		for (int i = 0; i < numberOfLoopsToMake; i++) {
		    parkingSpaceTransaction.changeParkingSpaceStatusByThread();
		    numberOfLoopsMade++;
		}
		
		printFinishedSentences(numberOfLoopsMade);
	    
	    } catch (Exception e) {
		
		e.getStackTrace();
		printExceptionSentence(numberOfLoopsMade);
	    
	    } finally {
		threadButton.setEnabled(true);
	    }
	}

	private void printExceptionSentence(int numberOfLoopsMade) {
	    parkingSpacesTextBoard.append("Exeption "
	    	+ Thread.currentThread().getName() + "  Loops = "
	    	+ numberOfLoopsMade+"\n");
	}

	private void printFinishedSentences(int numberOfLoopsMade) {
	    parkingSpacesTextBoard.append(" Finished  "
	    	+ Thread.currentThread().getName() + "  Loops= "
	    	+ numberOfLoopsMade+"\n");
	}

    }
}
