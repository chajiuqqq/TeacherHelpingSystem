package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Place;
import poj.Subject;
import poj.Teacher;
import poj.Teacher_Subject;
import poj.Time;

public class adminDAO {
	
	public static void arrange_s_t(int tid,int sid,String time,String place) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		//添加老师的科目
		s.beginTransaction();
		Teacher t=(Teacher)s.get(Teacher.class, tid);
		Set<Subject> subjects=t.getSubjects();
		
		Subject subject=(Subject)s.get(Subject.class, sid);
		subjects.add(subject);

		s.getTransaction().commit();
		
		
		//设置timeid和placeid
		s.beginTransaction();
		String sql="update teacher_subject a set a.timeid=:timeid,a.placeid=:placeid where a.tid=:tid and a.sid=:sid";
		SQLQuery query=s.createSQLQuery(sql);
		
		
		
		query.setParameter("timeid", TimeDAO.getTimeObj(time).getId());
		query.setParameter("placeid",PlaceDAO.getPlaceObj(place).getId());
		query.setParameter("tid", tid);
		query.setParameter("sid", sid);
		
		int i=query.executeUpdate();

		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	
//	public static List<Teacher_Subject> get_arrangement(int tid) {
//		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		
//		String sql="select * from teacher_subject a where a.tid=:tid";
//		SQLQuery query=s.createSQLQuery(sql);
//		query.setParameter("tid", tid);
//		List<Teacher_Subject> t_s_list=new ArrayList<Teacher_Subject>();
//		List<Object[]> list=query.list();
//		for(Object[] os:list){
//			int id=(int)os[0];
//			int sid=(int)os[2];
//			int timeid=(int)os[3];
//			int placeid=(int)os[4];
//			Teacher_Subject t_s=new Teacher_Subject(id,tid, sid, timeid, placeid);
//			t_s_list.add(t_s);
////			System.out.println( "\t"+timeid+ "\t"+placeid);
//		}
//		s.getTransaction().commit();
//		s.close();
//		sf.close();
//		return t_s_list;
//	}
	public static List<Teacher_Subject> get_arrangement(int tid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from teacher_subject a where a.tid=:tid";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("tid", tid);
		List<Teacher_Subject> list=query.list();
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return list;
	}
	
	public static List<Teacher> get_available_teacher(int TS_id) {       

		Teacher_Subject ts=TSDAO.getTSObj(TS_id);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		
		String sql="select tid from teacher_subject a where a.tid <> :tid and a.sid=:sid and a.timeid <> :timeid";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("tid", ts.getTeacher().getTno());
		query.setParameter("sid", ts.getSubject().getId());
		query.setParameter("timeid", ts.getTime().getId());
		
		List<Integer> list=query.list();
		List<Teacher> teachers=new ArrayList<>();
		
		for(int i:list){
			Teacher t=(Teacher)s.get(Teacher.class, i);
			teachers.add(t);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return teachers;
	}
	
	
	
	
	
	public static void main(String[] args) {
//	Place p=getPlaceObj("1A103");
//	System.out.println(p.getId());
//	System.out.println(p.getPosition());
//		
//		arrange_s_t(10001,1,"Mon_1","1A102");
//		arrange_s_t(10001,2,"Mon_2","2A102");
//		arrange_s_t(10001,3,"Mon_3","3A102");
//		arrange_s_t(10002,1,"Fri_1","1A102");
//		arrange_s_t(10002,2,"Mon_1","1A112");
//		arrange_s_t(10003,4,"Tues_4","1A107");
		
//		List<Teacher_Subject> list=get_arrangement(10001);
//		for(Teacher_Subject ts:list){
//			System.out.println(ts.getTeacher().getName());
//			System.out.println(ts.getSubject().getName());
//			System.out.println(ts.getTime().getPeriod());
//			System.out.println(ts.getPlace().getPosition());
//		}
		
		List<Teacher> list=get_available_teacher(14);
		for(Teacher t:list){
			System.out.println(t.getName()+t.getUsername());
		}
	}
}
