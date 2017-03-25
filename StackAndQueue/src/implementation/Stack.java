package implementation;

/*
 * Implementation of stack in a linkedlist. 
 * Adding is O(1)
 * Removing is O(1)
 * Not constant time for searching
 */
public class Stack<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> head;
	
	/*
	 * pushing requires adding through the head
	 */
	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		if(head == null) head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	/*
	 * pop is removing the head, and having the head point to the next
	 */
	public T pop() {
		if(head == null) throw new Error();
		T result = head.data;
		head = head.next;
		return result;
	}
	
	/*
	 * return the head
	 */
	public T peek()	{
		if(head == null) throw new Error();
		return head.data;
	}
	
	/*
	 * checks if stack is empty
	 */
	public boolean isEmpty(){
		return head == null;
	}
	
	public void print() {
		Node<T> n = head;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}
