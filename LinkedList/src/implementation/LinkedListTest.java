package Implementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	/*
	 * creating a new LinkedList
	 */
	@Test
	public void testNewLinkedList() {
		LinkedList l = new LinkedList();
		assertNull(l.head);
		
		l = new LinkedList(0);
		assertNotNull(l.head);
		assertEquals(l.head.data, 0);
		
	}
	
	/*
	 * Insert method of LinkedList
	 * append to tail of LinkedList
	 */
	@Test
	public void testInsert() {
		LinkedList l = new LinkedList();
		l.insert(0);
		assertNotNull(l.head);
		assertEquals(l.head.data, 0);
		assertNull(l.head.next);
		
		l.insert(1);
		assertNotNull(l.head.next);
		assertEquals(l.head.next.data, 1);
		assertNull(l.head.next.next);
		
		l.insert(2);
		assertNotNull(l.head.next.next);
		assertEquals(l.head.next.next.data, 2);
		assertNull(l.head.next.next.next);
		
	}
	
	/*
	 * Delete method of LinkedList
	 * deleting first instance of number, if not found does nothing
	 */
	@Test
	public void testDelete() {
		//test delete in empty
		LinkedList l = new LinkedList();
		l.delete(0);
		assertNull(l.head);
		
		//insert and then delete
		l.insert(0);
		l.delete(0);
		assertNull(l.head);
		
		//Having two values and delete from front
		l.insert(1); l.insert(2);
		l.delete(1);
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		assertNull(l.head.next);
		
		//Having two values and delete from back
		l.insert(3);
		l.delete(3);
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		assertNull(l.head.next);
		
		//delete wrong number, LinkedList: 2
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		
		//delete to empty, empty LinkedList now
		l.delete(2);
		assertNull(l.head);
		
		//two values and delete front then back
		l.insert(4); l.insert(5);
		l.delete(4); l.delete(5);
		assertNull(l.head);
		
		//two values and delete then front
		l.insert(6); l.insert(7);
		l.delete(7); l.delete(6);
		assertNull(l.head);
		
		//insert three values
		l.insert(8); l.insert(9); l.insert(10);
		
		//delete wrong value
		l.delete(11);
		assertEquals(l.head.data, 8); assertEquals(l.head.next.data, 9); assertEquals(l.head.next.next.data, 10);
		assertNull(l.head.next.next.next);
		
		//delete middle value
		l.delete(9);
		assertEquals(l.head.data, 8); assertEquals(l.head.next.data, 10);
		assertNull(l.head.next.next);
		
	}
	
	/*
	 * equals method
	 * comparing two LinkedLists
	 */
	@Test
	public void testEquals() {
		//two are null
		LinkedList one = new LinkedList();
		LinkedList other = new LinkedList();
		assertTrue(one.equals(other));
		
		//one has one value and other does not
		one = new LinkedList(0);
		assertFalse(one.equals(other));
		
		//other has one value and one does not
		one = new LinkedList();
		other = new LinkedList(0);
		assertFalse(one.equals(other));
		
		//insert to one, makes this equal
		one.insert(0);
		assertTrue(one.equals(other));
		
		//insert into both different values
		one.insert(1);
		one.insert(2);
		assertFalse(one.equals(other));
		
	}
	
	/*
	 * search function for LinkedList
	 * search for number in LinkedList, return true or false
	 */
	@Test
	public void testSearch() {
		
		//search in empty LinkedList
		LinkedList l = new LinkedList();
		assertFalse(l.search(0));
		
		//one value and then search right and wrong value
		l.insert(0);
		assertTrue(l.search(0));
		assertFalse(l.search(1));
		
		//insert another value and search for all two values and wrong value
		l.insert(1);
		assertTrue(l.search(0));
		assertTrue(l.search(1));
		assertFalse(l.search(2));
		
		//insert another value and search for all three values and wrong value
		l.insert(2);
		assertTrue(l.search(0));
		assertTrue(l.search(1));
		assertTrue(l.search(2));
		assertFalse(l.search(3));
		
		//insert another value and search for all four values and wrong value
		l.insert(3);
		assertTrue(l.search(0));
		assertTrue(l.search(1));
		assertTrue(l.search(2));
		assertTrue(l.search(3));
		assertFalse(l.search(4));
		
	}
	
	/*
	 * insertAfter function for LinkedList
	 * insert a new Node with number after first instance of a given number
	 * if given number is not found, does nothing
	 */
	@Test
	public void testInsertAfter() {
		//insertAfter in empty LinkedList
		//does nothing
		LinkedList l = new LinkedList();
		l.insertAfter(0, 0);
		assertNull(l.head);
		
		//insert one value, and insertAfter wrong value
		l.insert(1);
		l.insertAfter(0, 0);
		assertEquals(l.head.data, 1);
		assertNull(l.head.next);
		
		//insertAfter right value
		//1 2
		l.insertAfter(1, 2);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 2);
		assertNull(l.head.next.next);
		

		//insert after 1 twice
		//1 3 2
		l.insertAfter(1, 3);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 3);
		assertEquals(l.head.next.next.data, 2);
		assertNull(l.head.next.next.next);
		//1 4 3 2
		l.insertAfter(1, 4);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 3);
		assertEquals(l.head.next.next.next.data, 2);
		assertNull(l.head.next.next.next.next);
		
		
		//1 4 5 3 2
		//insert value after added number before, that is 4
		l.insertAfter(4, 5);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 5);
		assertEquals(l.head.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.data, 2);
		assertNull(l.head.next.next.next.next.next);
		
		
		//1 4 5 3 2 4
		//insert after last a duplicate number on LinkedList
		l.insertAfter(2, 4);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 5);
		assertEquals(l.head.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.data, 4);
		assertNull(l.head.next.next.next.next.next.next);
		
		//insert after wrong number
		l.insertAfter(10, 10);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 5);
		assertEquals(l.head.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.data, 4);
		assertNull(l.head.next.next.next.next.next.next);
		
		//insert after 4 value of 4
		//1 4 4 5 3 2 4
		l.insertAfter(4, 4);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.next.data, 4);
		assertNull(l.head.next.next.next.next.next.next.next);
		
		//insert after 4 value of 4 again
		//1 4 4 4 5 3 2 4
		l.insertAfter(4, 4);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 4);
		assertNull(l.head.next.next.next.next.next.next.next.next);
		
		//last check for insertAfter first and last values
		
		//insert one last value and then insertAfter last value
		//1 4 4 4 5 3 2 4 6 7
		l.insert(6); //last number now 6 
		l.insertAfter(6, 7);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.next.next.data, 6);
		assertEquals(l.head.next.next.next.next.next.next.next.next.next.data, 7);
		assertNull(l.head.next.next.next.next.next.next.next.next.next.next);
		
		//insertAfter first value
		//1 8 4 4 4 5 3 2 4 6 7
		l.insertAfter(1, 8);
		assertEquals(l.head.data, 1);
		assertEquals(l.head.next.data, 8);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.next.next.next.data, 6);
		assertEquals(l.head.next.next.next.next.next.next.next.next.next.next.data, 7);
		assertNull(l.head.next.next.next.next.next.next.next.next.next.next.next);
	}
	
	/*
	 * insertBefore function for LinkedList
	 * insert a new Node with number before first instance of a given number
	 * if given number is not found, does nothing
	 */
	@Test
	public void testInsertBefore() {
		//insertBefore in empty LinkedList
		//does nothing
		LinkedList l = new LinkedList();
		l.insertBefore(0, 0);
		assertNull(l.head);
		
		//insert one value, and insertBefore wrong value
		l.insert(1);
		l.insertBefore(0, 0);
		assertEquals(l.head.data, 1);
		assertNull(l.head.next);
		
		//insertAfter right value
		//2 1
		l.insertBefore(1, 2);
		assertEquals(l.head.data, 2);
		assertEquals(l.head.next.data, 1);
		assertNull(l.head.next.next);
		
		//insert before 1 twice
		//2 3 1
		l.insertBefore(1, 3);
		assertEquals(l.head.data, 2);
		assertEquals(l.head.next.data, 3);
		assertEquals(l.head.next.next.data, 1);
		assertNull(l.head.next.next.next);
		
		//2 3 4 1
		l.insertBefore(1, 4);
		assertEquals(l.head.data, 2);
		assertEquals(l.head.next.data, 3);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next);
		
		
		//2 3 5 4 1
		//insert value after last inserted number, that is 4
		l.insertBefore(4, 5);
		assertEquals(l.head.data, 2);
		assertEquals(l.head.next.data, 3);
		assertEquals(l.head.next.next.data, 5);
		assertEquals(l.head.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next);
		
		
		//4 2 3 5 4 1
		//insert before first number a duplicate number on LinkedList
		l.insertBefore(2, 4);
		assertEquals(l.head.data, 4);
		assertEquals(l.head.next.data, 2);
		assertEquals(l.head.next.next.data, 3);
		assertEquals(l.head.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next);
		
		//insert before wrong number
		l.insertBefore(10, 10);
		assertEquals(l.head.data, 4);
		assertEquals(l.head.next.data, 2);
		assertEquals(l.head.next.next.data, 3);
		assertEquals(l.head.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next);
		
		//insert before 4 value of 4
		//4 4 2 3 5 4 1
		l.insertBefore(4, 4);
		assertEquals(l.head.data, 4);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 2);
		assertEquals(l.head.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next.next);
		
		//insert before 4 value of 4 again
		//4 4 4 2 3 5 4 1
		l.insertBefore(4, 4);
		assertEquals(l.head.data, 4);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next.next.next);
		
		//last check for insertBefore first and last values
		
		//insertBefore last value
		//4 4 4 2 3 5 4 6 1
		l.insertBefore(1, 6);
		assertEquals(l.head.data, 4);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 6);
		assertEquals(l.head.next.next.next.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next.next.next.next);
		
		//insertBefore first value
		//7 4 4 4 2 3 5 4 6 1
		l.insertBefore(4, 7);
		assertEquals(l.head.data, 7);
		assertEquals(l.head.next.data, 4);
		assertEquals(l.head.next.next.data, 4);
		assertEquals(l.head.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.data, 2);
		assertEquals(l.head.next.next.next.next.next.data, 3);
		assertEquals(l.head.next.next.next.next.next.next.data, 5);
		assertEquals(l.head.next.next.next.next.next.next.next.data, 4);
		assertEquals(l.head.next.next.next.next.next.next.next.next.data, 6);
		assertEquals(l.head.next.next.next.next.next.next.next.next.next.data, 1);
		assertNull(l.head.next.next.next.next.next.next.next.next.next.next);
	}

}
