package DAO;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Message;
import poj.Teacher;
import poj.Teacher_Subject;

public class MessageDAO {
	public static void addMessage(int tid,int ts_id) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Teacher teacher=(Teacher)s.get(Teacher.class, tid);
		Teacher_Subject ts=(Teacher_Subject)s.get(Teacher_Subject.class, ts_id);
		
		Message message=new Message();
		message.setTeacher(teacher);
		message.setTs(ts);
		s.save(message);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	public static Set<Message> get_this_teacher_message(int tid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Teacher teacher=(Teacher)s.get(Teacher.class, tid);

		s.getTransaction().commit();
		s.close();
		sf.close();
		return teacher.getMessages();
	}
	
	
}
