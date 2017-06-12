package RemoveDupMakeUnique;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.LinkedList;

public class RemoveDupTest {
	//RemoveDupMakeUnique r = new NotInPlaceSolution();
	//RemoveDupMakeUnique r = new AnotherNotInPlaceSolution();
	RemoveDupMakeUnique r = new InPlaceSolution();
	
	@Test
	public void testEmpty() {
		LinkedList test = new LinkedList();
		r.removeDupMakeUnique(test);
		assertNull(test.head);
		assertEquals(test, new LinkedList());
	}
	
	@Test
	public void testOneValue() {
		LinkedList test = new LinkedList(1);
		r.removeDupMakeUnique(test);
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
		r.removeDupMakeUnique(test);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		
		//other also has 1 2
		LinkedList ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test, ExpectedResult);
		
		//1 2 3
		test.insert(3);
		r.removeDupMakeUnique(test);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		
		ExpectedResult.insert(3);
		assertEquals(test, ExpectedResult);
		
	}
	
	@Test
	public void testDup() {
		//1 1 should be 1
		LinkedList test = new LinkedList(1); test.insert(1);
		r.removeDupMakeUnique(test);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(1));
		
		//3 digits
		
		//1 2 1 should be 1 2
		test = new LinkedList(1); test.insert(2); test.insert(1);
		r.removeDupMakeUnique(test);
		LinkedList ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 2 should be 1 2
		test = new LinkedList(1); test.insert(2); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 1 1 should be 1
		test = new LinkedList(1); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		assertEquals(test.head.data, 1);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(1));
		
		//1 1 2 should be 1 2
		test = new LinkedList(1); test.insert(1); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//4 digits
		
		//two same two different
		//1 1 2 3 -> 1 2 3
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(3);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2); ExpectedResult.insert(3);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 1 3 -> 1 2 3
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(3);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2); ExpectedResult.insert(3);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 3 1 -> 1 2 3
		test = new LinkedList(1); test.insert(2); test.insert(3); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2); ExpectedResult.insert(3);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 1 3 -> 2 1 3
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(3);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1); ExpectedResult.insert(3);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 3 1 -> 2 1 3
		test = new LinkedList(2); test.insert(1); test.insert(3); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1); ExpectedResult.insert(3);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertEquals(test.head.next.next.data, 3);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 3 1 1 -> 2 3 1
		test = new LinkedList(2); test.insert(3); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(3); ExpectedResult.insert(1);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 3);
		assertEquals(test.head.next.next.data, 1);
		assertNull(test.head.next.next.next);
		assertEquals(test, ExpectedResult);
		
		//three same one different
		//1 1 1 2 -> 1 2
		test = new LinkedList(1); test.insert(1); test.insert(1); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 1 2 1 -> 1 2
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 1 1 -> 1 2
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 1 1 -> 2 1
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//one dup (four numbers)
		//1 1 1 1 -> 1
		test = new LinkedList(1); test.insert(1); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		assertEquals(test.head.data, 1);
		assertNull(test.head.next);
		assertEquals(test, new LinkedList(1));
		
		//two pairs of two same numbers
		//1 1 2 2 -> 1 2
		test = new LinkedList(1); test.insert(1); test.insert(2); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 1 2 -> 1 2
		test = new LinkedList(1); test.insert(2); test.insert(1); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//1 2 2 1 -> 1 2
		test = new LinkedList(1); test.insert(2); test.insert(2); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(1); ExpectedResult.insert(2);
		assertEquals(test.head.data, 1);
		assertEquals(test.head.next.data, 2);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 1 2 -> 2 1
		test = new LinkedList(2); test.insert(1); test.insert(1); test.insert(2);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 1 2 1 -> 2 1
		test = new LinkedList(2); test.insert(1); test.insert(2); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
		//2 2 1 1 -> 2 1
		test = new LinkedList(2); test.insert(2); test.insert(1); test.insert(1);
		r.removeDupMakeUnique(test);
		ExpectedResult = new LinkedList(2); ExpectedResult.insert(1);
		assertEquals(test.head.data, 2);
		assertEquals(test.head.next.data, 1);
		assertNull(test.head.next.next);
		assertEquals(test, ExpectedResult);
		
	}

}
