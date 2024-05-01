package algstudent.s7;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algstudent.s6.BoardLoader;
import algstudent.s6.NumericSquareOne;

class NumericSquareBaBTest {

	String[][] data;
	int repetitions = 1;
	long t1;
	long t2;
	
	@Test
	public void test1() {
		
		System.out.println();
		System.out.println("-------Test 1-------");
		data = BoardLoader.loadData("src/algstudent/s7/test00.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		long time = 0;
		
		for(int i=0; i<repetitions;i++) {
			numericSquareBaB = new NumericSquareBaB(data);
			t1 = System.currentTimeMillis();
			numericSquareBaB.branchAndBound();
			t2 = System.currentTimeMillis();
			time+=(t2-t1);
		}
			
			
		
		System.out.println("Time: " + ((double)(time)/ (double) repetitions));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());
		
		int[][] solutionInt = numericSquareBaB.getSolution();

//		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test2() {
		System.out.println();
		System.out.println("-------Test 2-------");
		data = BoardLoader.loadData("src/algstudent/s7/test01.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		long time = 0;
		
		for(int i=0; i<repetitions;i++) {
			numericSquareBaB = new NumericSquareBaB(data);
			t1 = System.currentTimeMillis();
			numericSquareBaB.branchAndBound();
			t2 = System.currentTimeMillis();
			time+=(t2-t1);
		}
			
			
		
		System.out.println("Time: " + ((double)(time)/ (double) repetitions));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
//		int[][] solutionInt = numericSquareBaB.getSolution();
//
//		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test3() {
		System.out.println();
		System.out.println("-------Test 3-------");
		data = BoardLoader.loadData("src/algstudent/s7/test02.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		long time = 0;
		
		for(int i=0; i<repetitions;i++) {
			numericSquareBaB = new NumericSquareBaB(data);
			t1 = System.currentTimeMillis();
			numericSquareBaB.branchAndBound();
			t2 = System.currentTimeMillis();
			time+=(t2-t1);
		}
			
		System.out.println("Time: " + (time));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

//		int[][] solutionInt = numericSquareBaB.getSolution();
//
//		String[][] solution = toStringMatrix(solutionInt);
//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test4() {
		System.out.println();
		System.out.println("-------Test 4-------");
		data = BoardLoader.loadData("src/algstudent/s7/test03.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareBaB.branchAndBound();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
		
		int[][] solutionInt = numericSquareBaB.getSolution();

		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test5() {
		System.out.println();
		System.out.println("-------Test 5-------");
		data = BoardLoader.loadData("src/algstudent/s7/test04.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareBaB.branchAndBound();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
		
		int[][] solutionInt = numericSquareBaB.getSolution();

		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	
	@Test
	public void test6() {
		System.out.println();
		System.out.println("-------Test 6-------");
		data = BoardLoader.loadData("src/algstudent/s7/test05.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareBaB.branchAndBound();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
		int[][] solutionInt = numericSquareBaB.getSolution();

		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test7() {
		System.out.println();
		System.out.println("-------Test 7-------");
		data = BoardLoader.loadData("src/algstudent/s7/test06.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareBaB.branchAndBound();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
		int[][] solutionInt = numericSquareBaB.getSolution();

		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();
	}
	
	@Test
	public void test8() {
		System.out.println();
		System.out.println("-------Test 8-------");
		data = BoardLoader.loadData("src/algstudent/s7/test07.txt");
		NumericSquareBaB numericSquareBaB = new NumericSquareBaB(data);
		
		long t1 = System.currentTimeMillis();
		for(int i=0; i<repetitions;i++)
			numericSquareBaB.branchAndBound();
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println("Developed nodes: " + numericSquareBaB.getDevelopedNodes());

		
		int[][] solutionInt = numericSquareBaB.getSolution();

		String[][] solution = toStringMatrix(solutionInt);

//		printMatrix(solution);
//		numericSquareBaB.printBoard();

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
