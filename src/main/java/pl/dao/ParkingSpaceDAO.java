package pl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javassist.expr.NewArray;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mockito.internal.verification.AtMost;

import pl.panel.ParkingSpacesTextBoard;
import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class ParkingSpaceDAO extends DAO {
	
    	private static int clientNumbers = ClientDAO.getAll().size();
	private ParkingSpacesTextBoard parkingSpacesTextBoard=ParkingSpacesTextBoard.getInstance();
	
	public static ParkingSpaceDAO getInstance() {
		return new ParkingSpaceDAO();
	}

	private ParkingSpaceDAO() {
	}

	public int parkingSpaceMakeFree(int parkingSpaceId) {
		try {
			beginTransaction();

			ParkingSpace parkingSpace = (ParkingSpace) getSession().get(
					ParkingSpace.class, parkingSpaceId);
			int clientNumber = parkingSpace.getClient().getId();
			parkingSpace.setClient(null);

			commitTransaction();
			return clientNumber;
		} catch (HibernateException e) {
			e.getStackTrace();
			rollback();

			System.out.println(Thread.currentThread().getName()+" ParkingSpaceDAO couldn't make ParkingSpace nr. "
					+ parkingSpaceId + " free");
			return 0;
		}

	}

	public int parkingSpaceMakeOccupy(int parkingSpaceId) {
		Client client = null;
		try {
			beginTransaction();

			ParkingSpace parkingSpace = (ParkingSpace) getSession().get(
					ParkingSpace.class, parkingSpaceId);
			client = getClientWithOutParkingSpace(clientNumbers);
			parkingSpace.setClient(client);

			commitTransaction();
			return client.getId();

		} catch (HibernateException e) {

			System.out.println(Thread.currentThread().getName()
					+ "  ParkingSpaceDAO couldn't make ParkingSpace nr. "
					+ parkingSpaceId + " occupy by client nr. " + client.getId());
			e.getStackTrace();

			rollback();
			return 0;

		}
	}

	private Client getClientWithOutParkingSpace(int numberOfClients) {
		Client client = null;
		Random random = new Random();

		do {
			int clientNumber = random.nextInt(numberOfClients) + 1;
			client = (Client) getSession().get(Client.class, clientNumber);
		} while (client.reservedParkingSpace());

		getSession().lock(client, LockMode.OPTIMISTIC_FORCE_INCREMENT);
		return client;
	}

	public void saveOrUpdate(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().saveOrUpdate(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			System.out
					.println("ParkingSpaceDAO couldn't saveOrUpdate a ParkingSpace.");
			rollback();
		}
	}

	public void persist(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().persist(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			System.out
					.println("ParkingSpaceDAO couldn't persiste a ParkingSpace.");
			rollback();
		}
	}

	public ParkingSpace get(int id) {
		ParkingSpace parkingSpace = null;
		try {
			beginTransaction();
			parkingSpace = (ParkingSpace) getSession().get(ParkingSpace.class,
					id);
			commitTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
		    	System.out.println("ParkingSpaceDAO couldn't get a ParkingSpace.");
			rollback();
		}
		return parkingSpace;
	}

	public List<ParkingSpace> getAll() {
		List<ParkingSpace> ParkingSpaces = new ArrayList<ParkingSpace>();
		try {
			beginTransaction();
			Query ParkingSpaceQuery = getSession().createQuery(
					"Select w from ParkingSpace w");
			ParkingSpaces = (List<ParkingSpace>) ParkingSpaceQuery.list();
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't get All ParkingSpace");
		}
		return ParkingSpaces;

	}

}
