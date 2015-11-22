package pl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Client_ID")
	private int id;
	private String name;
	private String surName;
	@Version
	private Long version;
	@OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST, CascadeType.SAVE_UPDATE })
	private ParkingSpace parkingSpace;

	public Client() {

	}

	public Client(String name, String surName) {
		super();
		this.name = name;
		this.surName = surName;
	}

	public int getId() {
		return id;
	}

	public Object getField(int fieldNumber) {
		switch (fieldNumber) {
		case 0:
			return id;
		case 1:
			return name;
		case 2:
			return surName;
		default:
			return "-";
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public boolean reservedParkingSpace() {
		if (parkingSpace == null)
			return false;
		else
			return true;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surName=" + surName + ", version=" + version+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parkingSpace == null) ? 0 : parkingSpace.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parkingSpace == null) {
			if (other.parkingSpace != null)
				return false;
		} else if (!parkingSpace.equals(other.parkingSpace))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	

}
