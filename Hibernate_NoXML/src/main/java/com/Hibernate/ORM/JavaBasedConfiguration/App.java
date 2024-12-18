package com.Hibernate.ORM.JavaBasedConfiguration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
       Configuration configuration = MyConfiguration.configurationHibernate();
       SessionFactory sessionFactory = configuration.buildSessionFactory();
       Session session = sessionFactory.openSession();
       
       Transaction tx = session.beginTransaction();
       
       // Perform CRUD operations
       UserModel user = new UserModel("Naveen D");
       session.persist(user);
       
       UserModel user1 = session.get(UserModel.class, 1);
       System.out.println(user1.getName());
       
       UserModel user2 = new UserModel("Pooja K");
       session.persist(user2);
       
       UserModel user3 = new UserModel("Nitin d");
       session.persist(user3);
       
       // Retrieve a user by ID
       UserModel retrievedUser = session.get(UserModel.class, 2);
       System.out.println("Retrieved user: "+ retrievedUser);
       
       // Update a user
       retrievedUser.setName("Bob");
       session.merge(retrievedUser); // equal to session.update()
       
       System.out.println("Retrieved user after update: "+ retrievedUser);
       
       //Delete a user
       session.remove(retrievedUser); // equal to session.delete()
       
       Query<UserModel> query = session.createQuery("from UserModel", UserModel.class);
		List<UserModel> users = query.list();
		for (UserModel user_: users) {
			System.out.println(user_);
		}
       
       tx.commit();
       session.close();
       sessionFactory.close();

    }
}
