package implementation;

/*
 * Own implementation of LinkedList
 */
public class LinkedList {
	public Node head;
	
	//separate class node
	private class Node{
		public Node next = null;
		public int data;
		public Node(int d) {
			data = d;
		}
	}
	
	
	public LinkedList(int n) {
		head = new Node(n);
	}
	
	
	//append to tail
	public void insert(int d) {
		Node newNode = new Node(d);
		Node current = head;
		if(current == null) head = newNode;
		else {
			//traverse until found empty opening
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode; //assign next to the new node
		}
	}
	
	//deleting the node that has d, removing without another copy(previous)
	public void delete(int d) {
		head = deleteNode(head, d);
	}
	//helper function
	private Node deleteNode(Node n, int d) {
		
		//if the head node is equivalent, return head.next
		if(n.data == d) return n.next; 
		
		//checks if d is in next
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	//see if number is in the linked list
	public boolean search(int d) {
		 Node n = search(head, d);
		 return n.data == d;
	}
	private Node search(Node head, int d) {
		Node n = head;
		//first checks head
		if(head.data == d) return head;
		while(n.next != null && n.next.data != d) {
			n = n.next;
		}
		return n.next;
	}
	
	//insert new node after found number
	public void insertAfter(int number, int newNumber) {
		insertAfter(head, number, newNumber);
	}
	
	private void insertAfter(Node head, int number, int newNumber) {
		Node newNode = new Node(newNumber);
		Node n = head;
		
		//search for node
		while(n != null && n.data != number) {
			n = n.next;
		}
		
		if(n.data == number) {
			if(n.next != null) {
				//attach the new node next to current's next. And then 
				//check if it n equals null?
				newNode.next = n.next;
				n.next = newNode;
			} else {
				n.next = newNode;
			}
		}
		
	}
	
	/*
	 * Check if two LinkedList are equal to each other
	 */
	@Override
	public boolean equals(Object arg0) {
		
		if(arg0 instanceof LinkedList) {
			LinkedList other = (LinkedList) arg0;
			
			Node thisHead = head;
			Node otherHead = other.head;
			while(thisHead != null && otherHead != null) {
				
				if(thisHead.data != otherHead.data) return false;
				
				thisHead = thisHead.next;
				otherHead = otherHead.next;
			}
			
			//dont have size, so have to make sure both iterations should have both heads at null
			return (thisHead == null) && (otherHead == null);
			

		} else {
			return false;
		}
		
	}
	
	
//	/*
//	 * Remove duplicates from the linked list, removing using previous
//	 */
//	public static void removeDup(Node n) {
//		HashSet<Integer> set = new HashSet<>();
//		Node prev = null;
//		
//		while(n != null) {
//			if(set.contains(n.data)) {
//				prev.next = n.next;
//			} else {
//				set.add(n.data);
//				prev = n;
//			}
//			n = n.next;
//		}
//	}
//	
//	/*
//	 * Removes duplicates without any buffers O(1) space, but O(n^2) time
//	 */
//	public static void removeDupWithoutBuffer(Node head) {
//		Node current = head;
//		while(head != null) {
//			while(current.next != null) {
//				if(current.next.data == head.data) {
//					current.next = current.next.next;
//				} else {
//					current = current.next;
//				}
//			}
//			
//			head = head.next;
//			current = head;
//		}
//	}
//	
//	/*
//	 * finding the kth element to last element
//	 * 0 means the last element and 1 is the second to last
//	 */
//	public static int findKthtoLastElement(Node head, int A) {
//		Node a = head;
//		Node b = head;
//		
//		//moving a k elements away from b
//		for(int i = 0; i < A; i++) {
//			a = a.next;
//			if(a == null) return 0; //error past the the length of the linked list size
//		}
//		
//		//until a.next is a null, that would mean a is the last element, so return b.data
//		//move both pointers
//		while(a.next != null) {
//			a = a.next;
//			b = b.next;
//		}
//		return b.data;
//	}
//	
//	/*
//	 * delete node only when given access to that node
//	 * Solution: change the access node to the next node
//	 * This would not work for deleting the last node only when accessing the last node
//	 */
//	public static boolean deleteNode(Node d) {
//		if(d == null || d.next == null) {
//			return false;
//		}
//		Node next = d.next;
//		d.data = next.data;
//		d.next = next.next;
//		return true;
//	}
	
}


