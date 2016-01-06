package pl.threadmanager;

import pl.button.ParkingSpaceButton;
import pl.button.ParkingSpaceButtonList;
import pl.constantsandstrings.Names_PL;
import pl.dao.ParkingSpaceDAO;
import pl.panel.ParkingSpacesTextBoard;

public class ParkingSpaceTransaction {

    private ParkingSpaceButtonList parkingSpaceButtonList = ParkingSpaceButtonList
	    .getInstance();
    private ParkingSpacesTextBoard textBoardTransactions = ParkingSpacesTextBoard
	    .getInstance();
    private ParkingSpaceDAO parkingSpaceDAO = ParkingSpaceDAO.getInstance();

    private String threadName = Thread.currentThread().getName();

    private int parkingSpaceNumber;

    public void changeParkingSpaceStatusByThread() {
	ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
		.getRandomParkingSpace();
	if (parkingSpaceButton.isFree()) {
	    setParkingSpaceOccupy(parkingSpaceButton);
	} else {
	    setParkingSpaceFree(parkingSpaceButton);
	}
    }

    private void setParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton) {
	int clientNumberOccupy;

	if ((clientNumberOccupy = parkingSpaceDAO
		.parkingSpaceMakeOccupy(parkingSpaceButton.getParkingNumber())) != 0) {

	    parkingSpaceButton.setOccupy();
	    printParkingSpaceOccupySentence(parkingSpaceButton,
		    clientNumberOccupy);

	} else {
	    printParkingSpaceFailOccupySentence(parkingSpaceButton,
		    clientNumberOccupy);
	}
	parkingSpaceButton.unLock();
    }

    private void setParkingSpaceFree(ParkingSpaceButton parkingSpaceButton) {
	int clientNumberFree;

	if ((clientNumberFree = parkingSpaceDAO
		.parkingSpaceMakeFree(parkingSpaceButton.getParkingNumber())) != 0) {

	    parkingSpaceButton.setFree();
	    printParkingSpaceFreeSentence(parkingSpaceButton, clientNumberFree);

	} else {
	    printParkingSpaceFailFreeSentence(parkingSpaceButton,
		    clientNumberFree);
	}
	parkingSpaceButton.unLock();
    }

    private void printParkingSpaceFreeSentence(
	    ParkingSpaceButton parkingSpaceButton, int clientNumberFree) {
	textBoardTransactions
		.append(threadName
			+ "    "
			+ String.format(Names_PL.PARKING_SPACE_FREE_SENTENSE,
				parkingSpaceButton.getParkingNumber(),
				clientNumberFree));
    }

    private void printParkingSpaceFailFreeSentence(
	    ParkingSpaceButton parkingSpaceButton, int clientNumberFree) {

	textBoardTransactions
		.append(" == FAIL == "
			+ threadName
			+ "    "
			+ String.format(Names_PL.PARKING_SPACE_FREE_SENTENSE,
				parkingSpaceButton.getParkingNumber(),
				clientNumberFree));

    }

    private void printParkingSpaceOccupySentence(
	    ParkingSpaceButton parkingSpaceButton, int clientNumberOccupy) {
	textBoardTransactions.append(threadName
		+ "    "
		+ String.format(Names_PL.Parking_SPACE_OCCUPY_SENTENSE,
			parkingSpaceButton.getParkingNumber(),
			clientNumberOccupy));

    }

    private void printParkingSpaceFailOccupySentence(
	    ParkingSpaceButton parkingSpaceButton, int clientNumberOccupy) {
	textBoardTransactions.append(" == FAIL ==  "
		+ threadName
		+ "    "
		+ String.format(Names_PL.Parking_SPACE_OCCUPY_SENTENSE,
			parkingSpaceButton.getParkingNumber(),
			clientNumberOccupy));
    }

}
