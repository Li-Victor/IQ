package ZeroMatrix;

//do not have to create row and column array from the past 2 solutions
//using first row and column to indicate 0
public class InPlaceSolution implements ZeroMatrix {
	@Override
	public int[][] zeroMatrix(int[][] A) {
		if(A.length <= 0 || A[0].length <= 0) return A;
		
		//check first row and column
		boolean FirstZeroRow = false;
		boolean FirstZeroColumn = false;
		
		for(int i = 0; i < A[0].length; i++) {
			if(A[0][i] == 0) {
				FirstZeroRow = true;
				break;
			}
		}
		
		for(int j = 0; j < A.length; j++) {
			if(A[j][0] == 0) {
				FirstZeroColumn = true;
				break;
			}
		}
		
		//Check for the rest of the array starting at 1
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					A[i][0] = 0;
					A[0][j] = 0;
				}
			}
		}
		
		//set the rows to zero starting not with the first column, 
		//setting first row and column to zero based on FZeroRow and FZeroColumn
		
		//row
		for(int i = 1; i < A.length; i++) {
			if(A[i][0] == 0) {
				setRowZero(i, A);
			}
		}
		
		for(int j = 1; j < A[0].length; j++) {
			if(A[0][j] == 0) {
				setColumnZero(j, A);
			}
		}
		
		if(FirstZeroRow) setRowZero(0, A);
		if(FirstZeroColumn) setColumnZero(0, A);
		
		return A;
		
	}
	
	
	//retrieve row number, and set the entire row to zero
	public void setRowZero(int numRow, int[][] arr) {
		for(int i = 0; i < arr[0].length; i++) {
			arr[numRow][i] = 0;
		}
	}
	
	public void setColumnZero(int numColumn, int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i][numColumn] = 0;
		}
	}
}
