package dbcon;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;

import models.Account;
import models.Customer;
import models.Transactions;


public class FactoryProvider {
	
	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		try
		{
			 Configuration configuration = new Configuration();

			    // Hibernate settings equivalent to hibernate.cfg.xml's properties
			    Properties settings = new Properties();
			    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/ewallet");
			    settings.put(Environment.USER, "root");
			    settings.put(Environment.PASS, "Bhanu@123");
			    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

			    settings.put(Environment.SHOW_SQL, "true");

			    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			    settings.put(Environment.HBM2DDL_AUTO, "update");

			    configuration.setProperties(settings);
			    configuration.addAnnotatedClass(Customer.class);
			    configuration.addAnnotatedClass(Account.class);
			    configuration.addAnnotatedClass(Transactions.class);

			    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			      .applySettings(configuration.getProperties()).build();
			    System.out.println("Hibernate Java Config serviceRegistry created");
			    factory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		FactoryProvider.factory = factory;
	}
	

}
