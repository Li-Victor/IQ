package PalindromePermutation;

import java.util.Hashtable;

public class HashTableSolution implements PalindromePermutation{
	@Override
	public boolean palPermuation(String A) {
		
		//remove whitespace and lowercase
		String a = A.replace(" ", "").toLowerCase();
		Hashtable<Character, Integer> ht = new Hashtable<>();
		
		for(int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			
			//check hashtable for pairs, remove pairs of same occurring character
			if(ht.get(c) == null) {
				ht.put(c, 0);
			} else {
				ht.remove(c);
			}
		}
		
		//check remaining hashtable
		//if there is one value or no values, then string is a palindrome permutation
		if(ht.size() == 0 || ht.size() == 1) {
			return true;
		} else {
			return false;
		}
		
	}
}
