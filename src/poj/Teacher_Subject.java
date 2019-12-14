package poj;

import DAO.PlaceDAO;
import DAO.SubjectDAO;
import DAO.TeacherDAO;
import DAO.TimeDAO;

public class Teacher_Subject {
	int id;
	Teacher teacher;
	Subject subject;
	Time time;
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
