package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceButton {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private static int parkingSpaceNumberGenerator = 0;
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
	private ParkingSpace parkingSpace;
	private JButton parkingSpaceButton = new JButton();
	private int parkingSpaceNumber;
	private Random random = new Random();

	public ParkingSpaceButton() {
		defaultSettings();
		parkingSpaceNumber = parkingSpaceNumberGenerator++;
		getParkingSpaceFromDataBase();
	}

	private void defaultSettings() {
		parkingSpaceButton.setOpaque(true);
		parkingSpaceButton.setHorizontalAlignment(JLabel.CENTER);
		parkingSpaceButton.setPreferredSize(parkingSpaceDimension);
		parkingSpaceButton.setText(String.valueOf(parkingSpaceNumberGenerator));
		parkingSpaceButton.setBorder(new LineBorder(Color.BLACK, 2, false));
		parkingSpaceButton.setBackground(Color.GREEN);
		parkingSpaceButton.addActionListener(parkingSpaceListener);
	}

	private void getParkingSpaceFromDataBase() {
		parkingSpace = ParkingSpaceDAO.get(parkingSpaceNumber);
	}

	private Client client;

	public void setOccupy() {
		parkingSpaceButton.setBackground(Color.RED);
		parkingSpace.setOccupy();
		getClientWithOutparkingSpace();
		synchronized (client) {
			parkingSpace.setClient(client);
			ParkingSpaceDAO.update(parkingSpace);
		}
	}

	private void getClientWithOutparkingSpace() {
		do {
			client = ClientDAO.get(random.nextInt(ClientDAO.getAll().size()));
		} while (client.isReservedParkingSpace());
	}

	public void setFree() {
		parkingSpaceButton.setBackground(Color.GREEN);
		parkingSpace.setFree();
		parkingSpace.setClient(null);
		ParkingSpaceDAO.update(parkingSpace);

	}

	public boolean isOccupied() {
		if (parkingSpaceButton.getBackground().equals(Color.RED))
			return true;
		else
			return false;
	}

	public JButton getParkingSpaceButton() {
		return parkingSpaceButton;
	}

	public int getParkingSpaceNumber() {
		return parkingSpaceNumber;
	}

}
