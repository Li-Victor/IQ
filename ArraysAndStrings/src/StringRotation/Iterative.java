package StringRotation;

/*
 * O(n)
 */
public class Iterative implements StringRotation {
	@Override
	public boolean stringRotation(String rotWord, String original) {
		//Check for same lengths
		if(rotWord.length() != original.length()) {
			return false;
		}
		
		if(rotWord.length() <= 0 && original.length() <= 0) return true;
		
		//use different lengths of the beginning and ending of the rotated word
		for(int i = 0; i < rotWord.length(); i++) {
			String begin = rotWord.substring(0, i);
			String end = rotWord.substring(i, rotWord.length());
			
			String word = end + begin;
			if(word.equals(original)) return true;
		}
		return false;
	}
}
