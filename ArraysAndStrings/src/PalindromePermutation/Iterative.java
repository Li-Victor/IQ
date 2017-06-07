package PalindromePermutation;

import java.util.Arrays;

/*
 * Solution using iterative approach
 */
public class Iterative implements PalindromePermutation {
	@Override
	public boolean palPermuation(String A) {
		
		//remove whitespace and lowercase
		String a = A.replace(" ", "").toLowerCase();
		
		//sort string
		char[] arr = a.toCharArray();
		Arrays.sort(arr);
		
		boolean extra = false; //extra letter
		//iterate through sorted char array
		int i = 0;
		
		while(i < arr.length) {
			int count = 1;
			char c = arr[i];
			while(i + 1 < arr.length && c == arr[i + 1]) {
				count++;
				i++;
			}
			if(count % 2 == 1) {
				if(extra) return false;
				else extra = true;
			}
			i++;
			
		}
		return true;
		
	}
}
