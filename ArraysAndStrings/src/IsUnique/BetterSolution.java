package IsUnique;

import java.util.Hashtable;

public class BetterSolution implements IsUnique {
	@Override
	//Using a hash table, O(N) solution
	public boolean isUnique(String A) {
		Hashtable<Character, Integer> ht = new Hashtable<>();
		
		for(int i = 0; i < A.length(); i++) {
			char letter = A.charAt(i);
			//if letter is in the hash table, then the string would not have unique characters
			if(ht.get(letter) != null) return false;
			else
				ht.put(letter, 0);
		}
		return true;
	
	}
}
