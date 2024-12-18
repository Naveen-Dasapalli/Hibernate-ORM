package com.Hibernate.ORM.Properties;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class App 
{
    public static void main( String[] args )
    {
        //Create Session object
    	
    	Session session = HibernateUtil.getSessioFactory().openSession();
    	
    	//Perform life-cycle Operations under a transaction
    	
    	Transaction tx = null;
    	
    	try {
    		
    		tx = session.beginTransaction();
    		
    		//Create a Student object and save it
    		Student s1 = new Student();
    		s1.setName("Naveen");
    		session.persist(s1); // equal to session.save();
    		
    		Student s2 = new Student();
    		s2.setName("Pooja");
    		session.persist(s2); // equal to session.save();
    		
    		
    		tx.commit();
    		
    		//List<Student> users = loadAllData(Student.class, session);
    		//users.forEach(s -> System.out.println(s));
    		
    		Query<Student> query = session.createQuery("from Student", Student.class);
    		List<Student> students = query.list();
    		for (Student student: students) {
    			System.out.println(student);
    		}
    		
    		//Retrieve Student object
    		Student s = session.get(Student.class, 1);
    		System.out.println(s.getName());
    		
    	} catch(HibernateException e){
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    			
    }

//	private static <T> List<T> loadAllData(Class<T> type, Session session) {
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<T> criteria = builder.createQuery(type);
//		criteria.from(type);
//		List<T> data = session.createQuery(criteria).getResultList();		
//		return data;
//	}
}
