package implementation;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1);
		l.print(); //print 1
		System.out.println();
		
		l.insert(2); l.print(); // 1 2
		System.out.println();
		
		l.delete(0); l.print(); // 1 2
		System.out.println();
		
		l.delete(2); l.print(); // 1
		System.out.println();
		
		l.insert(3); l.insertAfter(1, 2); l.print(); // 1 2 3
	}
}
