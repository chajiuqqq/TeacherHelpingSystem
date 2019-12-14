package DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import poj.Place;

public class PlaceDAO {
	public static Place getPlaceObj(int placeid) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Place p=(Place)s.get(Place.class, placeid);
		s.getTransaction().commit();
		s.close();
		sf.close();
		return p;
	}
	
	public static void addPlace() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Place p;
		
		String[] buildings={"1A","1B","2A","2B","3A","3B"};

		for(String building:buildings){
			
			for(int i=1;i<21;i++){
				p=new Place();
				p.setPosition(building+(100+i));
				s.save(p);
			}
		}
		
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}	
	public static Place getPlaceObj(String position) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		
		String sql="select * from place a where a.position_=:position";
		SQLQuery query=s.createSQLQuery(sql);
		query.setParameter("position", position);
		List<Object[]> list=query.list();
		
		Place p=new Place();
		p.setId((int)list.get(0)[0]);
		p.setPosition(list.get(0)[1].toString());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		return p;
	}	
}
