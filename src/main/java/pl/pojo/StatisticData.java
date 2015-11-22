package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

@Entity
public class StatisticData {
	@Id
	@GeneratedValue
	private int id;
	private int clientNumber;
	private int parkingSpaceNumber;
	private boolean isParking;
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateTime= new DateTime();

	public StatisticData(int clientNumber, int parkingSpaceNumber, boolean isParking) {
		super();
		this.clientNumber = clientNumber;
		this.parkingSpaceNumber = parkingSpaceNumber;
		this.isParking=isParking;
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

	public boolean isParking() {
		return isParking;
	}

	public void setParking(boolean isParking) {
		this.isParking = isParking;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
}
