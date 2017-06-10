package RemoveAllDup;

import java.util.Hashtable;

import Implementation.LinkedList;
import Implementation.LinkedList.Node;

public class NotInPlaceSolution implements RemoveAllDup {
	
	@Override
	public void removeAllDup(LinkedList l) {
		if(l.head == null) return;
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		
		//traverse through entire LinkedList
		Node current = l.head;
		while(current != null) {
			if(ht.get(current.data) == null) ht.put(current.data, 1);
			else ht.put(current.data, ht.get(current.data) + 1); //update by 1
			
			current = current.next;
		}
		
		//delete nodes that values are more than 1 in hashtable
		
		//remove duplicates from the start of LinkedList
		//the head of LinkedList should be null or a unique number from original LinkedList
		while(l.head != null) {
			if(ht.get(l.head.data) == null) break;
			else if(ht.get(l.head.data) == 1) break;
			else l.head = l.head.next;
		}
		
		if(l.head == null) return;
		
		//check Nodes after the beginning
		current = l.head;
		
		while(current.next != null) {
			if(ht.get(current.next.data) == null) current = current.next; //move current pointer
			else if(ht.get(current.next.data) == 1) current = current.next;
			else current.next = current.next.next; //lose current.next Node
		}
		
		
	}
	
}
