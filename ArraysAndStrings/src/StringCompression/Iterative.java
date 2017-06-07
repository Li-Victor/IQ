package StringCompression;

public class Iterative implements StringCompression {
	@Override
	public String StringCompression(String A) {
		StringBuilder result = new StringBuilder(); //using StringBuilder
		
		int i = 0;
		while(i < A.length()) {
			int count = 1;
			char c = A.charAt(i);
			
			while(i + 1 < A.length() && c == A.charAt(i + 1)) {
				count++;
				i++;
			}
			i++;
			result.append( c + Integer.toString(count));
			
			//do not have to continue if there is a large number of different consecutive letters 
			if(A.length() <= result.length()) return A;
		}
		
		return result.toString();
	}
}
