package pl.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.dao.ClientDAO;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceButton extends JButton {

	private final Dimension parkingSpaceDimension = new Dimension(50, 80);
	private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
	private static int parkingSpaceNumberGenerator = 0;
	private int parkingSpaceNumber;
	private ParkingSpaceDAO parkingSpaceDAO = new ParkingSpaceDAO();
	private boolean lock=false;
	
	public ParkingSpaceButton() {
		parkingSpaceNumber = ++parkingSpaceNumberGenerator;
		defaultSettings();
		setParkingSpaceStatus();
		
	}

	private void defaultSettings() {
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(parkingSpaceDimension);
		setText(String.valueOf(parkingSpaceNumberGenerator));
		setBorder(new LineBorder(Color.BLACK, 2, false));
		addActionListener(parkingSpaceListener);
	}

	private void setParkingSpaceStatus() {
		ParkingSpace parkingSpace = parkingSpaceDAO.get(parkingSpaceNumberGenerator);
		if (parkingSpace.isOccupy())
			setBackground(Color.RED);
		else
			setBackground(Color.GREEN);
	}
	
	public void setOccupy() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				setBackground(Color.RED);
			}
		});
		unLock();
	}

	public void setFree() {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				setBackground(Color.GREEN);
			}
		});
		unLock();
	}

	public void lock() {
		this.lock=true;
	}

	private void unLock() {
		this.lock=false;
	}

	public boolean isLock(){
		return lock;
	}
	
	public boolean isOccupy() {
		if (getBackground().equals(Color.RED))
			return true;
		else
			return false;
	}

	public int getParkingNumber() {
		return parkingSpaceNumber;
	}

}
