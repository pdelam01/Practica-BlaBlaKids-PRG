/**
 * @author pdelam01 & jflorc01
 *
 */

package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActivityTest {
	
	private Activities activities;
	private Activity activity;
	private Activity tenis, baloncesto;

	@Before
	public void setUp() throws BlablakidException {
		this.tenis = new Activity("Tenis", "Palomera", 20, 30, 22, 00, WeekDays.MONDAY);
		this.baloncesto = new Activity ("Baloncesto", WeekDays.FRIDAY);
	}
	
	@Test
	public void testActivity() throws BlablakidException {
		assertEquals("Tenis",this.tenis.getName());
		assertEquals("Palomera",this.tenis.getPlace());
		assertEquals(20,this.tenis.getHourStart());
		assertEquals(30,this.tenis.getMinStart());
		assertEquals(22,this.tenis.getHourEnd());
		assertEquals(0,this.tenis.getMinEnd());
		assertEquals(WeekDays.MONDAY,this.tenis.getDay());
	}
	
	@Test
	public void testActivity2() throws BlablakidException{
		assertEquals("Baloncesto",this.baloncesto.getName());
		assertEquals(WeekDays.FRIDAY,this.baloncesto.getDay());
	}
	
	@Test (expected = BlablakidException.class)
	public void testActivityWrongName() throws BlablakidException {
		new Activity (" ","Palomera", 18, 00, 20, 00, WeekDays.MONDAY);
	}
	
	@Test (expected = BlablakidException.class)
	public void testActivityWrongName2() throws BlablakidException {
		new Activity (" ",WeekDays.MONDAY);
	}
	
	@Test (expected = BlablakidException.class)
	public void testActivityWrongPlace() throws BlablakidException {
		new Activity ("Baloncesto", " ", 18, 00, 20, 30, WeekDays.MONDAY);
	}
	
	@Test (expected = BlablakidException.class)
	public void testActivityWrongHours() throws BlablakidException {
		new Activity ("Baloncesto", "Palomera", 21, 00, 20, 00, WeekDays.MONDAY);
	}
	
	@Test (expected = BlablakidException.class)
	public void testActivityWrongMinutes() throws BlablakidException {
		new Activity ("Baloncesto", "Palomera", 18, 20, 18, 00, WeekDays.MONDAY);
	}

	@Test
	public void testGetName() throws BlablakidException {
		assertEquals("Tenis", tenis.getName());
	}

	@Test
	public void testGetPlace() throws BlablakidException {
		assertEquals("Palomera", tenis.getPlace());
	}

	@Test
	public void testGetHourStart() throws BlablakidException {
		assertEquals(20, tenis.getHourStart());
	}
	
	@Test
	public void testGetMinStart() throws BlablakidException {
		assertEquals(30, tenis.getMinStart());
	}

	@Test
	public void testGetHourEnd() throws BlablakidException {
		assertEquals(22, tenis.getHourEnd());
	}
	
	@Test
	public void testGetMinEnd() throws BlablakidException {
		assertEquals(0, tenis.getMinEnd());
	}

	@Test
	public void testGetDay() throws BlablakidException {
		assertEquals(WeekDays.MONDAY, tenis.getDay());
	}

	@Test
	public void testToString() throws BlablakidException {
		assertEquals("Tenis (Palomera - MONDAY)20:30 > 22:0", tenis.toString());
	}

}
