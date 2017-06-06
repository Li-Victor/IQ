package CheckPermutation;

//O(n)
public class BetterSolution implements CheckPermutation {
	@Override
	public boolean CheckPermutation(String A, String B) {
		if(A.length() != B.length()) return false;
		
		for(int i = 0; i < A.length(); i++) {
			String a = Character.toString(A.charAt(i));
			
			if(B.contains(a)){
				//find occurrence of first index of A and then remove it from B
				int index = B.indexOf(a);
				B = B.substring(0, index) + B.substring(index + 1, B.length());
			} else { // if there are no more occurrences 
				return false;
			}
		}
		return true;
	}
}
