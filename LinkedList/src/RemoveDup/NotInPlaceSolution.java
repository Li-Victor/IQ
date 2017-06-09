package RemoveDup;

import java.util.Hashtable;

import Implementation.LinkedList;
import Implementation.LinkedList.Node;

public class NotInPlaceSolution implements RemoveDup {
	
	@Override
	public void removeDup(LinkedList l) {
		removeDup(l.head);
		
	}
	
	private void removeDup(Node head) {
		if(head == null) return;
		
		Node current = head;
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		ht.put(current.data, 0); //put first value in hashtable
		
		while(current != null) {
			if(current.next == null) break;
			else {
				Node afterCurrent = current.next;
				
				while(afterCurrent != null) {
					//found in hashtable, go to the next
					if(ht.get(afterCurrent.data) != null) afterCurrent = afterCurrent.next;
					else break; //hashtable does not have value, so break out
				}
				
				if(afterCurrent != null) ht.put(afterCurrent.data, 0);
				
				current.next = afterCurrent;
				current = current.next;
			}
			
			
		}
	}
}
