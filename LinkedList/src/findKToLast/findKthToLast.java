package findKToLast;

import Implementation.LinkedList;

public class findKthToLast {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1); l.insert(2); l.insert(3); l.insert(4); l.insert(5); l.insert(6);
		System.out.println(l.findKthtoLastElement(l.head, 3));
	}
}
