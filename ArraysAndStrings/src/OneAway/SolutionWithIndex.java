package OneAway;

public class SolutionWithIndex implements OneAway {
	//O(n) solution iterating only through one string
	@Override
	public boolean OneAway(String A, String B) {
		
		if(Math.abs(A.length() - B.length()) > 1) return false;
		if(A.equals(B)) return false;
		boolean foundDifference = false;
		
		//found the strings with longer and shorter lengths
		String bigger = (A.length() > B.length()) ? A : B;
		String smaller = (A.length() > B.length()) ? B : A;
		int indexB = 0;
		int indexS = 0;
		
		while(indexS < smaller.length() && indexB < bigger.length()) {
			if(smaller.charAt(indexS) == bigger.charAt(indexB)) {
				indexS++;
				indexB++;
			} else { //not equal
				if(foundDifference) return false; //one edit already
				foundDifference = true; //one time
				
				if(smaller.length() == bigger.length()) indexS++; //only move small index if they are same length
				indexB++; //move big index all the time
			}
		}
		
		
		return true;
	}
}
