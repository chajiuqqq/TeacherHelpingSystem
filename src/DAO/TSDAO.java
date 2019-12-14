package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Teacher_Subject;

public class TSDAO {
	public static Teacher_Subject getTSObj(int TS_id) {        
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from teacher_subject a where a.id=:TS_id";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("TS_id", TS_id);
		
		List<Teacher_Subject> t_s_list=new ArrayList<Teacher_Subject>();
		List<Object[]> list=query.list();
		for(Object[] os:list){
			int tid=(int)os[1];
			int sid=(int)os[2];
			int timeid=(int)os[3];
			int placeid=(int)os[4];
			Teacher_Subject t_s=new Teacher_Subject(TS_id,tid, sid, timeid, placeid);
			t_s_list.add(t_s);
//			System.out.println( "\t"+timeid+ "\t"+placeid);
		}
		s.getTransaction().commit();
		s.close();
		sf.close();
		return t_s_list.get(0);
	}
	
	public static void main(String[] args) {
		System.out.println(getTSObj(13).getTeacher().getName());
	}
}
