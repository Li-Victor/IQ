package deleteNode;

import implementation.LinkedList;
import implementation.LinkedList.Node;

public class deleteNode {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1); l.insert(2); l.insert(3); l.insert(4); // 1 -> 2 -> 3 -> 4
		Node d = l.head.next; //deleting 2
		l.deleteNode(d); //result should be 1 -> 3 -> 4
		l.print();
		
	}
}
