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
	
	public static void removeMessage(int message_id) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Message message=(Message)s.get(Message.class, message_id);
//		
//		//��teacher�еĸ�messageɾ��
//		Teacher teacher=message.getTeacher();
//		teacher.getMessages().remove(message);
//		//�Ѹ�message��teacher��null
//		message.setTeacher(null);
//		
		
		//�ѳɹ�����Ҫ�Ǽ������ò��ԣ�all�Ļ������ɾ���˸�message��Ҳ�����teacher�е�Set<Message>������ӣ�����ɾ�����ɹ���
		//��Ϊremove����merge���ɡ�allҪ����
		
		s.delete(message);

		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
	public static Message getMessage(int messageid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Message message=(Message)s.get(Message.class, messageid);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return message;
	}
	public static void main(String[] args) {
		removeMessage(82);
	}
	
}
