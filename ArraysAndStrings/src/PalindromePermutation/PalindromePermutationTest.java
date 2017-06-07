package PalindromePermutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromePermutationTest {
	//PalindromePermutation p = new HashTableSolution();
	PalindromePermutation p = new Iterative();
	/*
	 * Testing only for regular palindromes without second rule of permutation
	 */
	@Test
	public void testOnlyPalindromes() {
		assertTrue(p.palPermuation("tat"));
		assertTrue(p.palPermuation("race car"));
		assertTrue(p.palPermuation("aaaaaa"));
		assertTrue(p.palPermuation("aaaa aaa"));
		assertTrue(p.palPermuation("aa aaaaaa"));
		
		assertTrue(p.palPermuation("taco cat"));
		assertTrue(p.palPermuation("atco cta"));
	}
	
	
	/*
	 * Testing only for strings that are not palindromes without second rule of permutation
	 */
	@Test
	public void testOnlyIncorrectPalindromes() {
		assertFalse(p.palPermuation("tape"));
		assertFalse(p.palPermuation("tap"));
		assertFalse(p.palPermuation("aaa b"));
		assertFalse(p.palPermuation(" a c"));
	}
	
	@Test
	public void testPalPermutation() {
		assertTrue(p.palPermuation("Tact Coa"));
	}
	
	@Test
	public void testEmpty() {
		assertTrue(p.palPermuation(""));
	}

}
