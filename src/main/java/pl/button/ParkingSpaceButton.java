package pl.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pl.action.ParkingSpaceListener;
import pl.dao.ParkingSpaceDAO;
import pl.pojo.ParkingSpace;

public class ParkingSpaceButton extends JButton {

    private static int parkingSpaceNumberGenerator = 0;

    private final Dimension parkingSpaceDimension = new Dimension(50, 80);
    private int parkingSpaceNumber;
    private ParkingSpaceListener parkingSpaceListener = new ParkingSpaceListener();
    private ParkingSpaceDAO parkingSpaceDAO = ParkingSpaceDAO.getInstance();
    private boolean free;
    private Lock lock = new ReentrantLock();

    public ParkingSpaceButton() {
	parkingSpaceNumber = ++parkingSpaceNumberGenerator;
	initializationSettings();

    }

    private void initializationSettings() {
	setOpaque(true);
	setHorizontalAlignment(JLabel.CENTER);
	setPreferredSize(parkingSpaceDimension);
	setText(String.valueOf(parkingSpaceNumberGenerator));
	setBorder(new LineBorder(Color.BLACK, 2, false));
	addActionListener(parkingSpaceListener);
	setParkingSpaceStatus();
    }

    private void setParkingSpaceStatus() {
	ParkingSpace parkingSpace = parkingSpaceDAO
		.get(parkingSpaceNumberGenerator);
	if (parkingSpace != null) {
	    if (parkingSpace.isOccupy())
		setOccupy();
	    else
		setFree();
	}
	
    }

    public void setOccupy() {
	free = false;
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		setBackground(Color.RED);
	    }
	});
    }

    public void setFree() {
	free = true;
	EventQueue.invokeLater(new Runnable() {

	    public void run() {
		setBackground(Color.GREEN);
	    }
	});
    }

    public boolean trylock() {
	return this.lock.tryLock();
    }

    public boolean trylock(int sekunds) {
	try {
	    return this.lock.tryLock(2, TimeUnit.SECONDS);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}
    }

    public void unLock() {
	this.lock.unlock();
    }

    public boolean isFree() {
	return free;
    }

    public int getParkingNumber() {
	return parkingSpaceNumber;
    }
}
