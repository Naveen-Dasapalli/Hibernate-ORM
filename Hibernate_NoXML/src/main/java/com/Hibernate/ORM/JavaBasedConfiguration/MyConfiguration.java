package com.Hibernate.ORM.JavaBasedConfiguration;

import org.hibernate.cfg.Configuration;

public class MyConfiguration {
	
	public static Configuration configurationHibernate() {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test");
		configuration.setProperty("hibernate.connection.username", "Sa");
		configuration.setProperty("hibernate.connection.password", "");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.addAnnotatedClass(UserModel.class);
		return configuration;
	}

}
