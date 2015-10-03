package pl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String lastName;
	@OneToOne
	@JoinColumn(name="ParkingSpace_Number")
	@Cascade({CascadeType.PERSIST,CascadeType.SAVE_UPDATE})
	private ParkingSpace parkingSpace;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	
}
