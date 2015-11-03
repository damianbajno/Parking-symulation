package pl.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;

import pl.dao.DAO;
import pl.pojo.Client;

public class ClientDAOTest extends DAO {

	public void persist(Client client) {

		try {
			beginTransaction();
			System.out.println(" Start Persist to DB"); 
			getSession().persist(client);
			System.out.println(" Persisted to DB"); 
			commitTransaction();
			System.out.println(" Persisted Commited to DB"); 
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't persist");
		}

	}

	public void delate(Client client) {
		try {
			beginTransaction();
			getSession().delete(client);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't delete");
		}
	}

	public void saveOrUpdate(Client client) {
		try {
			beginTransaction();
			getSession().saveOrUpdate(client);
			sleep(1);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't saveOrUpdate");
		}
	}

	public void update(Client client) {
		try {
			beginTransaction();
			System.out.println("==== update Beginning==="+client.toString());
			getSession().lock(client, LockMode.PESSIMISTIC_WRITE);
			getSession().update(client);
			sleep(1);
			System.out.println("==== update End===");
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't update");
		}
	}

	private static void sleep(int s) {
		try {
			Thread.sleep(s * 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			beginTransaction();
			System.out.println("        ====Begin Transaction get ALL");
			Query ClientQuery = getSession().createQuery("Select c from Client c");
			clients = (List<Client>) ClientQuery.list();
			System.out.println("        ====End get ALL");
			System.out.println("        ====Commite get ALL Transaction");
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao rollback getAllClient");
		}
		return clients;
	}

	public static Client load(Long id) {
		Client Client = null;
		try {
			beginTransaction();
			Client = (Client) getSession().load(Client.class, id);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDAO couldn't load Client");
		}
		return Client;
	}

	public static Client get(int index) {
		Client client = null;
		try {
			beginTransaction();
			System.out.println("            ==== read Beginning===");
			client=(Client) getSession().get(Client.class, index);
			sleep(1);
			System.out.println("            ==== read End===" + client.toString());
			commitTransaction();
			System.out.println("            ==== read Commite===" + client.toString());
			getSession().clear();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao couldn't get Client");
		}
		return client;
	}
}
