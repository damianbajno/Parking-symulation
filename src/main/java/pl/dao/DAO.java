package pl.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class DAO {

	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final Configuration configuration = new Configuration()
			.configure().addAnnotatedClass(Client.class)
			.addAnnotatedClass(ParkingSpace.class)
			.addAnnotatedClass(StatisticData.class);
	private static final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties());
	private static final SessionFactory sessionfactory = configuration
			.buildSessionFactory(builder.build());

	protected DAO() {
	}

	protected static Session getSession() {
		Session session = DAO.session.get();
		if (session == null) {
			session = sessionfactory.openSession();
			DAO.session.set(session);
		}
		return session;
	}

	protected static void beginTransaction() {
		getSession().beginTransaction();
	}

	protected static void commitTransaction() {
		getSession().getTransaction().commit();
	}

	protected static void rollback() {
		try {
			System.out.println("Transaction started rolling back");
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println("Transaction Can't roll back");
			e.printStackTrace();
		}
		
		try {
			System.out.println("Session started closing");
			getSession().close();
		} catch (HibernateException e) {
			System.out.println("Session can't close");
			e.printStackTrace();
			System.exit(0);
		} 
	}

	public static void close() {
		getSession().close();
	}

}
