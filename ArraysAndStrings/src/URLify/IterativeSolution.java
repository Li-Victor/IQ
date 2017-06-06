package URLify;

public class IterativeSolution implements URLify {
	@Override
	public String URLify(String A, int B) {
		//first count the number of spaces
		char[] a = A.toCharArray();
		int spaces = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] == ' ') spaces++;
		}
		
		char[] result = new char[(spaces * 3) + (B - spaces)];
		int indexForResult = 0; //having separate index for the result
		
		//iterate through the original array, and update char array with indexForResult
		for(int i = 0; i < a.length; i++) {
			if(a[i] != ' ') {
				result[indexForResult] = a[i];
				indexForResult++;
			} else {
				result[indexForResult] = '%';
				result[indexForResult + 1] = '2';
				result[indexForResult + 2] = '0';
				indexForResult = indexForResult + 3;
			}
		}
		return new String(result);
	}
}
