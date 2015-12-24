package pl.threadmanager;

import pl.button.ParkingSpaceButton;
import pl.button.ParkingSpaceButtonList;
import pl.constantsandstrings.Names_PL;
import pl.dao.ParkingSpaceDAO;
import pl.panel.ParkingSpacesTextBoard;

public class ParkingSpaceTransaction {

    private String threadName = Thread.currentThread().getName();
    private ParkingSpaceButtonList parkingSpaceButtonList = ParkingSpaceButtonList
	    .getInstance();
    private ParkingSpacesTextBoard textBoardTransactions = ParkingSpacesTextBoard
	    .getInstance();
    private ParkingSpaceDAO parkingSpaceDAO = ParkingSpaceDAO.getInstance();

    int parkingSpaceNumber;

    public void changeParkingSpaceStatusByThread() {
	ParkingSpaceButton parkingSpaceButton = parkingSpaceButtonList
		.getRandomParkingSpace();
	if (parkingSpaceButton.isFree()) {
	    setParkingSpaceOccupy(parkingSpaceButton);
	} else {
	    setParkingSpaceFree(parkingSpaceButton);
	}
    }

    private int clientNumberOccupy;

    private void setParkingSpaceOccupy(ParkingSpaceButton parkingSpaceButton) {
	if ((clientNumberOccupy = parkingSpaceDAO
		.parkingSpaceMakeOccupy(parkingSpaceButton.getParkingNumber())) != 0) {
	    parkingSpaceButton.setOccupy();
	    printParkingSpaceOccupySentence(parkingSpaceButton);
	} else {
	    printParkingSpaceFailOccupySentence(parkingSpaceButton);
	}
	parkingSpaceButton.unLock();
    }

    private int clientNumberFree;

    private void setParkingSpaceFree(ParkingSpaceButton parkingSpaceButton) {
	if ((clientNumberFree = parkingSpaceDAO
		.parkingSpaceMakeFree(parkingSpaceButton.getParkingNumber())) != 0) {

	    parkingSpaceButton.setFree();
	    printParkingSpaceFreeSentence(parkingSpaceButton);
	} else {
	    printParkingSpaceFailFreeSentence(parkingSpaceButton);
	}
	parkingSpaceButton.unLock();
    }

    private void printParkingSpaceFreeSentence(
	    ParkingSpaceButton parkingSpaceButton) {
	textBoardTransactions
		.append(threadName
			+ "    "
			+ String.format(Names_PL.PARKING_SPACE_FREE_SENTENSE,
				parkingSpaceButton.getParkingNumber(),
				clientNumberFree));
    }

    private void printParkingSpaceFailFreeSentence(
	    ParkingSpaceButton parkingSpaceButton) {

	textBoardTransactions
		.append(" == FAIL == "
			+ threadName
			+ "    "
			+ String.format(Names_PL.PARKING_SPACE_FREE_SENTENSE,
				parkingSpaceButton.getParkingNumber(),
				clientNumberFree));

    }

    private void printParkingSpaceOccupySentence(
	    ParkingSpaceButton parkingSpaceButton) {
	textBoardTransactions.append(threadName
		+ "    "
		+ String.format(Names_PL.Parking_SPACE_OCCUPY_SENTENSE,
			parkingSpaceButton.getParkingNumber(),
			clientNumberOccupy));

    }

    private void printParkingSpaceFailOccupySentence(
	    ParkingSpaceButton parkingSpaceButton) {
	textBoardTransactions.append(" == FAIL ==  "
		+ threadName
		+ "    "
		+ String.format(Names_PL.Parking_SPACE_OCCUPY_SENTENSE,
			parkingSpaceButton.getParkingNumber(),
			clientNumberOccupy));
    }

}
