package algstudent.s6;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class NumericSquareOneTest {
	String[][] data;
	
	@Test
	public void test1() {
		data = BoardLoader.loadData("src/algstudent/s6/test00.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		String[][] solution = numericSquareOne.solve();
		String[][] expected = {{"6","2"},
				   				{"4","3"}};
		assertArrayEquals(solution, expected);
//		numericSquareOne.printBoard();
	}
	
//	@Test
//	public void test2() {
//		data = BoardLoader.loadData("src/algstudent/s6/test01.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		printMatrix(solution);
//		String[][] expected = {{"1","8","3"},
//	   			{"4","3","2"},
//				{"9","7","4"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
//	}
//	
//	@Test
//	public void test3() {
//		data = BoardLoader.loadData("src/algstudent/s6/test02.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		printMatrix(solution);
//		String[][] expected = {{"3","2","1"},
//				{"6","5","5"},
//				{"3","5","6"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
//	}
//	
//	@Test
//	public void test4() {
//		data = BoardLoader.loadData("src/algstudent/s6/test03.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		String[][] expected = {{"1","3","1","1"},
//				{"5","1","1","1"},
//				{"1","1","9","1"},
//				{"0","1","1","0"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
////		numericSquareOne.printNumberBoard();
////		numericSquareOne.printRowOperators();
////		numericSquareOne.printColOperators();
//	}
//	
//	@Test
//	public void test5() {
//		data = BoardLoader.loadData("src/algstudent/s6/test04.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		String[][] expected = {{"1","4","1","0"},
//				{"4","1","1","2"},
//				{"1","1","9","1"},
//				{"1","0","1","0"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
//	}
//	
//	
//	@Test
//	public void test6() {
//		data = BoardLoader.loadData("src/algstudent/s6/test05.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		String[][] expected = {{"1","1","1","1","0"},
//				{"3","0","1","6","2"},
//				{"1","1","9","1","1"},
//				{"3","2","1","0","1"},
//				{"5","3","9","5","2"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
//	}
//	
//	@Test
//	public void test7() {
//		data = BoardLoader.loadData("src/algstudent/s6/test06.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		String[][] expected = {{"1","1","1","1","0"},
//				{"0","0","1","6","2"},
//				{"1","1","0","1","1"},
//				{"3","2","1","0","1"},
//				{"2","3","0","5","2"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
//	}
//	
//	@Test
//	public void test8() {
//		data = BoardLoader.loadData("src/algstudent/s6/test07.txt");
//		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
//		String[][] solution = numericSquareOne.solve();
//		String[][] expected = {{"0","0","0","3","0"},
//				{"0","0","1","2","6"},
//				{"0","0","2","1","1"},
//				{"4","2","0","0","1"},
//				{"2","3","0","3","4"}};
//		assertArrayEquals(solution, expected);
////		numericSquareOne.printBoard();
////		numericSquareOne.printNumberBoard();
//	}
//	
//	private void printMatrix(String[][] solution) {
//		for(int i = 0;  i < solution.length; i++) {
//			for(int j = 0; j < solution[0].length; j++) {
//				System.out.print(solution[i][j]);
//			}
//			System.out.println();
//		} 
//	}
}
