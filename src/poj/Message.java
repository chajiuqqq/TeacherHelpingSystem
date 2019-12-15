package poj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@ManyToOne
	@JoinColumn(name="tid")
	Teacher teacher;
	
	@OneToOne
	int ts_id;
	
	
	public int getId() {
		return id;
	}
	public int getTs_id() {
		return ts_id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTs_id(int ts_id) {
		this.ts_id = ts_id;
	}
	
}
