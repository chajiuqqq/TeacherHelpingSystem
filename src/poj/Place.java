package poj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="place")
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	

	@Column(name="position_")
	String position;
	
	public int getId() {
		return id;
	}
	public String getPosition() {
		return position;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	public void F() {
		System.out.println("asdd");
	}
}
