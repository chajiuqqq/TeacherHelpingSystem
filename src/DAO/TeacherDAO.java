package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javassist.compiler.ast.Pair;
import poj.Subject;
import poj.Teacher;
import poj.Teacher_Subject;

public class TeacherDAO {
	public static void addTeacher(Teacher t) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(t);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	public static Teacher getTeacherObj(int tid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Teacher t=(Teacher)s.get(Teacher.class, tid);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return t;
	}
	
//	public Set<Subject> get_subjects_of_this_teacher(int tid){
//		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		Teacher teacher=(Teacher)s.get(Teacher.class, tid);
//		s.getTransaction().commit();
//		s.close();
//		sf.close();
//		return teacher.getSubjects();
//	}
	public static Teacher getTeacherObj(String username,String password) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from teacher a where a.username=:username and a.password=:password";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("username", username);
		query.setParameter("password", password);
	
		List<Object[]> list=query.list();
		Teacher teacher=(Teacher)s.get(Teacher.class, (int)list.get(0)[0]);
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return teacher;
	}

	
	
	public static void main(String[] args) {
//		TeacherDAO dao=new TeacherDAO();
//		for(Subject s:dao.get_subjects_of_this_teacher(10001)){
//			System.out.println(s.getId());
//			System.out.println(s.getName());
//		}
	}
}
