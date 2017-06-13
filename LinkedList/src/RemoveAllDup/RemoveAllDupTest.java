package RemoveAllDup;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.LinkedList;

public class RemoveAllDupTest {
	//RemoveAllDup r = new NotInPlaceSolution();
	RemoveAllDup r = new InPlaceSolution();
	@Test
	public void testEmpty() {
		LinkedList test = new LinkedList();
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
	}
	
	@Test
	public void testOneValue() {
		LinkedList test = new LinkedList(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 1);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(1));
	}
	
	/*
	 * Testing for no duplicates
	 */
	@Test
	public void testNoDup() {
		//1 2
		LinkedList test = new LinkedList(1); test.insert(2);
		r.removeAllDup(test);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		
		//other also has 1 2
		LinkedList ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test, ExpectedResult);
		
		//1 2 3
		test.insert(3);
		r.removeAllDup(test);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		
		ExpectedResult.insert(3);
		assertEquals(test, ExpectedResult);
		
	}
	
	@Test
	public void testDup() {
		//1 1 should be null
		LinkedList test = new LinkedList(1); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//3 digits
		
		//1 2 1 should be 2
		test = new LinkedList(1); test.insert(2); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		//1 2 2 should be 1
		test = new LinkedList(1); test.insert(2); test.insert(2);
		r.removeAllDup(test);
		assertEquals(test.head.data, 1);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(1));
		
		//1 1 1 should be null
		test = new LinkedList(1); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//1 1 2 should be 2
		test = new LinkedList(1); test.insert(1); test.insert(2);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		//4 digits
		
		// two same and two different, ExpectedResult is 2 3
		LinkedList ExpectedResult = new LinkedList(2); ExpectedResult.insert(3);
		
		//1 1 2 3 -> 2 3
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(3);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 1 3 -> 2 3
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(3);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 3 1 -> 2 3
		test = new LinkedList(1); test.insert(2); test.insert(3); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 1 3 -> 2 3
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(3);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 3 1 -> 2 3
		test = new LinkedList(2); test.insert(1); test.insert(3); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 3 1 1 -> 2 3
		test = new LinkedList(2); test.insert(3); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		
		//three same one different, Result should be single node in linkedList
		
		//1 1 1 2 -> 2
		test = new LinkedList(1); test.insert(1); test.insert(1); test.insert(2);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		//1 1 2 1 -> 2
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		//1 2 1 1 -> 2
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		//2 1 1 1 -> 2
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertEquals(test.head.data, 2);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(2));
		
		
		//one dup (four numbers), result should be no nodes in LinkedList
		//1 1 1 1 -> null
		test = new LinkedList(1); test.insert(1); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//two pairs of two same numbers, result should be no nodes in LinkedList
		//1 1 2 2 -> null
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(2);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//1 2 1 2 -> null
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(2);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//1 2 2 1 -> null
		test = new LinkedList(1); test.insert(2); test.insert(2); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//2 1 1 2 -> null
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(2);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//2 1 2 1 -> null
		test = new LinkedList(2); test.insert(1); test.insert(2); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
		//2 2 1 1 -> null
		test = new LinkedList(2); test.insert(2); test.insert(1); test.insert(1);
		r.removeAllDup(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
		
	}

}
