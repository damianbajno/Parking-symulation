package pl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	public Object getField(int fieldNumber){
		switch (fieldNumber) {
		case 0:
			return id;
		case 1:
			return name;
		case 2:
			return lastName;
		default:
			return "-";
		}
	}
	
}
