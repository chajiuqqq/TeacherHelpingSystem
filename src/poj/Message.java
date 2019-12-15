package poj;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ts_id")
	Teacher_Subject ts;
	
	
	public int getId() {
		return id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public Teacher_Subject getTs() {
		return ts;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setTs(Teacher_Subject ts) {
		this.ts = ts;
	}
	
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Teacher t=(Teacher)s.get(Teacher.class,10001);
		Teacher_Subject ts=(Teacher_Subject)s.get(Teacher_Subject.class, 13);
		
		Message message=new Message();
		message.setTeacher(t);
		message.setTs(ts);
		s.save(message);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
}
