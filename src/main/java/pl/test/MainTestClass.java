package pl.test;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.tools.Generator;

public class MainTestClass {

	public static void main(String[] args) {

		
		for (int i = 0; i < 40; i++) {
			Client client = new Client(Generator.generateName(),
					Generator.generateSurname());
			ClientDAO.persist(client);
		}
		
		// ParkingSpace parkingSpace = ParkingSpaceDAO.get(5);
		// System.out.println(parkingSpace.toString());
		// parkingSpace.setFree();
		// System.out.println(parkingSpace.toString());
		// ParkingSpaceDAO.update(parkingSpace);
		//
		// Client client = ClientDAO.get(5);
		// System.out.println(client.reservedParkingSpace());

		
//		generateTableForClientAndParkingSpace();
	}

	public static void generateTableForClientAndParkingSpace() {

		for (int i = 0; i < 57; i++) {
			ParkingSpace parkingSpace = new ParkingSpace(i+1,
					200 + Generator.generateInteger(200));
			if (i % 3 == 0) {
				Client client = new Client(Generator.generateName(),
						Generator.generateSurname());
				parkingSpace.setClient(client);
				client.setReserved(true);
			}
			ParkingSpaceDAO.persist(parkingSpace);
		}

		for (int i = 0; i < 10; i++) {
			Client client = new Client(Generator.generateName(),
					Generator.generateSurname());
			ClientDAO.persist(client);
		}

	}

}
