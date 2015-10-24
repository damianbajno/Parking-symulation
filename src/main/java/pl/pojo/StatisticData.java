package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

@Entity
public class StatisticData {
	@Id
	@GeneratedValue
	private int id;
	private int clientNumber;
	private int parkingSpaceNumber;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dateTime;

	public StatisticData(int clientNumber, int parkingSpaceNumber) {
		super();
		this.clientNumber = clientNumber;
		this.parkingSpaceNumber = parkingSpaceNumber;
		this.dateTime = new LocalDateTime();
	}

	public StatisticData() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	public int getParkingSpaceNumber() {
		return parkingSpaceNumber;
	}

	public void setParkingSpaceNumber(int parkingSpaceNumber) {
		this.parkingSpaceNumber = parkingSpaceNumber;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


}
