package pl.tools;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.dao.StatisticDataDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class Tools {

	public Tools() {
		// TODO Auto-generated constructor stub
	}

	public static void generateTables() {

		 for (int i = 0; i < 57; i++) {
		 ParkingSpace parkingSpace = new ParkingSpace(i + 1,
		 200 + Generator.generateInteger(200));
		 ParkingSpaceDAO.persist(parkingSpace);
		 }
		
		 for (int i = 0; i < 50; i++) {
		 Client client = new Client(Generator.generateName(),
		 Generator.generateSurname());
		 ClientDAO.persist(client);
		 }
		 
		 StatisticDataDAO statisticDataDAO=new StatisticDataDAO();
		 statisticDataDAO.persist(new StatisticData(12, 40));

}
}
