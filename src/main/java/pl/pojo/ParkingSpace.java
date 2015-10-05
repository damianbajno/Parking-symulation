package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ParkingSpace {
	@Id
	private int parkingNumber;
	private int parkingCost;
	private boolean occupy;
	@OneToOne
	@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	private Client clientReservation;
	
	public ParkingSpace() {
		// TODO Auto-generated constructor stub
	}

	public ParkingSpace(int parkingNumber) {
		super();
		this.parkingNumber = parkingNumber;
	}

	public ParkingSpace(int parkingNumber, int parkingCost) {
		super();
		this.parkingNumber = parkingNumber;
		this.parkingCost = parkingCost;
		occupy=true;
	}

	
	public int getParkingCost() {
		return parkingCost;
	}

	public void setParkingCost(int parkingCost) {
		this.parkingCost = parkingCost;
	}

	public int getParkingNumber() {
		return parkingNumber;
	}

	public boolean isOccupy() {
		return occupy;
	}

	public Client getClientReservation() {
		return clientReservation;
	}

	public void setClientReservation(Client clientReservation) {
		this.clientReservation = clientReservation;
	}

	
	
}
