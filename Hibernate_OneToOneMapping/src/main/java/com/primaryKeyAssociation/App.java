package com.primaryKeyAssociation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = MyConfiguration.configurationHibernate().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user1 = new User("Naveen");
		
		Address address1 = new Address();
		address1.setAddressLine1("addressLine1......!");
		address1.setAddressLine2("addressLine2......!");
		address1.setCity("City");
		address1.setState("State");
		address1.setCountry("Country");
		address1.setPincode(111111);
		address1.setUser(user1);
		
		user1.setAddress(address1);
		
		Transaction tx = session.beginTransaction();
		session.persist(user1);
		session.persist(address1);
		tx.commit();
		
		session.close();
		sessionFactory.close();
		
	}
}
