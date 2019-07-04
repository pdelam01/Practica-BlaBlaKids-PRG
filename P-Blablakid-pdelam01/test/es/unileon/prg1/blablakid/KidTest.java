/**
 * @author jflorc01
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class KidTest {
	
	private Kid kid;
	private Activities activities;
	private Activity baloncesto, tenis, musica;
	
	
	@Before
	public void setUp() throws BlablakidException {
		this.kid = new Kid("Daniel");
		this.activities = new Activities(3);
		this.baloncesto = new Activity("Baloncesto", "Palomera", 18, 00, 20, 00, WeekDays.MONDAY);
		this.tenis = new Activity("Tenis", "Palomera", 20, 30, 22, 00, WeekDays.MONDAY);
		this.musica = new Activity("Musica", "Conservatorio", 14, 00, 16, 00, WeekDays.TUESDAY);
		this.kid.add(baloncesto);
		this.kid.add(tenis);
		
	}

	@Test
	public void testKid() throws BlablakidException {
		assertEquals("Daniel", this.kid.getName());
	}
	
	@Test (expected = BlablakidException.class)
	public void testKidNotOk() throws BlablakidException {
		new Kid(" ");
	}

	@Test
	public void testGetName() throws BlablakidException {
		Kid beatriz = new Kid("Beatriz");
		assertEquals("Beatriz",beatriz.getName());
		
	}
	
	@Test
	public void testAddActivity() throws BlablakidException {
		assertTrue(this.kid.add(this.musica));
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotAddActivity() throws BlablakidException {
		this.kid.add(this.musica);
		Activity futbol = new Activity("Futbol", "Pinilla", 19, 30, 21, 30, WeekDays.WEDNESDAY);
		this.kid.add(futbol);
	}
	
	@Test
	public void testRemoveActivity() throws BlablakidException {
		assertTrue(this.kid.remove(baloncesto));
	}
	
	@Test(expected = BlablakidException.class)
	public void testNotRemoveActivity() throws BlablakidException {
		Activity futbol = new Activity("Futbol", "Pinilla", 19, 30, 21, 30, WeekDays.WEDNESDAY);
		this.kid.remove(futbol);
	}
	

	@Test
	public void testToString() throws BlablakidException {
		Kid beatriz = new Kid("Beatriz");
		assertEquals("******Beatriz******",beatriz.toString());
	}

}
