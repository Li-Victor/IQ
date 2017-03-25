package removeDup;


import implementation.LinkedList;

public class removeDup {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1); l.insert(1); l.insert(2);
		l.removeDup(l.head); l.print();
	}
	
}
