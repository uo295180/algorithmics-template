package algstudent.s6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import algstudent.s7.NumericSquareBaB;

public class NumericSquareAllTest {
	String[][] data;
	int repetitions = 1;
	
	@Test
	public void test1() {
		System.out.println();
		System.out.println("-------Test 1-------");
		data = BoardLoader.loadData("src/algstudent/s6/test00.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test2() {
		System.out.println();
		System.out.println("-------Test 2-------");
		data = BoardLoader.loadData("src/algstudent/s6/test01.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test3() {
		System.out.println();
		System.out.println("-------Test 3-------");
		data = BoardLoader.loadData("src/algstudent/s6/test02.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test4() {
		System.out.println();
		System.out.println("-------Test 4-------");
		data = BoardLoader.loadData("src/algstudent/s6/test03.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test5() {
		System.out.println();
		System.out.println("-------Test 5-------");
		data = BoardLoader.loadData("src/algstudent/s6/test04.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	
	@Test
	public void test6() {
		System.out.println();
		System.out.println("-------Test 6-------");
		data = BoardLoader.loadData("src/algstudent/s6/test05.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test7() {
		System.out.println();
		System.out.println("-------Test 7-------");
		data = BoardLoader.loadData("src/algstudent/s6/test06.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);
	}
	
	@Test
	public void test8() {
		System.out.println();
		System.out.println("-------Test 8-------");
		data = BoardLoader.loadData("src/algstudent/s6/test07.txt");
		NumericSquareAll numericSquareAll = new NumericSquareAll(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareAll.backtracking();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		
		int numberOfSolutions = numericSquareAll.getNumberOfSolutions();

		System.out.println("Number of solutions found: " + numberOfSolutions);

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
