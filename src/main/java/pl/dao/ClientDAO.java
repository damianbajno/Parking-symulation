package pl.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import pl.pojo.Client;

public class ClientDAO extends DAO {

	public static void persist(Client client) {

		try {
			beginTransaction();
			getSession().persist(client);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't persist");
		}

	}

	public static void delate(Client client) {
		try {
			beginTransaction();
			getSession().delete(client);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't delete");
		}
	}

	public static void updateOrUpdate(Client client) {
		try {
			beginTransaction();
			getSession().saveOrUpdate(client);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't update");
		}
	}

	public static List<Client> getAll() {
		List<Client> Clients = new ArrayList<Client>();
		try {
			beginTransaction();
			Query ClientQuery = getSession().createQuery(
					"Select c from Client c");
			Clients = (List<Client>) ClientQuery.list();
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao rollback getAllClient");
		}
		return Clients;
	}
	public static Client load(Long id) {
		Client Client=null;
		try {
			beginTransaction();
			Client= (Client) getSession().load(Client.class, id);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDAO couldn't load Client");
		}
		return Client;
	}

	public static Client get(int index) {
		Client Client = null;
		try {
			beginTransaction();
			Client = (Client) getSession().get(Client.class,
					Long.valueOf(index));
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao couldn't get Client");
		}
		return Client;
	}
}
