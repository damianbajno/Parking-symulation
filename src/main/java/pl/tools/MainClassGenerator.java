package pl.tools;

import pl.panels.ParkingField;
import pl.panels.ParkingPanel;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class MainClassGenerator {
	public static void main(String[] args) {
		Generator generator=new Generator();
			for (int i = 0; i < 10; i++) {
				Client client=new Client(Generator.generateName(), Generator.generateSurname());
				ClientDAO.persist();
			}
			
			for (int i = 0; i < ParkingPanel.parkingFieldList.size(); i++) {
				ParkingSpace parkingSpace=new ParkingSpace(i, 200+generator.generateInteger(200));
				ParkingSpaceDAO.persist(parkingSpace);
			}
	
	}
}