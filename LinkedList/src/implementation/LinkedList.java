package implementation;

/*
 * Own implementation of LinkedList
 */
public class LinkedList {
	public Node head;
	
	//separate class node
	public class Node{
		public Node next = null;
		public int data;
		public Node(int d) {
			data = d;
		}
	}
	
	public LinkedList(){}
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
	
	//deleting first instance of d
	public void delete(int d) {
		head = deleteNode(head, d);
	}
	//helper function
	private Node deleteNode(Node head, int d) {
		if(head == null) return null;
		
		Node current = head;
		//if the head node is equivalent, return next node
		if(current.data == d) return current.next; 
		
		//checks if d is in next
		while(current.next != null) {
			if(current.next.data == d) {
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return head;
	}
	
	//see if number is in the linked list
	public boolean search(int d) {
		return search(head, d);
	}
	private boolean search(Node head, int d) {
		Node current = head;
		
		while(current != null) {
			if(current.data == d) return true;
			current = current.next;
		}
		return false;
	}
	
	//insert new node after first instance of designated number
	public void insertAfter(int designatedNumber, int newNumber) {
		head = insertAfter(head, designatedNumber, newNumber);
	}
	
	private Node insertAfter(Node head, int designatedNumber, int newNumber) {
		if(head == null) return null;
		
		Node current = head;
		
		while(current != null) {
			//found number
			if(current.data == designatedNumber) {
				Node newNode = new Node(newNumber);
				newNode.next = current.next;
				current.next = newNode;
				break;
			}
			current = current.next;
		}
		return head;
		
	}
	
	//insert new node before first instance of designated number
	public void insertBefore(int designatedNumber, int newNumber) {
		head = insertBefore(head, designatedNumber, newNumber);
	}
	
	private Node insertBefore(Node head, int designatedNumber, int newNumber) {
		if(head == null) return null;
		
		Node current = head;
		Node newNode = new Node(newNumber);
		//check head first
		if(current.data == designatedNumber) {
			newNode.next = current;
			return newNode;
		}
		
		while(current.next != null) {
			//found number
			if(current.next.data == designatedNumber) {
				newNode.next = current.next;
				current.next = newNode;
				break;
			}
			current = current.next;
		}
		
		return head;
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


