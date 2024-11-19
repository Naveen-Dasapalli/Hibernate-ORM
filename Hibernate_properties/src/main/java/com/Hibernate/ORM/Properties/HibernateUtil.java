package com.Hibernate.ORM.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
		static {
			Properties properties = new Properties();
				try {
					properties.load(new FileInputStream("hibernate.properties"));

				} catch (IOException e) {
					e.printStackTrace();
				}
				Configuration configuration = new Configuration();
				configuration.addProperties(properties);
				configuration.addAnnotatedClass(Student.class);
				
				sessionFactory = configuration.buildSessionFactory();

		}
		public static SessionFactory getSessioFactory() { return sessionFactory;}
}
