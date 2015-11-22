package pl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ParkingSpace {
	@Id
	@Column(name = "ParkingSpace_ID")
	private int parkingNumber;
	@Column(columnDefinition = "int default 100")
	private int parkingCost;
	@OneToOne
	@Cascade({ CascadeType.ALL })
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

	public int getParkingNumber() {
		return parkingNumber;
	}

	public boolean isOccupy() {
		if (client==null) {
			return false;
		} else
			return true;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "ParkingSpace [parkingNumber=" + parkingNumber
				+ ", parkingCost=" + parkingCost + ", occupy=" + isOccupy() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + parkingCost;
		result = prime * result + parkingNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSpace other = (ParkingSpace) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (parkingCost != other.parkingCost)
			return false;
		if (parkingNumber != other.parkingNumber)
			return false;
		return true;
	}
	
}
