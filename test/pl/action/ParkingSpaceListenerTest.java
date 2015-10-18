package pl.action;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

public class ParkingSpaceListenerTest {
	
	
	ParkingSpaceListener parkingSpaceListener=new ParkingSpaceListener();
	
	
	@Test
	public void testActionPerformed() {
		parkingSpaceListener.actionPerformed(e);
	}

	@Test
	public void testGetSelectedParkingSpace() {
	}

}
