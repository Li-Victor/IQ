package RotateMatrix;

public class NotInPlaceSolution implements RotateMatrix {
	@Override
	public String[][] rotateMatrix(String[][] A) {
		if(A.length <= 0) return null;
		String[][] result = new String[A.length][A[0].length];
		
		for(int i = 0; i < A.length; i++) {
			
			for(int j = 0; j < A[0].length; j++) {
				result[i][j] = A[A.length - j - 1][i]; 
			}
		}
		
		return result;
		
	}
}
