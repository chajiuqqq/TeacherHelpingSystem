package poj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import DAO.PlaceDAO;
import DAO.SubjectDAO;
import DAO.TeacherDAO;
import DAO.TimeDAO;
@Entity
@Table(name="teacher_subject")
public class Teacher_Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@ManyToOne
	@JoinColumn(name="tid")
	Teacher teacher;
	
	@ManyToOne
	@JoinColumn(name="sid")
	Subject subject;
	
	@ManyToOne
	@JoinColumn(name="timeid")
	Time time;
	
	@ManyToOne
	@JoinColumn(name="placeid")
	Place place;
	
	public Teacher_Subject() {
		// TODO Auto-generated constructor stub
	}
	public Teacher_Subject(int aid, int tid,int sid,int timeid,int placeid) {
		// TODO Auto-generated constructor stub
		id=aid;
		teacher=TeacherDAO.getTeacherObj(tid);
		subject=SubjectDAO.getSubjectObj(sid);
		time=TimeDAO.getTimeObj(timeid);
		place=PlaceDAO.getPlaceObj(placeid);
	}
	
	public int getId() {
		return id;
	}
	public Place getPlace() {
		return place;
	}
	public Subject getSubject() {
		return subject;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public Time getTime() {
		return time;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
}
