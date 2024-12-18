package com.Hibernate.ORM;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
		static {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			catch(HibernateException ex){
				
				// Log the exception
				
				System.out.println("Initial SessionFactory creation failed." + ex);
				
				throw new ExceptionInInitializerError(ex);
			}
		}
		
		public static SessionFactory getSessioFactory() { return sessionFactory;}
}
