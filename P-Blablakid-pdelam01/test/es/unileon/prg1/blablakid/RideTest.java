/**
 * @author defernv04
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RideTest {
	
	public Ride ride;
	public Ride ride1;
	public Parents parents;
	public Parent eva, pedro;
	
	

	@Before
	public void setUp() throws Exception {
		this.ride = new Ride("Tenis", WeekDays.MONDAY, "Casa", "Palomera", 20, 00, 20, 30);
		this.ride1 = new Ride(WeekDays.MONDAY, "Casa", "Palomera");
		this.parents = new Parents(2);
		this.eva = new Parent("Eva");
		this.pedro = new Parent("Pedro");
		this.parents.add(eva);
		
	
	}

	@Test
	public void testRide() {
		assertEquals("Tenis", ride.getNameActivity());
		assertEquals(WeekDays.MONDAY, ride.getDay());
		assertEquals("Casa", ride.getPlaceStart());
		assertEquals("Palomera", ride.getPlaceEnd());
		assertEquals(20, ride.getHourStart());
		assertEquals(0, ride.getMinStart());
		assertEquals(20, ride.getHourEnd());
		assertEquals(30, ride.getMinEnd());		
	}
	
	@Test (expected = BlablakidException.class)
	public void testGetWrongNameActivity() throws BlablakidException {
		new Ride (" ", WeekDays.FRIDAY, "Casa", "Leon Plaza", 18, 00, 18, 30);
	}
	
	@Test (expected = BlablakidException.class)
	public void testGetWrongPlaceStart1() throws BlablakidException {
		new Ride (WeekDays.FRIDAY, " ", "Leon Plaza");
	}
	
	@Test (expected = BlablakidException.class)
	public void testGetWrongPlaceEnd1() throws BlablakidException {
		new Ride (WeekDays.FRIDAY, "Casa", " ");
	}

	@Test (expected = BlablakidException.class)
	public void testWrongPlaceStart() throws BlablakidException {
		new Ride ("Futbol ", WeekDays.FRIDAY, " ", "Leon Plaza", 18, 00, 18, 30);
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongPlaceEnd() throws BlablakidException {
		new Ride ("Futbol", WeekDays.FRIDAY, "Casa", " ", 18, 00, 18, 30);
	}
	
	@Test (expected = BlablakidException.class)
	public void testSamePlaces() throws BlablakidException {
		new Ride ("Futbol", WeekDays.FRIDAY, "Casa", "Casa", 18, 00, 18, 30);
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongHour() throws BlablakidException {
		new Ride ("Futbol", WeekDays.FRIDAY, "Casa", "Leon Plaza", 18, 00, 17, 30);
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongMins() throws BlablakidException {
		new Ride ("Futbol", WeekDays.FRIDAY, "Casa", "Leon Plaza", 18, 30, 18, 00);
	}
	
	@Test (expected = BlablakidException.class)
	public void testSameTime() throws BlablakidException {
		new Ride ("Futbol", WeekDays.FRIDAY, "Casa", "Leon Plaza", 18, 00, 18, 00);
	}
	
	@Test
	public void testRide1() {	
		assertEquals(WeekDays.MONDAY, ride.getDay());
		assertEquals("Casa", ride.getPlaceStart());
		assertEquals("Palomera", ride.getPlaceEnd());	
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongPlaceStart1() throws BlablakidException {
		new Ride (WeekDays.FRIDAY, " ", "Leon Plaza");
	}
	
	@Test (expected = BlablakidException.class)
	public void testWrongPlaceEnd1() throws BlablakidException {
		new Ride (WeekDays.FRIDAY, "Casa", " ");
	}
	
	@Test
	public void testGetNameActivity() {
		assertEquals("Tenis", ride.getNameActivity());
	}
	
	@Test
	public void testDay() {
		assertEquals(WeekDays.MONDAY, ride.getDay());
	}

	@Test
	public void testGetPlaceStart() {
		assertEquals("Casa", ride.getPlaceStart());
	}
	
	@Test
	public void testGetPlaceEnd() {
		assertEquals("Palomera", ride.getPlaceEnd());
	}

	@Test
	public void testGetHourStart() {
		assertEquals(20, ride.getHourStart());
	}
	
	@Test
	public void testGetMinStart() {
		assertEquals(0, ride.getMinStart());
	}
	
	@Test
	public void testGetHourEnd() {
		assertEquals(20, ride.getHourEnd());
	}

	@Test
	public void testGetMinEnd() {
		assertEquals(30, ride.getMinEnd());
	}

	@Test
	public void testToString() {
		assertEquals("Casa > Palomera : 20:0/20:30", ride.toString());
	}

}
