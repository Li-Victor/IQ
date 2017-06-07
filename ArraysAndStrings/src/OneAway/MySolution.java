package OneAway;

public class MySolution implements OneAway {
	//O(n) solution
	@Override
	public boolean OneAway(String A, String B) {
		if(A.equals(B)) return false;
		
		//replacing characters, having the same length
		if(A.length() == B.length()) {
			boolean one = false;
			for(int i = 0; i < A.length(); i++) {
				if(A.charAt(i) != B.charAt(i) && !one) {
					one = true;
				} else if(A.charAt(i) != B.charAt(i) && one) {
					return false;
				}
			}
			
			if(one) return true;
			else return false;
		}
		
		//more than one edit
		if(Math.abs(A.length() - B.length()) > 1) return false; 
		
		//last section would mean one character away
		if(A.contains(B)) return true;
		if(B.contains(A)) return true;
		
		//removing and adding characters are the same, but have to find which String is longer length or shorter length
		String bigger = (A.length() > B.length()) ? A : B;
		String smaller = (A.length() > B.length()) ? B : A;
		
		boolean one = false;
		int smallIndex = 0;
		//iterator through bigger string
		for(int i = 0; i < bigger.length(); i++) { 
			if(bigger.charAt(i) == smaller.charAt(smallIndex)) smallIndex++;
			else
				if(one) return false;
				else one = true;
		}
		if(one) return true;
		else return false;
	}
}
