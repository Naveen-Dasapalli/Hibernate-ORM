package com.Hibernate.ORM;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    		
    		tx.commit();
    		
    		//Retrieve Student object
    		Student s = session.get(Student.class, 1);
    		
    		System.out.println(s.getName());
    		
    	} catch(HibernateException e){
    		e.printStackTrace();
    	} finally {
    		session.close();
    	}
    			
    }
}
