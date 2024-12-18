package com.foreignKeyAssociation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = MyConfiguration.configurationHibernate().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Boy boy1 = new Boy("Naveen");
		Girl girl1 = new Girl("Pooja");
		boy1.setGirl(girl1);
		girl1.setBoy(boy1);
		
		Transaction tx = session.beginTransaction();
		session.persist(boy1);
		session.persist(girl1);
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
}
