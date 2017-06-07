package StringCompression;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCompressionTest {
	StringCompression s = new Iterative();
	@Test
	public void testSingleLetter() {
		assertEquals("a should be a", s.StringCompression("a"), "a");
		assertEquals("A should be A", s.StringCompression("A"), "A");
	}
	
	@Test
	public void testReturnOriginalString() {
		assertEquals("aa should be aa", s.StringCompression("aa"), "aa");
		assertEquals("AA should be AA", s.StringCompression("AA"), "AA");
		assertEquals("abcd should be abcd", s.StringCompression("abcd"), "abcd");
	}
	
	@Test
	public void testReturnCompressedString() {
		assertEquals("aabccccaaa should be a2b1c4a3", s.StringCompression("aabccccaaa"), "a2b1c4a3");
		assertEquals("abbcccdddd should be a1b2c3d4", s.StringCompression("abbcccdddd"), "a1b2c3d4");
		assertEquals("aaaabbbccd should be a4b3c2d1", s.StringCompression("aaaabbbccd"), "a4b3c2d1");
	}
	

}
