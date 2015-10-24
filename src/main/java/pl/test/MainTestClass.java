package pl.test;

import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.dao.StatisticDataDAO;
import pl.panels.ThreadButton;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;
import pl.tools.Generator;

public class MainTestClass {

	public static void main(String[] args) {
		
		ThreadButton threadButton=new ThreadButton("ddasdsaf");
		threadButton.setText("dsad Damian ddsaa"+Thread.State.NEW);
		System.out.println(threadButton.getText());
		threadButton.changeState(Thread.State.BLOCKED);
		System.out.println(threadButton.getText());
		
		
//		generateTableForClientAndParkingSpace();
	}

	public static void generateTableForClientAndParkingSpace() {

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
