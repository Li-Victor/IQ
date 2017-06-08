package ZeroMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZeroMatrixTest {

	//ZeroMatrix z = new NotInPlaceSolution();
	//ZeroMatrix z = new LessRedundantSolution();
	ZeroMatrix z = new InPlaceSolution();
	@Test
	public void testEmpty() {
		int[][] arr = new int[][] {};
		assertArrayEquals("empty array", z.zeroMatrix(arr), arr);
	}
	
	@Test
	public void test1by1() {
		int[][] arr = new int[][] { {1} };
		assertArrayEquals("no change with 1x1 array with value 1", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0} };
		assertArrayEquals("no change with 1x1 array with value 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {} };
		assertArrayEquals("no change with 1x1 array with no value", z.zeroMatrix(arr), arr);
	}
	
	@Test
	public void test1by2() {
		int[][] arr = new int[][] { {1, 1} };
		assertArrayEquals("no change with 1x2 array with no values of 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0, 1} };
		assertArrayEquals("changes in 1x2 array with one value of 0", z.zeroMatrix(arr), new int[][] { {0, 0} } );
		
		arr = new int[][] { {1, 0} };
		assertArrayEquals("changes in 1x2 array with one value of 0", z.zeroMatrix(arr), new int[][] { {0, 0} } );
		
		arr = new int[][] { {0, 0} };
		assertArrayEquals("changes in 1x2 array with both values of 0", z.zeroMatrix(arr), new int[][] { {0, 0} } );
	}
	
	@Test
	public void test2by1() {
		int[][] arr = new int[][] { {1},
									{1} };
		assertArrayEquals("no change with 2x1 array with no values of 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0},
							{1} };
		assertArrayEquals("changes 2x1 array with one value of 0", z.zeroMatrix(arr), new int[][] { {0}, {0} });
		
		arr = new int[][] { {1},
							{0} };
		assertArrayEquals("changes 2x1 array with one value of 0", z.zeroMatrix(arr), new int[][] { {0}, {0} });
		
		arr = new int[][] { {0},
							{0} };
		assertArrayEquals("changes 2x1 array with both values of 0", z.zeroMatrix(arr), new int[][] { {0}, {0} });
		
	}

	
	@Test
	public void test2by2() {
		int[][] arr = new int[][] { {1, 2},
									{3, 4} };
		assertArrayEquals("no change with 2x2 array with no values of 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0, 2},
							{3, 4} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 4}});
		
		arr = new int[][] { {1, 0},
							{3, 4} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {3, 0}});
		
		arr = new int[][] { {1, 2},
							{0, 4} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 2}, {0, 0}});
		
		arr = new int[][] { {1, 2},
							{3, 0} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {1, 0}, {0, 0}});
		
		arr = new int[][] { {0, 0},
							{3, 4} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {1, 2},
							{0, 0} };
		assertArrayEquals("1 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 2},
							{0, 4} };
		assertArrayEquals("2 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {1, 0},
							{3, 0} };
		assertArrayEquals("2 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 2},
							{3, 0} };
		assertArrayEquals("2 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {1, 0},
							{0, 4} };
		assertArrayEquals("2 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {1, 0},
							{0, 0} };
		assertArrayEquals("3 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 2},
							{0, 0} };
		assertArrayEquals("3 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 0},
							{3, 0} };
		assertArrayEquals("3 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 0},
							{0, 4} };
		assertArrayEquals("3 zero in 2x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
		
		arr = new int[][] { {0, 0},
							{0, 0} };
		assertArrayEquals("all zeros", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}});
	}
	
	@Test
	public void test2by3() {
		int[][] arr = new int[][] { {1, 2, 3},
									{4, 5, 6} };
		assertArrayEquals("no change with 2x3 array with no values of 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0, 2, 3}, 
							{4, 5, 6} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 5, 6} });
		
		arr = new int[][] { {1, 0, 3},
							{4, 5, 6} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {4, 0, 6} });
		
		arr = new int[][] { {1, 2, 0}, 
							{4, 5, 6} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {4, 5, 0} });
		
		arr = new int[][] { {1, 2, 3}, 
							{0, 5, 6} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 2, 3}, {0, 0, 0} });
		
		arr = new int[][] { {1, 2, 3},
							{4, 0, 6} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {1, 0, 3}, {0, 0, 0} });
		
		arr = new int[][] { {1, 2, 3},
							{4, 5, 0} };
		assertArrayEquals("1 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {1, 2, 0}, {0, 0, 0} });
		
		arr = new int[][] { {0, 2, 0}, 
							{4, 5, 6} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 5, 0} });
		
		arr = new int[][] { {1, 0, 3},
							{0, 5, 6} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
		
		arr = new int[][] { {1, 0, 3},
							{4, 5, 0} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });

		arr = new int[][] { {1, 2, 3}, 
							{0, 5, 0} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 2, 0}, {0, 0, 0} });

		arr = new int[][] { {0, 2, 3},
							{4, 0, 6} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
		
		arr = new int[][] { {1, 2, 0},
							{4, 0, 6} };
		assertArrayEquals("2 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
		
		arr = new int[][] { {1, 0, 3},
							{0, 5, 0} };
		assertArrayEquals("3 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
		
		arr = new int[][] { {0, 2, 0},
							{4, 0, 6} };
		assertArrayEquals("3 zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
		
		arr = new int[][] { {0, 0, 0}, {0, 0, 0} };
		assertArrayEquals("all zero in 2x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0} });
	}
	
	@Test
	public void test3by2() {
		int[][] arr = new int[][] { {1, 2},
									{3, 4},
									{5, 6} };
		assertArrayEquals("no change with 3x2 array with no values of 0", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {0, 2},
							{3, 4},
							{5, 6} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 4}, {0, 6} });
		
		arr = new int[][] { {1, 0},
							{3, 4},
							{5, 6} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {3, 0}, {5, 0} });
		
		arr = new int[][] { {1, 2},
							{0, 4},
							{5, 6} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 2}, {0, 0}, {0, 6} });
		
		arr = new int[][] { {1, 2},
							{3, 0},
							{5, 6} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {1, 0}, {0, 0}, {5, 0} });
		
		arr = new int[][] { {1, 2},
							{3, 4},
							{0, 6} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 2}, {0, 4}, {0, 0} });
		
		arr = new int[][] { {1, 2},
							{3, 4},
							{5, 0} };
		assertArrayEquals("one zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {1, 0}, {3, 0}, {0, 0} });
		
		arr = new int[][] { {0, 2},
							{3, 4},
							{0, 6} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 4}, {0, 0} });
		
		arr = new int[][] { {1, 0},
							{3, 4},
							{5, 0} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {3, 0}, {0, 0} });
		
		arr = new int[][] { {1, 0},
							{0, 4},
							{5, 6} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {1, 2},
							{0, 4},
							{5, 0} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {0, 2},
							{3, 0},
							{5, 6} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {1, 2},
							{3, 0},
							{0, 6} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {0, 2},
							{3, 0},
							{0, 6} };
		assertArrayEquals("three zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {1, 0},
							{0, 4},
							{5, 0} };
		assertArrayEquals("two zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
		
		arr = new int[][] { {0, 0},
							{0, 0},
							{0, 0} };
		assertArrayEquals("all zero in 3x2 array", z.zeroMatrix(arr), new int[][] { {0, 0}, {0, 0}, {0, 0} });
	}
	
	@Test
	public void test3by3() {
		
		int[][] arr = new int[][] { {1, 2, 3},
									{4, 5, 6},
									{7, 8, 9} };
		
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), arr);
		
		arr = new int[][] { {1, 2, 3},
							{4, 0, 6},
							{7, 8, 9} };
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), new int[][] { {1, 0, 3}, {0, 0, 0}, {7, 0, 9} });
		
		//test everything zeros
		arr = new int[][] { {0, 0, 0},
							{0, 0, 0},
							{0, 0, 0} };
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), arr);
		
		
		//test all corners
		arr = new int[][] { {0, 2, 0},
							{4, 5, 6},
							{0, 8, 0} };
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 5, 0}, {0, 0, 0} });
		
		//test one corner without
		arr = new int[][] { {0, 2, 0},
							{4, 5, 6},
							{0, 8, 9} };
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 5, 0}, {0, 0, 0} });
		
		//test corner and middle
		arr = new int[][] { {0, 2, 0},
							{4, 0, 6},
							{0, 8, 0} };
		assertArrayEquals("no zero in 3x3 array", z.zeroMatrix(arr), new int[][] { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} });
	}
	
}
