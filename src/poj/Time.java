package poj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="time_")
public class Time {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	String period;
	
	
	public int getId() {
		return id;
	}
	public String getPeriod() {
		return period;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
}
