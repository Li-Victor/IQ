package RemoveDupMakeUnique;

import Implementation.LinkedList;
import Implementation.LinkedList.Node;

public class InPlaceSolution implements RemoveDupMakeUnique{
	@Override
	public void removeDupMakeUnique(LinkedList l) {
		removeDupMakeUnique(l.head);
		
	}
	
	private void removeDupMakeUnique(Node head) {
		//reference to head
		Node current = head;
		while(current != null) {
			Node afterCurrent = current;
			
			while(afterCurrent.next != null) {
				//being inside the while loop would mean, afterCurrent.next.next should not be an error
				
				//removes all the other nodes that are equal 
				if(afterCurrent.next.data == current.data) {
					afterCurrent.next = afterCurrent.next.next;
				} else {
					afterCurrent = afterCurrent.next;
				}
			}
			
			current = current.next;
		}
		
	}
}
