package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DayTest {
	
	private Rides rides;
	private Day day;
	
	@Before
	public void setUp() throws BlablakidException {
		this.rides = new Rides(1);
		this.day = new Day(WeekDays.FRIDAY, this.rides.length());
		
	}

	@Test 
	public void testDay() throws BlablakidException { 	
		assertEquals("FRIDAY", day.getNameDay(4));
		assertEquals(1,this.day.getNumRides());
	}
	
	@Test (expected = BlablakidException.class)
	public void testGetWrongName() throws BlablakidException { 	
		this.day.getNameDay(14);
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongRide() throws BlablakidException { 	
		new Day(WeekDays.FRIDAY, -1);
	}
	
	@Test
	public void testGetNumRides() {
		assertEquals(1,this.day.getNumRides());
	}

	@Test
	public void testToString() {
		assertEquals("FRIDAY",day.toString());
	}
	
	
	@Test
	public void testGetNameDay() throws BlablakidException {
		assertEquals("FRIDAY", day.getNameDay(4));
		assertEquals("MONDAY", day.getNameDay(0));
		assertEquals("TUESDAY", day.getNameDay(1));
		assertEquals("WEDNESDAY", day.getNameDay(2));
		assertEquals("THURSDAY", day.getNameDay(3));
	}

}
