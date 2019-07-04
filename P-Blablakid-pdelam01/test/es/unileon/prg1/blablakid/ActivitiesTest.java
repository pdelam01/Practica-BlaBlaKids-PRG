package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * @author pdelam01
 */
public class ActivitiesTest {
	
	private Activities activities;
	private	Activity baloncesto, musica, frances;
	
	@Before
	public void setUp() throws Exception {
		this.activities=new Activities(3);
		this.baloncesto = new Activity("Baloncesto", "Palomera", 18, 00, 20, 00, WeekDays.MONDAY);
		this.musica = new Activity("Musica", "Conservatorio", 17, 30, 19, 00, WeekDays.TUESDAY);
		this.frances = new Activity("Frances", "EOI", 17, 00, 19, 00, WeekDays.FRIDAY);
		
		this.activities.add(baloncesto);
		this.activities.add(musica);
	}

	
	@Test (expected = BlablakidException.class)
	public void testAddRepeted() throws BlablakidException {
		this.activities.add(baloncesto);
	}
	
	
	@Test (expected = BlablakidException.class)
	public void testAddFull() throws BlablakidException {
		this.activities.add(frances);
		Activity futbol = new Activity("Futbol", "Palomera", 16, 30, 18, 30, WeekDays.WEDNESDAY);
		this.activities.add(futbol);
	}
	
	
	@Test
	public void testAdd() throws BlablakidException {
		
		assertTrue(this.activities.add(frances));
	}

	@Test
	public void testRemove() throws BlablakidException {
		
		boolean deleted = this.activities.remove(baloncesto);
		assertTrue(deleted);
	}
	
	
	@Test (expected = BlablakidException.class)
	public void testRemoveNull() throws BlablakidException {
		this.activities.remove(frances);
	}

	@Test
	public void testIsFull() throws BlablakidException {
		activities.add(frances);
		
		boolean full = activities.isFull();
		assertTrue(full);
	}

	@Test
	public void testExiste() throws BlablakidException {
		assertTrue(this.activities.existe(baloncesto));
	}

	@Test
	public void testBuscar() throws BlablakidException {
		assertNull(this.activities.buscar(frances.getName()));
		assertNotNull(this.activities.add(frances));
	}
	
	@Test
	public void testToString() {
		assertEquals("Baloncesto (Palomera - MONDAY)18:0 > 20:0\nMusica (Conservatorio - TUESDAY)17:30 > 19:0\n", this.activities.toString());
	}

}
