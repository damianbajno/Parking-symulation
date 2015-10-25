package pl.test;

import java.util.Random;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.managers.ParkingSpaceManager;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class TestParkingSpaceThread implements Runnable {
	Random random = new Random();
	private int threadNumberGenerator = 1;
	private ParkingSpaceManager parkingSpaceManager = new ParkingSpaceManager();

	public TestParkingSpaceThread() {
	}

	public void run() {
		int threadNumber = threadNumberGenerator;
		threadNumberGenerator++;
		
		 connectClientSpecifityToParkingSpace(threadNumber);
		 getParkingSpaceFromClient();
		// for (int i = 0; i < 20; i++) {
		// connectClientToParkingSpace(i, threadNumber);

		// }

	}

	/**
	 * 
	 */
	int clientNumber;
	public void getParkingSpaceFromClient() {
//		sleep(10000);
		System.out.println(" ----- [[[ ]]]-----------");
		Client client = ClientDAO.get(clientNumber);
		System.out.println("Wątek nr " + " = " + client.getId()
				+ " is client reserved " + client.reservedParkingSpace());
		ParkingSpace parkingSpace = client.getParkingSpace();
		System.out.println(parkingSpace.toString());
	}

	private synchronized void connectClientSpecifityToParkingSpace(
			int threadNumber) {
		Client clientWithOutParkingSpace = parkingSpaceManager
				.getClientWithOutParkingSpace();
		clientNumber = clientWithOutParkingSpace.getId();
		System.out.println("Wątek nr " + threadNumber + " = "
				+ clientWithOutParkingSpace.getId() + " is client reserved "
				+ clientWithOutParkingSpace.reservedParkingSpace());
		ParkingSpace parkingSpace = ParkingSpaceDAO.get(50);
		ParkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpace,
				clientWithOutParkingSpace);
		System.out.println("  R  Wątek nr " + threadNumber + " Client = "
				+ clientWithOutParkingSpace.getId()
				+ " reservd parkingSpace = " + parkingSpace.getParkingNumber());
		Client client = ClientDAO.get(clientNumber);
		System.out.println("Wątek nr " + threadNumber + " = " + client.getId()
				+ " is client reserved " + client.reservedParkingSpace());

	}

	private synchronized void connectClientToParkingSpace(int i,
			int threadNumber) {
		Client clientWithOutParkingSpace = parkingSpaceManager
				.getClientWithOutParkingSpace();
		System.out.println("	Start wątek = " + threadNumber + " i = " + i);
		System.out.println("Wątek nr " + threadNumber + " = "
				+ clientWithOutParkingSpace.getId() + " is client reserved "
				+ clientWithOutParkingSpace.reservedParkingSpace());
		ParkingSpace parkingSpace = ParkingSpaceDAO.get(random.nextInt(56) + 1);
		if (!parkingSpace.isOccupy()) {
			ParkingSpaceDAO.parkingSpaceMakeOccupy(parkingSpace,
					clientWithOutParkingSpace);
			System.out.println("  R  Wątek nr " + threadNumber + " Client = "
					+ clientWithOutParkingSpace.getId()
					+ " reservd parkingSpace = "
					+ parkingSpace.getParkingNumber());
		} else
			System.out.println("    Wątek nr " + threadNumber
					+ " parkingSpace = " + parkingSpace.getParkingNumber()
					+ " reserved");
		System.out.println("		Stop wątek = " + threadNumber + " i = " + i);
	}

	/**
	 * 
	 */
	private void sleep(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param parkingSpace
	 * @param client
	 */
	private void printText(ParkingSpace parkingSpace, Client client) {
		System.out.println("parking number = "
				+ parkingSpace.getParkingNumber() + " client number = "
				+ client.getId());
	}
}
