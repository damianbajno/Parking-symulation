package pl.dao;

import org.hibernate.HibernateException;

import pl.pojo.StatisticData;

public class StatisticDataDAO extends DAO {

	public StatisticDataDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void persist(int clientNumber, int parkingNumber) {
		try {
			beginTransaction();

//			StatisticData parkingSpaceClientStatisticData = new StatisticData(clientNumber, parkingNumber);
//			getSession().persist(parkingSpaceClientStatisticData);

			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceClientStatisticDAO couldn't persist");
			rollback();
		}
	}

	public static void persist(StatisticData parkingSpaceClientStatisticData) {
		try {
			beginTransaction();
			
			getSession().persist(parkingSpaceClientStatisticData);
			
			commitTransaction();
		} catch (HibernateException e) {
			System.out.println("ParkingSpaceClientStatisticDAO couldn't persist");
			rollback();
		}
	}
}
