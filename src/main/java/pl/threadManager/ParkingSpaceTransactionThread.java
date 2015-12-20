package pl.threadManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import pl.constantsandstrings.Constants;
import pl.constantsandstrings.Names_PL;
import pl.panels.ParkingSpacesTextBoard;
import pl.panels.ThreadButton;
import pl.panels.ThreadButtonPanel;

public class ParkingSpaceTransactionThread {

    private ExecutorService parkingSpaceThreadPool = Executors
	    .newFixedThreadPool(Constants.NUMBER_OF_THREAD_IN_FIXED_THREAD_POOL);
    private ParkingSpacesTextBoard parkingSpacesTextBoard=ParkingSpacesTextBoard.getInstance();
    
    public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
	// ParkingSpaceTransaction parkingSpaceTransaction = new
	// ParkingSpaceTransaction(
	// threadButton);
	// parkingSpaceThreadPool.execute(parkingSpaceTransaction);
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
		
		parkingSpacesTextBoard.append(" Finished  "
			+ Thread.currentThread().getName() + "  Loops= "
			+ numberOfLoopsMade+"\n");
	    
	    } catch (Exception e) {
		
		e.getStackTrace();
		parkingSpacesTextBoard.append("Exeption "
			+ Thread.currentThread().getName() + "  Loops = "
			+ numberOfLoopsMade+"\n");
	    
	    } finally {
		threadButton.setEnabled(true);
	    }
	}

    }
}
