package StringRotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringRotationTest {
	StringRotation s = new Iterative();
	
	@Test
	public void testEmpty() {
		assertTrue(s.stringRotation("", ""));
		assertFalse(s.stringRotation("", " "));
		
		assertFalse(s.stringRotation("", " a"));
		assertFalse(s.stringRotation("", "a "));
	}
	
	@Test
	public void testNotSameLength() {
		assertFalse(s.stringRotation("a", "aa"));
		assertFalse(s.stringRotation("aa", "aaa"));
		
		assertFalse(s.stringRotation("aaa", "aa"));
		assertFalse(s.stringRotation("aa", "a"));
	}
	
	@Test
	public void testCorrect() {
		assertTrue(s.stringRotation("erbottlewat", "waterbottle"));
		assertTrue(s.stringRotation("bottlewater", "waterbottle"));
		assertTrue(s.stringRotation("waterbottle", "waterbottle"));
		assertTrue(s.stringRotation("racecar", "racecar"));
		assertTrue(s.stringRotation("abc", "cab"));
	}
	
	@Test
	public void testInCorrect() {
		assertFalse(s.stringRotation("eroottlewat", "waterbottle"));
		assertFalse(s.stringRotation("a", "b"));
		assertFalse(s.stringRotation("ab", "cd"));
		
	}

}
