package pl.test;

import java.util.Random;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class TestThread implements Runnable{
	Random random=new Random();
	
	public TestThread() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			ParkingSpace parkingSpace=new ParkingSpace(random.nextInt(50));
			Client client = parkingSpace.getClient();
			client.setReserved(false);
			parkingSpace.setClient(null);
			ParkingSpaceDAO.update(parkingSpace);
			ClientDAO.update(client);
			printText(parkingSpace, client);
		}
		
		
		
	}

	/**
	 * @param parkingSpace
	 * @param client
	 */
	private void printText(ParkingSpace parkingSpace, Client client) {
		System.out.println("parking number = "+parkingSpace.getParkingNumber()+" client number = "+client.getId());
	}
}
