package pl.threadmanager;

import pl.button.ThreadButton;
import pl.panel.ParkingSpacesTextBoard;
import pl.panel.ThreadButtonPanel;
import pl.panel.ThreadTracePanel;

public class ParkingSpaceTransactionThread {

    private ParkingSpacesTextBoard parkingSpacesTextBoard = ParkingSpacesTextBoard
	    .getInstance();
    private ThreadTracePanel threadTracePanel = ThreadTracePanel.getInstance();

    public synchronized void startParkingSpaceThread(ThreadButton threadButton) {
	ParkingSpaceThread parkingSpaceThread = new ParkingSpaceThread(
		threadButton);
	parkingSpaceThread.start();
    }

    // //// NESTED CLASS /////

    private class ParkingSpaceThread extends Thread {

	private ThreadButton threadButton;

	public ParkingSpaceThread(ThreadButton threadButton) {
	    super(threadButton.getName());
	    this.threadButton = threadButton;
	}

	public void run() {
	    ParkingSpaceTransaction parkingSpaceTransaction = new ParkingSpaceTransaction();

	    int loopsMade = 0;
	    int numberOfTotalLoops = ThreadButtonPanel.numberOfLoops;

	    threadTracePanel.createNestedPanel(threadButton.getName());
	    threadTracePanel.setNumberOfTotalLoops(numberOfTotalLoops);

	    try {

		parkingSpacesTextBoard.append(this.getName() + " Start \n");

		for (int i = 0; i < numberOfTotalLoops; i++) {

		    loopsMade++;
		    nextTransaction(loopsMade);
		    parkingSpaceTransaction.changeParkingSpaceStatusByThread();

		    if (i % 10 == 0)
			threadTracePanel.setNumberOfLoopsMade(loopsMade);

		}

		threadTracePanel.setNumberOfLoopsMade(loopsMade);
		printFinishedSentences(loopsMade);

	    } catch (Exception e) {

		e.getStackTrace();
		printExceptionSentence(loopsMade);

	    } finally {
		threadButton.setEnabled(true);

	    }
	}

	private void nextTransaction(int number) {
	    threadTracePanel.append("\n  === New Transaction = " + number
		    + " === \n");
	}

	private void printExceptionSentence(int numberOfLoopsMade) {
	    parkingSpacesTextBoard.append("Exeption "
		    + Thread.currentThread().getName() + "  Loops = "
		    + numberOfLoopsMade + "\n");
	}

	private void printFinishedSentences(int numberOfLoopsMade) {
	    parkingSpacesTextBoard.append(" Finished  "
		    + Thread.currentThread().getName() + "  Loops= "
		    + numberOfLoopsMade + "\n");
	}

    }
}
