package algstudent.s6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import algstudent.s7.NumericSquareBaB;

public class NumericSquareOneTest {
	String[][] data;
	int repetitions = 1;
	
	@Test
	public void test1() {
		System.out.println();
		System.out.println("-------Test 1-------");
		data = BoardLoader.loadData("src/algstudent/s6/test00.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"6","2"},
				   				{"4","3"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
		assertArrayEquals(solution, expected);
	}
	
	@Test
	public void test2() {
		System.out.println();
		System.out.println("-------Test 2-------");
		data = BoardLoader.loadData("src/algstudent/s6/test01.txt");
		NumericSquareOne numericSquareOne= new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		
		String[][] expected = {{"1","8","3"},
	   			{"4","3","2"},
				{"9","7","4"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
		assertArrayEquals(solution, expected);

	}
	
	@Test
	public void test3() {
		System.out.println();
		System.out.println("-------Test 3-------");
		data = BoardLoader.loadData("src/algstudent/s6/test02.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		printMatrix(solution);
		String[][] expected = {{"3","2","1"},
				{"6","5","5"},
				{"3","5","6"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
		assertArrayEquals(solution, expected);

	}
	
	@Test
	public void test4() {
		System.out.println();
		System.out.println("-------Test 4-------");
		data = BoardLoader.loadData("src/algstudent/s6/test03.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"1","3","1","1"},
				{"5","1","1","1"},
				{"1","1","9","1"},
				{"0","1","1","0"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
//		numericSquareOne.printNumberBoard();
//		numericSquareOne.printRowOperators();
//		numericSquareOne.printColOperators();
		assertArrayEquals(solution, expected);

	}
	
	@Test
	public void test5() {
		System.out.println();
		System.out.println("-------Test 5-------");
		data = BoardLoader.loadData("src/algstudent/s6/test04.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();
		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"1","4","1","0"},
				{"4","1","1","2"},
				{"1","1","9","1"},
				{"1","0","1","0"}};
		assertArrayEquals(solution, expected);
		printMatrix(solution);
		numericSquareOne.printBoard();
	}
	
	
	@Test
	public void test6() {
		System.out.println();
		System.out.println("-------Test 6-------");
		data = BoardLoader.loadData("src/algstudent/s6/test05.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"1","1","1","1","0"},
				{"3","0","1","6","2"},
				{"1","1","9","1","1"},
				{"3","2","1","0","1"},
				{"5","3","9","5","2"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
		assertArrayEquals(solution, expected);

	}
	
	@Test
	public void test7() {
		System.out.println();
		System.out.println("-------Test 7-------");
		data = BoardLoader.loadData("src/algstudent/s6/test06.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"1","1","1","1","0"},
				{"0","0","1","6","2"},
				{"1","1","0","1","1"},
				{"3","2","1","0","1"},
				{"2","3","0","5","2"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
		assertArrayEquals(solution, expected);

	}
	
	@Test
	public void test8() {
		System.out.println();
		System.out.println("-------Test 8-------");
		data = BoardLoader.loadData("src/algstudent/s6/test07.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareOne.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int[][] solutionInt = numericSquareOne.getSolution();

		String[][] solution = toStringMatrix(solutionInt);
		String[][] expected = {{"0","0","0","3","0"},
				{"0","0","1","2","6"},
				{"0","0","2","1","1"},
				{"4","2","0","0","1"},
				{"2","3","0","3","4"}};
		printMatrix(solution);
		numericSquareOne.printBoard();
//		numericSquareOne.printNumberBoard();
		assertArrayEquals(solution, expected);

	}

	private void printMatrix(String[][] solution) {
		for(int i = 0;  i < solution.length; i++) {
			for(int j = 0; j < solution[0].length; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.println();
		} 
	}
	
	private void printMatrix(int[][] solution) {
		for(int i = 0;  i < solution.length; i++) {
			for(int j = 0; j < solution[0].length; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.println();
		} 
	}
	
	private String[][] toStringMatrix(int[][] matrix){
		String[][] solution = new String[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				solution[i][j] = String.valueOf(matrix[i][j]);
			}
		}
		return solution;
	}
}
