package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Subject;

public class SubjectDAO {
	public static Subject getSubjectObj(int sid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Subject sub=(Subject)s.get(Subject.class, sid);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return sub;
	}
	public static void addSubject() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		
		 
		Subject subject_Chinese=new Subject();
		subject_Chinese.setName("Chinese");
		s.save(subject_Chinese);
		
		Subject subject_English=new Subject();
		subject_English.setName("English");
		s.save(subject_English);
		
		Subject subject_cs=new Subject();
		subject_cs.setName("Computer Science");
		s.save(subject_cs);
		
		Subject subject_Math=new Subject();
		subject_Math.setName("Math");
		s.save(subject_Math);
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
