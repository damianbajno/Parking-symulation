package pl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import pl.pojo.Client;
import pl.pojo.ParkingSpace;

public class ParkingSpaceDAO extends DAO {

	
	public ParkingSpaceDAO() {
		super();
	}

	public synchronized static void parkingSpaceMakeFree(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			Client client = parkingSpace.getClient();
			parkingSpace.setClient(null);
			getSession().update(client);
			getSession().update(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ClientDAO couldn't change client ParkingSpace");
			rollback();
		}

	}
	public synchronized static void parkingSpaceMakeOccupy(ParkingSpace parkingSpace, Client client) {
		try {
			beginTransaction();
			parkingSpace.setClient(client);
			getSession().update(parkingSpace);
			getSession().flush();
			commitTransaction();
			getSession().clear();
		} catch (HibernateException e) {
			System.out.println("ClientDAO couldn't change client ParkingSpace");
			rollback();
		}

	}
	

	public static void saveOrUpdate(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().saveOrUpdate(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceDAO couldn't saveOrUpdate a ParkingSpace.");
			rollback();
		}
	}

	public static void persist(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().persist(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceDAO couldn't persiste a ParkingSpace.");
			rollback();
		}
	}

	public synchronized static ParkingSpace get(int id) {
		ParkingSpace parkingSpace = null;
		try {
			beginTransaction();
			parkingSpace = (ParkingSpace) getSession().get(ParkingSpace.class, id);
			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceDAO couldn't get a ParkingSpace.");
			rollback();
		}
		return parkingSpace;
	}

	public static void delateOrphan(ParkingSpace ParkingSpace) {
		try {
			beginTransaction();
			getSession().delete(ParkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't deleteOrphan ParkingSpace");
		}
	}

	public static void delate(ParkingSpace ParkingSpace) {
		try {
			beginTransaction();
			getSession().delete(ParkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't delete ParkingSpace");
		}
	}

	public static ParkingSpace load(Long id) {
		ParkingSpace ParkingSpace = null;
		try {
			beginTransaction();
			ParkingSpace = (ParkingSpace) getSession().load(ParkingSpace.class, id);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't load ParkingSpace");
		}
		return ParkingSpace;
	}

	public static void update(ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			getSession().update(parkingSpace);
			commitTransaction();
		} catch (HibernateException e) {
			rollback();
			System.out.println("ParkingSpaceDAO couldn't update ParkingSpace");
		}
	}

	public static List<ParkingSpace> getAll() {
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
