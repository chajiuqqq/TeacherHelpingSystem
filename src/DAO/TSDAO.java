package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Teacher;
import poj.Teacher_Subject;

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
		
	
	public static void main(String[] args) {
		Teacher teacher=TeacherDAO.getTeacherObj(10002);
		//TSDAO.updateTS(13, teacher);
	}
}
