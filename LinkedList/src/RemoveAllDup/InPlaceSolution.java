package RemoveAllDup;

import Implementation.LinkedList;
import Implementation.LinkedList.Node;

public class InPlaceSolution implements RemoveAllDup {
	@Override
	public void removeAllDup(LinkedList l) {
		removeAllDup(l.head);
	}
	
	private void removeAllDup(Node head) {
		
		if(head == null) return;
	
		Node current = head;
		
		while(current != null) {
			if(current.next == null) break;
			else {
				Node afterCurrent = current.next;
				
				while(afterCurrent != null) {			
					if(afterCurrent.data == current.data) {
						afterCurrent = afterCurrent.next;
					} else {
						break;
					}
				}
				
				if(afterCurrent != null) {
					current.next = afterCurrent;
					
				}
				current = current.next;
				
			}
			
			
		}
	}
}
