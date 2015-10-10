package pl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.)
	@Column(name="Client_ID")
	private Long id;
	private String name;
	private String surName;
	@OneToOne
	@Cascade({CascadeType.PERSIST,CascadeType.SAVE_UPDATE})
	private ParkingSpace parkingSpace;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String surName) {
		super();
		this.name = name;
		this.surName = surName;
	}
	
	public Object getField(int fieldNumber){
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surName=" + surName+"]";
	}

	
}
