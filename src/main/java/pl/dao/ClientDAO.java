package pl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.LockModeType;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;

import pl.pojo.Client;

public class ClientDAO extends DAO {
	

//	public int getNumberOfClients()
//	{
//		try {
//			getSession().beginTransaction();
//			Query numberOfClients = getSession().createQuery("Select Count(c) from Client"); 
//			commitTransaction();
//			return (int) numberOfClients.getFirstResult();
//		} catch (HibernateException e){
//
//			rollback();
//			System.out.println("ClientDao Couldn't get number of clients");
//		}
//
//	}
	
	public void persist(Client client) {

		try {
			beginTransaction();
			getSession().persist(client);
			commitTransaction();
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

	public void update(Client client) {
		try {
			beginTransaction();
			getSession().update(client);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao Couldn't update");
		}
	}

	private void sleep(int s) {
		try {
			Thread.sleep(s*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			beginTransaction();
			Query ClientQuery = getSession().createQuery("Select c from Client c");
			clients = (List<Client>) ClientQuery.list();
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao rollback getAllClient");
		}
		return clients;
	}

	public Client load(Long id) {
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

	public Client get(int index) {
		Client client = null;
		try {
			beginTransaction();
			client = (Client) getSession().get(Client.class, index);
			getSession().lock(client, LockMode.OPTIMISTIC_FORCE_INCREMENT);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao couldn't get Client");
		}
		return client;
	}
	
	public Client getWithoutParkingSpace() {
		Client client = null;
		Random random=new Random();
		try {
			beginTransaction();
			Integer numberOfClients = getSession().createQuery("Select Count(c) from Client c").getFirstResult(); 
//			getSession().get(Client.class, random.nextInt(numberOfClients), LockModeType.OPTIMISTIC);
			getSession().lock(client, LockMode.PESSIMISTIC_FORCE_INCREMENT);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ClientDao couldn't get Client");
		}
		return client;
	}
	
}
