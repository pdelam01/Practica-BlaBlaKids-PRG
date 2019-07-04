/**
 * @author defernv04
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RidesTest {
	
	private Rides rides;
	private Activities activities;
	private Activity tenis;
	private Ride palomera, casa;
	
	@Before
	public void setUp() throws Exception {
		this.rides = new Rides (2);
		this.tenis = new Activity("Tenis", "Palomera", 20, 30, 22, 00, WeekDays.MONDAY);
		this.palomera = new Ride("Tenis", WeekDays.MONDAY, "Casa", "Palomera", 20, 00, 20, 30);
		this.casa = new Ride("Tenis", WeekDays.TUESDAY,"Palomera","Casa", 22, 00, 22, 30);
		this.rides.add(this.palomera);
	}

	@Test
	public void testAdd() throws BlablakidException {
		boolean add = this.rides.add(this.casa);
		assertTrue(add);
	}
	
	@Test (expected = BlablakidException.class)
	public void testAdd1() throws BlablakidException {
		this.rides.add(this.palomera);
	}
	
	@Test (expected = BlablakidException.class)
	public void testRemove1() throws BlablakidException {
		this.rides.remove(this.casa);
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotAdd() throws BlablakidException {
		this.rides.add(this.casa);
		Ride pinilla = new Ride("Futbol", WeekDays.MONDAY, "Casa", "Pinilla", 20, 0, 20, 20);
		boolean add = this.rides.add(pinilla);
		assertTrue(add);
	}

	@Test
	public void testRemove() throws BlablakidException {
		boolean remove = this.rides.remove(this.palomera);
		assertTrue(remove);
	}

	@Test
	public void testIsFull() throws BlablakidException {
		this.rides.add(this.casa);
		boolean isFull = this.rides.isFull();
		assertTrue(isFull);
	}
	@Test
	public void testIsNotFull() throws BlablakidException {
		assertFalse(this.rides.isFull());
	}
	
	@Test
	public void testExiste() throws BlablakidException {
		boolean exist = this.rides.existe(palomera);
		assertTrue(exist);
	}
	
	@Test
	public void testNotExist() throws BlablakidException {
		Ride newRide = new Ride("Futbol", WeekDays.FRIDAY, "Casa", "Leon Plaza", 18, 00, 18, 30);
		boolean exist = this.rides.existe(newRide);
		assertFalse(exist);
	}

	@Test
	public void testBuscar() throws BlablakidException {
		Ride buscar;
		buscar = this.rides.buscar(palomera.getNameActivity(), palomera.getDay(), palomera.getPlaceStart(), palomera.getPlaceEnd(), palomera.getHourStart(), palomera.getMinStart(), palomera.getHourEnd(), palomera.getMinEnd());
		assertNotNull(buscar);
	}
	
	@Test
	public void testNotBuscar() throws BlablakidException {
		Ride buscar = this.rides.buscar("Palomera", WeekDays.THURSDAY, "Casa", "Centro Comercial", 20, 00, 20, 30);
		assertNull(buscar);
	}
	
	@Test 
	public void testLength() {
		assertEquals(2,this.rides.length());
	}
	
	@Test
	public void testToString() {
		assertEquals("Casa > Palomera : 20:0/20:30\n",this.rides.toString());
	}

}
