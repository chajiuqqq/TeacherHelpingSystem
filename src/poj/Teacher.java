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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="tno")
	int tno;
	
	
	String name;
	String username;
	String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tid")
	Set<Teacher_Subject> tsSet;
	
	

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tid")
	Set<Message> messages;
	
	
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
	public Set<Teacher_Subject> getTsSet() {
		return tsSet;
	}
	
	public Set<Message> getMessages() {
		return messages;
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
	public void setTsSet(Set<Teacher_Subject> tsSet) {
		this.tsSet = tsSet;
	}
	
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
