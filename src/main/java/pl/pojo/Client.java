package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Client {
	private String name;
	private String lastName;
	@OneToOne
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
