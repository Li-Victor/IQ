package CheckPermutation;

import java.util.Arrays;

public class BruteForce implements CheckPermutation{
	@Override
	public boolean CheckPermutation(String A, String B) {
		
		if(A.length() != B.length()) return false;
		
		//sort both strings
		A = sortString(A);
		B = sortString(B);
		
		//check each character side by side
		for(int i = 0; i < A.length(); i++) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			
			if(a != b) return false;
		}
		
		return true;
		
		//no reason to check letter by letter
		//return A.equals(B);
	}
	
	//sorts the String, by turning string to char array, and using Arrays.sort()
	public String sortString(String A) {
		char[] arr = A.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
