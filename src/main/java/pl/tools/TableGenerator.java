package pl.tools;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.dao.StatisticDataDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class TableGenerator {

    private static ParkingSpaceDAO parkingSpaceDAO = ParkingSpaceDAO
	    .getInstance();
    private static ClientDAO clientDAO = new ClientDAO();

    public static void main(String[] args) {
	TableGenerator.generateTables();
    }
    
    public static void generateTables() {

	for (int i = 0; i < 57; i++) {
	    ParkingSpace parkingSpace = new ParkingSpace(i + 1,
		    200 + Generator.generateInteger(200));
	    parkingSpaceDAO.persist(parkingSpace);
	}

	for (int i = 0; i < 50; i++) {
	    Client client = new Client(Generator.generateName(),
		    Generator.generateSurname());
	    clientDAO.persist(client);
	}

    }
}
