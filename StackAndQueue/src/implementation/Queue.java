package implementation;

/*
 * Queue implementation using first and last nodes. First represents the head. Last represents the tail
 */
public class Queue<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	// adding to queue. Update first and last node
	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		//when there is nothing on the Queue
		if(first == null) {
			first = newNode;
			last = newNode;
		} else {
			//if first does not have a next. This state runs when there is only one item in the queue
			if(first.next == null) first.next = newNode;
			last.next = newNode;
			last = last.next;
		}
	}
	
	/*
	 * Removing first node, point first node to the next. 
	 * If first node is null, have to make last node to null as well because last will be always pointing to an element
	 */
	public T pop() {
		if(first == null) throw new Error();
		T result = first.data;
		first = first.next;
		//set last to null if first is null
		if(first == null) last = null;
		return result;
	}
	
	//check the first element
	public T peek() {
		if(first == null) throw new Error();
		return first.data;
	}
	
	//check if the queue is empty
	public boolean isEmpty() {
		return first == null;
	}
	
	public void print() {
		Node<T> n = first;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}
