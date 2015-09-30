package pl.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DAO {

	private static Configuration configuration = new Configuration()
			.configure();
	private static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	private static SessionFactory factory = configuration
			.buildSessionFactory(builder.build());
	private static Session session = null;
	
	private DAO() {
		// TODO Auto-generated constructor stub
	}

	protected static Session getSession() {
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}
	
	protected static void beginTransaction() {
		session.beginTransaction();
	}
	
	protected static void commiteTransaction() {
		session.getTransaction().commit();
	}
	
	protected static void rollback(){
		try {
			session.getTransaction().rollback();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
	}
	
	protected static void close(){
		try {
			session.close();
		} catch (HibernateException e) {
			System.out.println("Can't close session");
			e.printStackTrace();
		}
	}
}
