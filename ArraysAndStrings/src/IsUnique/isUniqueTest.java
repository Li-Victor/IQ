package IsUnique;

import static org.junit.Assert.*;

import org.junit.Test;

//junit testign for IsUnique
public class isUniqueTest {
	//IsUnique i = new BruteForce();
	IsUnique i = new BetterSolution();
	@Test
	public void testNotUnique() {
		assertFalse(i.isUnique("aa"));
		assertFalse(i.isUnique("laa"));
		assertFalse(i.isUnique("001"));
	}
	
	@Test
	public void testEmpty() {
		assertTrue(i.isUnique(""));
	}
	
	@Test
	public void testUnique() {
		assertTrue(i.isUnique("abc"));
		assertTrue(i.isUnique("cde"));
		assertTrue(i.isUnique("012"));
	}

}
