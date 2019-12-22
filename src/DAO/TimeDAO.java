package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Teacher;
import poj.Time;

public class TimeDAO {
	public static Time getTimeObj(int timeid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Time t=(Time)s.get(Time.class, timeid);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return t;
	}
	
	public static Time getTimeObj(String period) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from time_ a where a.period=:period";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("period", period);
		List<Object[]> list=query.list();
		Time t=new Time();
		t.setId((int)list.get(0)[0]);
		t.setPeriod(list.get(0)[1].toString());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return t;
	}	
	
	public static void addTime() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Time time;
		
		String[] week={"Mon","Tues","Wed","Thur","Fri","Sat","Sun"};

		for(String day:week){
			for(int i=1;i<7;i++){
				time=new Time();
				time.setPeriod(day+"_"+i);
				s.save(time);
			}
		}
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}	
	public static List<Time> getAvailableTime(Teacher teacher) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from time_ a where a.id not in(select timeid from teacher_subject where tid=:tid)";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("tid", teacher);
		
		List<Object[]> list=query.list();
		List<Time> times=new ArrayList<Time>();
		
		Time t;
		for(Object[] time_item:list){
			t=new Time();
			t.setId((int)time_item[0]);
			t.setPeriod((String)time_item[1]);
			times.add(t);
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return times;
	}
	public static void main(String[] args) {
		Teacher teacher=TeacherDAO.getTeacherObj(10002);
		List<Time> times=getAvailableTime(teacher);
		for(Time t:times){
			System.out.println(t.getPeriod());
		}
	}
}
