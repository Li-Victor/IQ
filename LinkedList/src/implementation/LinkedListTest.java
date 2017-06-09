package implementation;

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
		assertNull(l.head.data);
		assertNull(l.head.next);
		
		//insert and then delete
		l.insert(0);
		l.delete(0);
		assertNull(l.head);
		assertNull(l.head.data);
		assertNull(l.head.next);
		
		//insert two values and delete from front
		l.insert(1); l.insert(2);
		l.delete(1);
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		assertNull(l.head.next);
		
		//insert one more value and delete from back
		l.insert(3);
		l.delete(3);
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		assertNull(l.head.next);
		
		//delete wrong number
		assertNotNull(l.head);
		assertEquals(l.head.data, 2);
		
		//delete to empty
		l.delete(2);
		assertNull(l.head);
		
		//set new LinkedList, add two values and delete front to back
		l.insert(4); l.insert(5);
		l.delete(4); l.delete(5);
		assertNull(l.head);
		
		//insert two values and delete back and then front
		l.insert(6); l.insert(7);
		l.delete(7); l.delete(6);
		assertNull(l.head);
		
		//insert three values and delete wrong value, and delete middle value
		l.insert(8); l.insert(9); l.insert(0);
		l.delete(10);
		assertEquals(l.head.data, 8); assertEquals(l.head.next.data, 9); assertEquals(l.head.next.next.data, 10);
		assertNull(l.head.next.next.next);
		
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
		//test two are null
		
		//test both sides if one of them is null
		
		//insert to one only
		
		//then insert to other, makes this equal
		
		//insert into both different values
	}
	
	/*
	 * search function for LinkedList
	 * search for number in LinkedList, return true or false
	 */
	@Test
	public void testSearch() {
		
		//search in empty LinkedList
		
		//insert one value and then search right and wrong value
		
		//insert another value and search for all two and wrong
		
		//insert another value and search for all three and wrong
		
		//insert another value and search for all four and wrong
		
	}
	
	/*
	 * insertAfter function for LinkedList
	 * insert a new Node with number after first instance of a given number
	 * if given number is not found, does nothing
	 */
	@Test
	public void testInsertAfter() {
		//insertAfter in empty LinkedList
		
		//1 2
		//insert one value, and insertAfter right value and wrong value
		
		//1 3 2, then 1 4 3 2
		//insert some number after same value as before and do it again
		
		//1 4 5 3 2
		//insert some number after value before
		
		//1 4 5 3 2 4
		//insert after last
		
		//insert after wrong number
		//insert after 4 value of 4
		//1 4 4 5 3 2 4
		
		//and again
		//1 4 4 4 5 3 2 4
	}

}
