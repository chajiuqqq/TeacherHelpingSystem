package poj;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tno")
	int tno;
	
	
	String name;
	String username;
	String password;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(
			name="teacher_subject",
			joinColumns=@JoinColumn(name="tid"),
			inverseJoinColumns=@JoinColumn(name="sid")
	)
	Set<Subject> subjects;
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getTno() {
		return tno;
	}
	public String getUsername() {
		return username;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
}
