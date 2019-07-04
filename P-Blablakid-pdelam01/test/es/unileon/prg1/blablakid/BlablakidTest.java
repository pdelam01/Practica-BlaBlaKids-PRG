package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlablakidTest {
	
	private Blablakid blablakid;
	private Kids kids;
	private Parents parents;
	private Activities activities;
	private Rides rides;
	private	Kid manuel, daniel;
	private Parent pedro, eva, juan, ana;
	private Activity futbol, tenis, baloncesto;
	private Ride ride1, ride2;

	@Before
	public void setUp() throws BlablakidException {
		this.kids = new Kids(2);
		this.parents = new Parents(4);
		this.activities = new Activities(3);
		this.manuel = new Kid("Manuel");
		this.daniel = new Kid("Daniel");
		
		this.pedro = new Parent("Pedro");
		this.eva = new Parent("Eva");
		this.juan = new Parent("Juan");
		this.ana = new Parent("Ana");
		
		this.futbol = new Activity("Futbol", "Pinilla", 18, 00, 20, 00, WeekDays.TUESDAY);
		this.tenis = new Activity("Tenis", "Palomera", 18, 00, 20, 00, WeekDays.FRIDAY);
		this.baloncesto = new Activity("Futbol", "Eras", 20, 00, 22, 00, WeekDays.THURSDAY);
		
		this.ride1 = new Ride("Futbol", WeekDays.MONDAY, "Casa", "Palomera", 17, 30, 18, 00);
		this.ride2 = new Ride("Futbol", WeekDays.MONDAY, "Palomera", "Casa", 20, 00, 20, 30);
		
		this.kids.add(daniel);
		this.parents.add(pedro);
		this.parents.add(eva);
		this.parents.add(juan);
		this.activities.add(futbol);
		this.activities.add(tenis);
	}
	
	@Test
	public void testAddKid() throws BlablakidException {
		this.blablakid.add(manuel);
		assertEquals("/////////////\nKIDS: \n******Daniel******\n******Manuel******\n",kids.toString());
	}
	
	@Test
	public void testRemoveKid() throws BlablakidException{
		this.blablakid.remove(daniel);
		assertEquals("/////////////\nKIDS: \n",kids.toString());
	}
	
	@Test
	public void testAddParent() throws BlablakidException{
		this.blablakid.add(ana);
		assertEquals("PARENTS: \n### Pedro ###\n### Eva ###\n### Juan ###\n### Ana ###\n/////////////\n",parents.toString());
	}
	
	@Test
	public void testRemoveParent() throws BlablakidException{
		this.blablakid.remove(pedro);
		assertEquals("PARENTS: \n### Eva ###\n### Juan ###\n/////////////\n",parents.toString());
	}
	
	@Test
	public void testAddActivity() throws BlablakidException{
		this.blablakid.add(baloncesto, daniel.getName());
		assertEquals("Futbol (Pinilla - TUESDAY)18:0 > 20:0\nTenis (Palomera - FRIDAY)18:0 > 20:0\n",activities.toString());
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotAddActivity() throws BlablakidException {
		this.blablakid.add(baloncesto, manuel.getName());
	}
	
	@Test
	public void testRemoveActivity() throws BlablakidException{
		this.blablakid.remove(futbol, daniel.getName());
		assertEquals("Tenis (Palomera - FRIDAY)18:0 > 20:0\n",activities.toString());
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotRemoveActivity() throws BlablakidException{
		this.blablakid.remove(futbol, "Jaun");
	}

	@Test
	public void testAddRide() throws BlablakidException {
		this.blablakid.add(ride2, daniel.getName(), pedro.getName());
		assertEquals("Casa > Palomera : 17:30/18:0\nPalomera > Casa : 20:0/20:30\n",rides.toString());
	}
	
	
	@Test (expected = BlablakidException.class)
	public void testNotAddRideKid() throws BlablakidException {
		this.blablakid.add(ride2, manuel.getName(), pedro.getName());
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotAddRideParent() throws BlablakidException {
		this.blablakid.add(ride2, daniel.getName(), ana.getName());
	}
	
	@Test
	public void testRemoveRide() throws BlablakidException {
		this.blablakid.remove(ride1, pedro.getName());
		assertEquals("",rides.toString());
	}
	
	@Test (expected = BlablakidException.class)
	public void testNotRemoveRideParent() throws BlablakidException {
		this.blablakid.remove(ride1, ana.getName());
	}
}
