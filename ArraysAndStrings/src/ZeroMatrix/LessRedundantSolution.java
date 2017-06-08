package ZeroMatrix;

//less redundant steps of the NotInPlaceSolution
//no need to make copies for row and column result
//O(n^2)
public class LessRedundantSolution implements ZeroMatrix{
	@Override
	public int[][] zeroMatrix(int[][] A) {
		if(A.length <= 0) return A;
		
		//array to represent row and column.
		//Marking down which rows and columns need to be zeroed
		int[] row = new int[A.length];
		int[] column = new int[A[0].length];
		
		for(int i = 0; i < A.length; i++) {
			
			for(int j = 0; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					row[i] = 1; //marking down rows and columns
					column[j] = 1;
				}
			}
			
		}
		
		//markdown A from rows 
		for(int i = 0; i < row.length; i++) {
			if(row[i] == 1) {
				
				for(int j = 0; j < A[0].length; j++) {
					A[i][j] = 0;
				}
				
			}
		}
		
		//markdown A from columns
		for(int i = 0; i < column.length; i++) {
			if(column[i] == 1) {
				
				for(int j = 0; j < A.length; j++) {
					A[j][i] = 0;
				}
				
				
			}
		}
		return A;
		
	}
}
