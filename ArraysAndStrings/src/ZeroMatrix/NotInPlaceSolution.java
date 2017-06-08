package ZeroMatrix;


public class NotInPlaceSolution implements ZeroMatrix {
	@Override
	public int[][] zeroMatrix(int[][] A) {
		//setting the rows to zero
		int[][] resultRow = copyArray(A); //not references to A
		
		//setting the columns to zero
		int[][] resultColumn = copyArray(A);
		
		//what to return
		int[][] finalResult = copyArray(A);
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					setRowZero(i, resultRow);
					setColumnZero(j, resultColumn);
					//really redundant in this step if the row or column is already 0
				}
			}
		}
		
		for(int i = 0; i < finalResult.length; i++) {
			for(int j = 0; j < finalResult[0].length; j++) {
				
				if(resultRow[i][j] == 0 || resultColumn[i][j] == 0) {
					finalResult[i][j] = 0;
				}
				
			}
		}
		return finalResult;
	}
	
	public int[][] copyArray(int[][] a) {
		int[][] result = new int[a.length][];
		for(int i = 0; i < a.length; i++) {
			result[i] = a[i].clone();
		}
		return result;
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
