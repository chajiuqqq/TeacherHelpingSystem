package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

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
	
	public static void main(String[] args) {
		System.out.println(getTSObj(13).getTeacher().getName());
	}
}
