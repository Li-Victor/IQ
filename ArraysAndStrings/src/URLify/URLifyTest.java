package URLify;

import static org.junit.Assert.*;

import org.junit.Test;

public class URLifyTest {
	URLify urlify = new IterativeSolution();
	
	@Test
	public void testStringWithSpaces() {
		String message = "Mr John Smith";
		String result = urlify.URLify(message, message.length());
		assertEquals("Mr John Smith should turn into Mr%20John%20Smith", result, "Mr%20John%20Smith");
	}
	
	@Test
	public void testStringEndWithSpace() {
		String message = "aaa ";
		String result = urlify.URLify(message, message.length());
		assertEquals("aaa  should turn into aaa%20", result, "aaa%20");
	}
	
	@Test
	public void testStringStartWithSpace() {
		String message = " aaa";
		String result = urlify.URLify(message, message.length());
		assertEquals(" aaa should turn into %20aaa", result, "%20aaa");
	}
	
	@Test
	public void testStringOnlySpaces() {
		String message = " ";
		String result = urlify.URLify(message, message.length());
		assertEquals("one space should turn into %20", result, "%20");
		
		message = "  ";
		result = urlify.URLify(message, message.length());
		assertEquals("two spaces should turn into %20%20", result, "%20%20");
	}
	
	@Test
	public void testEmpty() {
		String message = "";
		String result = urlify.URLify(message, message.length());
		assertEquals("empty should turn into empty", result, "");
	}

}
