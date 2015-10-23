package pl.test;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.tools.Generator;

public class MainTestClass {

	public static void main(String[] args) {
		TestThread testThread = new TestThread();
		Thread thread1 = new Thread(testThread);
		Thread thread2 = new Thread(testThread);
		thread1.start();
//		thread2.start();
	}

	public static void generateTableForClientAndParkingSpace() {

		for (int i = 0; i < 57; i++) {
			ParkingSpace parkingSpace = new ParkingSpace(i + 1,
					200 + Generator.generateInteger(200));
			if (i % 3 == 0) {
				Client client = new Client(Generator.generateName(),
						Generator.generateSurname());
				parkingSpace.setClient(client);
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
