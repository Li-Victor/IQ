package RotateMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateMatrixTest {

	RotateMatrix r = new NotInPlaceSolution();
	//RotateMatrix r  = new InPlaceSolution();
	
	@Test
	public void testRotation1by1() {
		String[][] s = new String[][] {{"A1"}};
		
		assertArrayEquals("1 by 1 matrix rotation", r.rotateMatrix(s), new String[][] {{"A1"}});
	}
	
	@Test
	public void testRotation2by2() {
		String[][] s = new String[][] {{"A1", "B1"},
					    			   {"A2", "B2"}};
		
		assertArrayEquals("2 by 2 matrix rotation", r.rotateMatrix(s), new String[][] {{"A2", "A1"}, 
																 					   {"B2", "B1"}});

	}
	
	@Test
	public void testRotation3by3() {
		String[][] s = new String[][] {{"A1", "B1", "C1"},
 			   						   {"A2", "B2", "C2"},
 			   						   {"A3", "B3", "C3"}};
		
		assertArrayEquals("3 by 3 matrix rotation", r.rotateMatrix(s), new String[][] {{"A3", "A2", "A1"}, 
			 													 					   {"B3", "B2", "B1"},
			 													 					   {"C3", "C2", "C1"}});
		
	}
	
	@Test
	public void testRotation4by4() {
		String[][] s = new String[][] {{"A1", "B1", "C1", "D1"},
									   {"A2", "B2", "C2", "D2"},
									   {"A3", "B3", "C3", "D3"},
									   {"A4", "B4", "C4", "D4"}};
		
		assertArrayEquals("4 by 4 matrix rotation", r.rotateMatrix(s), new String[][] {{"A4", "A3", "A2", "A1"},
																					   {"B4", "B3", "B2", "B1"},
																					   {"C4", "C3", "C2", "C1"},
																					   {"D4", "D3", "D2", "D1"}});
		
	}
	
	@Test
	public void testEmpty() {
		String[][] s = new String[][] {};
		
		assertNull(r.rotateMatrix(s));
	}

}
