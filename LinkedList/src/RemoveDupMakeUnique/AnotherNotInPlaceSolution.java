package RemoveDupMakeUnique;

import java.util.HashSet;

import Implementation.LinkedList;
import Implementation.LinkedList.Node;

public class AnotherNotInPlaceSolution implements RemoveDupMakeUnique {
	@Override
	public void removeDupMakeUnique(LinkedList l) {
		removeDupMakeUnique(l.head);
		
	}
	
	private void removeDupMakeUnique(Node head) {
		HashSet<Integer> set = new HashSet<>();
		//prev is like current
		Node prev = null;
		
		while(head != null) {
			if(set.contains(head.data)) {
				prev.next = head.next;
			} else {
				set.add(head.data);
				//move prev and head
				prev = head;
			}
			//always move head
			head = head.next;
		}
	}
}
