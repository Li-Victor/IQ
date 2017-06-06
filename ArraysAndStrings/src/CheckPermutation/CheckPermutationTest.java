package CheckPermutation;

import static org.junit.Assert.*;

import org.junit.Test;

//junit test for checkPermutation
public class CheckPermutationTest {

	//CheckPermutation cp = new BruteForce();
	CheckPermutation cp = new BetterSolution();
	@Test
	public void testIsPermutation() {
		assertTrue(cp.CheckPermutation("aa", "aa"));
		assertTrue(cp.CheckPermutation("ab", "ba"));
		assertTrue(cp.CheckPermutation("abc", "cba"));
		assertTrue(cp.CheckPermutation("abc", "abc"));
	}
	
	@Test
	public void testNotPermutation() {
		assertFalse(cp.CheckPermutation("a", "aa"));
		assertFalse(cp.CheckPermutation("aa", "a"));
		assertFalse(cp.CheckPermutation("ab", "cb"));
	}
	
	@Test
	public void testEmpty() {
		assertTrue(cp.CheckPermutation("", ""));
		assertFalse(cp.CheckPermutation("", " "));
	}

}
