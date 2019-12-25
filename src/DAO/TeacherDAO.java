package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.w3c.dom.events.EventException;

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
		Teacher teacher;
		List<Object[]> list=query.list();
		try{
			teacher=(Teacher)s.get(Teacher.class, (int)list.get(0)[0]);	
		}catch(Exception e){
			teacher=null;
		}
		
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return teacher;
	}
	
	public static List<Teacher> getTeachers() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		Query q=s.createQuery("from Teacher");
		List<Teacher> list=q.list();
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return list;
	}
	public static void updateTeacher(Teacher t) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		//Teacher teacher=(Teacher)s.get(Teacher.class, t.getTno());
		s.update(t);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
	public static void main(String[] args) {
//		List<Teacher> list=getTeachers();
//		for(Teacher t:list){
//			System.out.println(t.getName());
//		}
		Teacher t=new Teacher();
		t.setTno(10005);
		t.setName("sorry_zyy");
		t.setUsername("zyy");
		t.setPassword("999");
		updateTeacher(t);
		
	}
}
