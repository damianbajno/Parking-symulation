package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ParkingSpace {
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
