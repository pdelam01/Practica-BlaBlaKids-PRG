/**
 * @author jflorc01
 *
 */

package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class KidsTest {
	
	private Kids kids;
	private Kid manuel, beatriz, daniel;

	@Before
	public void setUp() throws Exception {
		this.kids=new Kids(3);
		this.beatriz = new Kid("Beatriz");
		this.manuel = new Kid("Manuel");
		this.daniel = new Kid("Daniel");
		this.kids.add(daniel);
		this.kids.add(beatriz);

	}
	
	@Test (expected = BlablakidException.class)
	public void testAddRepeted() throws BlablakidException {
		this.kids.add(beatriz);
	}
	
	@Test (expected = BlablakidException.class)
	public void testAddFull() throws BlablakidException {
		this.kids.add(manuel);
		Kid chema = new Kid("Chema");
		this.kids.add(chema);
	}
	
	@Test
	public void testAdd() throws BlablakidException {
		boolean added = this.kids.add(manuel);
		assertTrue(added);
	}
	
	
	@Test (expected = BlablakidException.class)
	public void testRemoveNULL() throws BlablakidException {
		this.kids.remove(this.manuel);
	}
	
	
	@Test
	public void testRemove() throws BlablakidException {
		boolean remove = this.kids.remove(this.daniel);
		assertTrue(remove);
		
	}

	
	@Test
	public void testIsFull() throws BlablakidException {
		this.kids.add(manuel);
		
		boolean full = this.kids.isFull();
		assertTrue(full);
	}
	
	@Test
	public void testIsNotFull() throws BlablakidException {
		boolean full = this.kids.isFull();
		assertFalse(full);
	}

	@Test
	public void testExiste() throws BlablakidException {
		boolean exists = this.kids.existe(this.beatriz);
		assertTrue(exists);
	}
	
	@Test
	public void testNotExist() throws BlablakidException {
		boolean exist = this.kids.existe(manuel);
		assertFalse(exist);
	}

	
	@Test
	public void testBuscar() throws BlablakidException {
		Kid search = this.kids.buscar(beatriz.getName());
		assertNotNull(search);
	}
	
	@Test
	public void testNotBuscar() throws BlablakidException {
		assertNull(this.kids.buscar(this.manuel.getName()));
	}
	
	@Test
	public void testToString() throws BlablakidException{
		assertEquals("/////////////\nKIDS: \n******Daniel******\n******Beatriz******\n", kids.toString());
	}

}
