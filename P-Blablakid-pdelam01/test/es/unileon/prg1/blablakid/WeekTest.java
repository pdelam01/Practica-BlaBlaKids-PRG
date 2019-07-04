package es.unileon.prg1.blablakid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeekTest {
	
	private Week week;
	private WeekDays day[];
	private int  MAX_DAYS = 5;
	
	@Before
	public void setUp() throws BlablakidException {
		this.week = new Week();
	}

	@Test
	public void testWeek() {
		assertEquals(5,this.MAX_DAYS);
	}

	@Test
	public void testToString() {
		assertEquals("",week.toString());
	}

}
