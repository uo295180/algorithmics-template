package algstudent.s6;

import org.junit.Test;

public class NumericSquareOneTest {
String[][] data;
	
	@Test
	public void test1() {
		data = BoardLoader.loadData("src/algstudent/s6/test00.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test2() {
		data = BoardLoader.loadData("src/algstudent/s6/test01.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test3() {
		data = BoardLoader.loadData("src/algstudent/s6/test02.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test4() {
		data = BoardLoader.loadData("src/algstudent/s6/test03.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test5() {
		data = BoardLoader.loadData("src/algstudent/s6/test04.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	
	@Test
	public void test6() {
		data = BoardLoader.loadData("src/algstudent/s6/test05.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test7() {
		data = BoardLoader.loadData("src/algstudent/s6/test06.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
	
	@Test
	public void test8() {
		data = BoardLoader.loadData("src/algstudent/s6/test07.txt");
		NumericSquareOne numericSquareOne = new NumericSquareOne(data);
		numericSquareOne.printBoard();
	}
}
