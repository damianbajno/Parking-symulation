package pl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javassist.expr.NewArray;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.mockito.internal.verification.AtMost;

import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class ParkingSpaceDAO extends DAO {
	private static int clientNumber=ClientDAO.getAll().size();
	private static AtomicInteger numberOfSuccessfulTransaction=new AtomicInteger(0);
	
	
	public static void increment() {
		clientNumber++;
	}

	public boolean parkingSpaceMakeFree(int parkingSpace_ID) {
		try {
			beginTransaction();
			ParkingSpace parkingSpace = (ParkingSpace) getSession().get(
					ParkingSpace.class, parkingSpace_ID);
			getSession().persist(new StatisticData(parkingSpace.getClient().getId(), parkingSpace_ID, false));
			parkingSpace.setClient(null);
			commitTransaction();
			System.out
					.println("Successful  " + numberOfSuccessfulTransaction.incrementAndGet());
			return true;
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceDAO couldn't make ParkingSpace "
					+ parkingSpace_ID + " free");
			rollback();
			return false;
		}

	}

	private Client client=null;
	public boolean parkingSpaceMakeOccupy(int parkingSpace_Id) {
		try {
			beginTransaction();
			ParkingSpace parkingSpace = (ParkingSpace) getSession().get(
					ParkingSpace.class, parkingSpace_Id);
			client = getClientWithOutParkingSpace(clientNumber);
			getSession().persist(new StatisticData(client.getId(), parkingSpace_Id, true));
			parkingSpace.setClient(client);
			System.out.println("Successful  " + numberOfSuccessfulTransaction.incrementAndGet());
			commitTransaction();
			getSession().clear();
			return true;
		} catch (HibernateException e) {
			System.out.println(Thread.currentThread().getName()+"  ParkingSpaceDAO couldn't make ParkingSpace "
					+ parkingSpace_Id + " occupy by "+client.getId());
			rollback();
			return false;
		}
	}

	Random random = new Random();
	Client lastClient=new Client();
	
	private Client getClientWithOutParkingSpace(int clientNumbers) {
		Client client = null;
		do {
			client = (Client) getSession().get(Client.class,
					random.nextInt(clientNumbers) + 1);
			System.out.println(Thread.currentThread().getName()+" =======  "+client.getId() + " search client");
		} while (client.reservedParkingSpace() && !lastClient.equals(client));
		lastClient=client;
		getSession().lock(client, LockMode.PESSIMISTIC_FORCE_INCREMENT);
		System.out.println(Thread.currentThread().getName()+" ========= "+client.getId() + " lock client");
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
			System.out.println("ParkingSpaceDAO couldn't get a ParkingSpace.");
			rollback();
		}
		return parkingSpace;
	}

	public void delateOrphan(ParkingSpace ParkingSpace) {
		try {
			beginTransaction();
			getSession().delete(ParkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out
					.println("ParkingSpaceDAO couldn't deleteOrphan ParkingSpace");
		}
	}

	public void delate(ParkingSpace ParkingSpace) {
		try {
			beginTransaction();
			getSession().delete(ParkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't delete ParkingSpace");
		}
	}

	public ParkingSpace load(Long id) {
		ParkingSpace ParkingSpace = null;
		try {
			beginTransaction();
			ParkingSpace = (ParkingSpace) getSession().load(ParkingSpace.class,
					id);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't load ParkingSpace");
		}
		return ParkingSpace;
	}

	public void update(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().update(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't update ParkingSpace");
		}
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
