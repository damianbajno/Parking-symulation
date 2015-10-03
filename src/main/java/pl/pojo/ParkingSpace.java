package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ParkingSpace {
	@Id
	private int parkingNumber;
	private int parkingCost;
	@OneToOne
	@Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	private Client client;
	
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
	}

	public int getParkingCost() {
		return parkingCost;
	}

	public void setParkingCost(int parkingCost) {
		this.parkingCost = parkingCost;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getParkingNumber() {
		return parkingNumber;
	}
	
	
}
