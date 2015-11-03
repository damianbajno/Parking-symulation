package pl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javassist.expr.NewArray;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import pl.pojo.Client;
import pl.pojo.ParkingSpace;
import pl.pojo.StatisticData;

public class ParkingSpaceDAO extends DAO {

	public ParkingSpaceDAO() {
		super();
	}

	public boolean parkingSpaceMakeFree(
			ParkingSpace parkingSpace) {
		try {
			beginTransaction();
			Client client = parkingSpace.getClient();
			parkingSpace.setClient(null);
			getSession().update(client);
			getSession().update(parkingSpace);
			commitTransaction();
			return true;
		} catch (HibernateException e) {
			System.out.println("ClientDAO couldn't change client ParkingSpace");
			rollback();
			return false;
		}

	}

	public boolean parkingSpaceMakeOccupy(
			ParkingSpace parkingSpace, Client client) {
		try {
			beginTransaction();
			StatisticData statisticData = new StatisticData(
					client.getId(), parkingSpace.getParkingNumber());

			parkingSpace.setClient(client);
			getSession().update(parkingSpace);
			getSession().persist(statisticData);

			commitTransaction();
			getSession().clear();
			return true;
		} catch (HibernateException e) {
			System.out.println("ClientDAO couldn't change client ParkingSpace");
			rollback();
			return false;
		}

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
