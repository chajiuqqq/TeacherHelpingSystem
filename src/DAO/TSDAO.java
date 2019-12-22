package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Place;
import poj.Subject;
import poj.Teacher;
import poj.Teacher_Subject;
import poj.Time;

public class TSDAO {
	public static Teacher_Subject getTSObj(int TS_id) {        
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Teacher_Subject ts=(Teacher_Subject)s.get(Teacher_Subject.class, TS_id);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return ts;
	}
	public static void updateTS(Teacher_Subject old_TS, Teacher new_teacher) {        
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		old_TS.setTeacher(new_teacher);
		s.update(old_TS);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	public static void addTS(int tid, int sid, int timeid, int placeid) {        
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		Teacher teacher=TeacherDAO.getTeacherObj(tid);
		Subject subject=SubjectDAO.getSubjectObj(sid);
		Time time=TimeDAO.getTimeObj(timeid);
		Place place=PlaceDAO.getPlaceObj(placeid);
		
		Teacher_Subject ts=new Teacher_Subject();
		ts.setTeacher(teacher);
		ts.setSubject(subject);
		ts.setTime(time);
		ts.setPlace(place);
		
		s.save(ts);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
		
	
	public static void main(String[] args) {
		addTS(10001, 2, 7, 361);
		System.out.println("Ìí¼Ó³É¹¦");
	}
}
