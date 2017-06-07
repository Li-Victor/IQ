package RotateMatrix;

public class InPlaceSolution implements RotateMatrix{
	@Override
	public String[][] rotateMatrix(String[][] A) {
		if(A.length <= 0) return null;
		
		int matrixLength = A.length;
		for(int layer = 0; layer < matrixLength / 2; layer++) {
			int first = layer;
			int last = matrixLength - layer - 1;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				//save top 
				String top = A[first][i];
				
				//top position = left position
				//left -> top
				A[first][i] = A[last - offset][first];
				
				//left position = bottom position
				//bottom -> left
				A[last - offset][first] = A[last][last - offset];
				
				//bottom position = right position
				//right -> bottom
				A[last][last - offset] = A[i][last];
				
				//right position = top
				//top -> right
				A[i][last] = top;
				
				//some kind of pattern
				//left -> top
				//bottom -> left
				//right -> bottom
				//top -> right
			}
		}
		return A;
		
	}
}
