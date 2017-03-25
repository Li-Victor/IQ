package removeDup;

import implementation.LinkedList;

public class removeDupWithoutBuffer {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1); l.insert(2); l.insert(1); l.insert(2); l.insert(3);
		l.removeDupWithoutBuffer(l.head); l.print();
	}
}
