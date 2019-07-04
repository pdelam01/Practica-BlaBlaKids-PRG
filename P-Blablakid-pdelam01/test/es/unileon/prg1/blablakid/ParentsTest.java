/**
 * @author jflorc01
 */
package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParentsTest {

	private Parents parents;
	private Parent pedro, eva, ana, juan; 
	
	@Before
	public void setUp() throws Exception {
		this.parents = new Parents(4);
		
		this.pedro = new Parent("Pedro");
		this.eva = new Parent("Eva");
		this.ana = new Parent("Ana");
		this.juan = new Parent("Juan");
		
		this.parents.add(pedro);
	}
	
	@Test(expected = BlablakidException.class)
	public void testAddRepeted() throws BlablakidException {
		this.parents.add(pedro);
	}
	
	@Test(expected = BlablakidException.class)
	public void testAddFull() throws BlablakidException {
		this.parents.add(eva);
		this.parents.add(ana);
		this.parents.add(juan);
		
		
		Parent manuel = new Parent("manuel");
		
		this.parents.add(manuel);
	}
	
	@Test
	public void testAdd() throws BlablakidException {
		boolean add = parents.add(eva);
		
		assertTrue(add);
	}
	
	@Test (expected = BlablakidException.class)
	public void testRemoveNull() throws BlablakidException {
		this.parents.remove(eva);
	}
	
	@Test
	public void testRemove() throws BlablakidException {
		this.parents.remove(pedro);
	}

	@Test
	public void testIsFull() throws BlablakidException {
		this.parents.add(eva);
		this.parents.add(ana);
		this.parents.add(juan);
		
		boolean full = this.parents.isFull();
		
		assertTrue(full);
		}

	@Test
	public void testExiste() throws BlablakidException {
		boolean exists = this.parents.existe(pedro);
		
		assertTrue(exists);
	}
	
	
	@Test
	public void testBuscar() throws BlablakidException {
		Parent search = this.parents.buscar(pedro.getName());
		
		assertNotNull(search);
	}
	
	@Test
	public void testToString() {
		assertEquals("PARENTS: \n### Pedro ###\n/////////////\n",this.parents.toString());
	}

}
