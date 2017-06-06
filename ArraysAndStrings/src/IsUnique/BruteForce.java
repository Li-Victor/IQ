package IsUnique;

public class BruteForce implements IsUnique {
	//O(n^2) and O(1) space,
	//could also sort the strings and then check for neighboring characters
	public boolean isUnique(String A) {
		for(int i = 0; i < A.length(); i++) {
			char letter = A.charAt(i);
			//get remaining string and iterate through it
			String remaining = A.substring(i + 1);
			
			for(int j = 0; j < remaining.length(); j++) {
				if(remaining.charAt(j) == letter) {
					return false;
				}
			}
		}
		
		return true;
	}
}
