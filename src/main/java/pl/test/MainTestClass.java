package pl.test;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class MainTestClass {

	public static void main(String[] args) {

		// for (int i = 0; i < 30; i++) {
		// Client client = new Client(Generator.generateName(),
		// Generator.generateSurname());
		// ParkingSpace parkingSpace=new ParkingSpace(i);
		// ParkingSpaceDAO.persist(parkingSpace);
		// ClientDAO.persist(client);
		// }

		// ParkingSpace parkingSpace = ParkingSpaceDAO.get(5);
		// System.out.println(parkingSpace.toString());
		// parkingSpace.setFree();
		// System.out.println(parkingSpace.toString());
		// ParkingSpaceDAO.update(parkingSpace);
	
		Client client = ClientDAO.get(5);
		System.out.println(client.reservedParkingSpace());
		
		
	}

}
