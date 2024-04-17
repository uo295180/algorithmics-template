package algstudent.p6;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class NumericSquareTestOne {
	private static String PATH= "src/main/java/algstudent/p6/";
	private String[][] table;
	
	@Test
	public void test0() {
		loadData(PATH+"test00.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test00");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"6","2"},
						   {"4","3"}};
		printTable(tableSol,"Solution returned test00");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test1() {
		loadData(PATH+"test01.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test01");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"1","8","3"},
				   			{"4","3","2"},
							{"9","7","4"}};
		printTable(tableSol,"Solution returned test01");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test2() {
		loadData(PATH+"test02.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test02");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"3","2","1"},
				{"6","5","5"},
				{"3","5","6"}};
		printTable(tableSol,"Solution returned test02");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);

	}
	
	@Test
	public void test3() {
		loadData(PATH+"test03.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test03");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"1","3","1","1"},
				{"5","1","1","1"},
				{"1","1","9","1"},
				{"0","1","1","0"}};
		printTable(tableSol,"Solution returned test03");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test4() {
		loadData(PATH+"test04.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test04");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"1","4","1","0"},
				{"4","1","1","2"},
				{"1","1","9","1"},
				{"1","0","1","0"}};

		printTable(tableSol,"Solution returned test04");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test5() {
		loadData(PATH+"test05.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test05");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"1","1","1","1","0"},
				{"3","0","1","6","2"},
				{"1","1","9","1","1"},
				{"3","2","1","0","1"},
				{"5","3","9","5","2"}};
		printTable(tableSol,"Solution returned test05");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test6() {
		loadData(PATH+"test06.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test06");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"1","1","1","1","0"},
				{"0","0","1","6","2"},
				{"1","1","0","1","1"},
				{"3","2","1","0","1"},
				{"2","3","0","5","2"}};

		printTable(tableSol,"Solution returned test06");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}
	
	@Test
	public void test7() {
		loadData(PATH+"test07.txt");		
		NumericSquareBase numericSquare = new NumericSquare(this.table);
		printTable(this.table,"test07");
		numericSquare.backtracking();
		String[][] tableSol= numericSquare.getSol();
		String[][] solOk= {{"0","0","0","3","0"},
				{"0","0","1","2","6"},
				{"0","0","2","1","1"},
				{"4","2","0","0","1"},
				{"2","3","0","3","4"}};

		printTable(tableSol,"Solution returned test07");
		assertArrayEquals(convertNum(numericSquare.getSol()),solOk);
	}

	/**
	 * Load data from file and store in array with operations and results
	 * @param file
	 */
	private void loadData(String file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			int i = 0;
			int size = Integer.valueOf(reader.readLine());
			this.table = new String[size*2+1][size*2+1]; //the number of rows and columns are twice + 1 the number of operations in each direction
			while (reader.ready()) { //each line
				String[] parts = reader.readLine().split(" ");
				int j = 0; //columns
				for (String part : parts) {
					this.table[i][j] = part; 
					if ((i%2 == 1)||(i == size*2)) //to separate operators in odd rows (i%2 == 1) and in the last row (i == size*2)
						j++; //we skip an extra column to create the table
					j++;
				}
				i++; //next line
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Converts a table including numbers, operations and results to a table with only numbers but in String format
	 * @param sol table with operations and results
	 * @return numTable converted to only numeric values
	 */
	private String[][] convertNum(String[][] sol) {
		int numSize= sol.length/2;  // number table size
		String[][] numTable= new String[numSize][numSize];
		
		int a= 0; int b= 0;  // number table index
		for (int i = 0; i < sol.length-2; i+= 2) {  // sol.length-2 because we don't convert the result
			for (int j = 0; j < sol.length-2; j+= 2) {
				if (sol[i][j] != null) {
					numTable[a][b]= sol[i][j];
					b++;
				}
			}
			a++; b= 0;
		}

		return numTable;
	}
	
	/**
	 * Print any two-dimensional table with a title via console
	 * @param table for printing
	 * @param title
	 */
	private void printTable(String[][] table, String title) {
		if (title != null)
			System.out.printf("NUMERIC SQUARE - %s\n", title);
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == null)
					System.out.printf("%5s", "");
				else
					System.out.printf("%5s", table[i][j]);
			}
			System.out.printf("\n\n");
		}
	}


}
