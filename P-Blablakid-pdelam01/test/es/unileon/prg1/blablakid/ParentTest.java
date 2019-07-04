/**
 * @author jflorc01
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentTest {
	
	private Week week1;
	private Parent eva, pedro;
	private Kids kids;
	private Kid daniel, beatriz;
	private Rides rides;
	private Ride ride;
	
	@Before
	public void setUp() throws BlablakidException {
		this.eva = new Parent("Eva");
		this.kids = new Kids(2);
		this.rides = new Rides(1);
		this.daniel = new Kid("Daniel");
		this.beatriz = new Kid ("Beatriz");
		
		Ride ride = new Ride("Tenis", WeekDays.MONDAY, "Casa", "Palomera", 20, 00, 20, 30);
		this.kids.add(daniel);
		
	}
	
	public void testParent1() {
		assertEquals("Pedro",pedro.getName());
	}

	@Test
	public void testParent2() {
		assertEquals("Eva", eva.getName());
	}
	
	@Test (expected = BlablakidException.class)
	public void testParentNotOk() throws BlablakidException {
		new Parent (" ");
	}

	@Test
	public void testGetName() {
		assertEquals("Eva", eva.getName());
	}

//	@Test
//	public void testAddKid() throws BlablakidException {
//		assertTrue(this.eva.add(beatriz));
//	}
//	
//	@Test (expected = BlablakidException.class)
//	public void testAddKidNotOk() throws BlablakidException {
//		this.eva.add(beatriz);
//		Kid manuel = new Kid ("Manuel");
//		this.kids.add(manuel);
//		
//	}
	
	@Test
	public void testAddRide() throws BlablakidException {
		assertTrue(this.rides.add(ride));
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddRideNotOk() throws BlablakidException {
		Ride ride1 = new Ride("Tenis", WeekDays.MONDAY, "Palomera", "Casa", 21, 00, 21, 30);
		assertTrue(this.rides.add(ride1));
	}

	@Test
	public void testRemoveRide() throws BlablakidException {
		assertTrue(this.rides.remove(ride));
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotRemove() throws BlablakidException {
		Ride ride1 = new Ride("Tenis", WeekDays.MONDAY, "Palomera", "Casa", 21, 00, 21, 30);
		assertTrue(this.rides.remove(ride1));
	}

	@Test
	public void testToString() {
		assertEquals("### Eva ###", eva.toString());
	}

}