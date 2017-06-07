package OneAway;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneAwayTest {
	//OneAway o = new MySolution();
	OneAway o = new SolutionWithIndex();
	@Test
	public void testOneAwayInsert() {
		assertTrue(o.OneAway("pal", "pale"));
		assertTrue(o.OneAway("pale", "pales"));
		assertTrue(o.OneAway("bake", "bake "));
		assertTrue(o.OneAway("bake", " bake"));
	}
	
	@Test
	public void testOneAwayRemove() {
		assertTrue(o.OneAway("pale", "pal"));
		assertTrue(o.OneAway("pales", "pale"));
		assertTrue(o.OneAway(" bake", "bake"));
		assertTrue(o.OneAway("bake ", "bake"));
	}
	
	@Test
	public void testOneAwayReplace() {
		assertTrue(o.OneAway("pale", "bale"));
		assertTrue(o.OneAway("bake", "bale"));
		assertTrue(o.OneAway(" car", "scar"));
		assertTrue(o.OneAway("bas ", "bass"));
	}
	
	@Test
	public void testSame() {
		assertFalse(o.OneAway("pale", "pale"));
	}
	
	@Test
	public void testMoreThanOne() {
		assertFalse(o.OneAway("pale", "bake"));
		assertFalse(o.OneAway("pale", " bale"));
		assertFalse(o.OneAway("pale", "pale  "));
		assertFalse(o.OneAway("  pale", "pale"));
	}

}
