package algstudent.s6;

import java.util.Arrays;

public class NumericSquareOne {
	
	int size;
	boolean solveAgain = false;
	String[][] data;
	Number[][] variableData;
	String[][] rowOperators;
	String[][] colOperators;
	
	
	public NumericSquareOne(String[][]data) {
		this.data = data;
		size = data.length-data.length/2-1;
		reorderData();
		
		fillUpNumberMatrix();
		fillUpRowOperators();
		fillUpColOperators();
		
		//solve();
	}

	public void fillUpNumberMatrix() {
		int rowCounter = 0;
		int colCounter = 0;
		variableData=new Number[size][size];
		for(int i = 0; i < data.length - 2; i+=2) {
			colCounter = 0;
			for(int j = 0; j < data[i].length-2; j+=2) {
				if(data[i][j].equals("?")) variableData[rowCounter][colCounter] = new Number();
				else variableData[rowCounter][colCounter] = new Number(Integer.valueOf(data[i][j]),true);
				colCounter++;
			}
			rowCounter++;
		}
	}
	
	public void fillUpRowOperators() {
		int rowCounter = 0;
		int colCounter = 0;
		rowOperators=new String[size][size-1];
		for(int i = 0; i < data.length - 2; i+=2) {
			colCounter = 0;
			for(int j = 1; j < data[i].length-3; j+=2) {
				rowOperators[rowCounter][colCounter]=data[i][j];
				colCounter++;
			}
			rowCounter++;
		}
	}
	
	public void fillUpColOperators() {
		int rowCounter = 0;
		int colCounter = 0;
		colOperators=new String[size-1][size];
		for(int i = 1; i < data.length - 2; i+=2) {
			colCounter = 0;
			for(int j = 0; j < data[i].length-2; j+=2) {
				colOperators[rowCounter][colCounter]=data[i][j];
				colCounter++;
			}
			rowCounter++;
		}
	}
	
	private void reorderData() {
		for(int i = 1; i < data.length; i+=2) {
			String[] opRow = new String[size];
			for(int j = 0; j < size; j++) {
				opRow[j] = data[i][j];
				data[i][j] = " ";
			}
			for(int j = size; j < data.length; j++) {
				data[i][j] = " ";
				data[data.length-1][j] = " ";
			}
			for(int j = 0; j < size; j++) {
				data[i][j*2] = opRow[j];
			}
		}
	}
	
	private Operators translateOperator(String operator) {
		switch(operator) {
			case("+"): return Operators.ADD;
			case("-"): return Operators.SUB;
			case("/"): return Operators.DIV;
			case("*"): return Operators.MUL;
		}
		throw new IllegalStateException("Wrong operator found: " + operator);
	}
	
	public void printBoard() {
		System.out.println("Current status:");
		for(int i = 0; i < data.length-1; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		for(int j = 0; j < data[data.length-1].length; j++) {
				System.out.print(data[data.length-1][j] + "   ");
		}
		
		for(int i = 0; i < data.length; i++) {
			System.out.println();
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]);
			}
		}
		System.out.println();
	}
	
	public void printNumberBoard() {
		for(int i = 0; i < variableData.length; i++) {
			System.out.println();
			for(int j =0; j < variableData[i].length; j++) {
				
				System.out.print(variableData[i][j].value);
			}
		}
	}
	
	public void printRowOperators() {
		for(int i = 0; i < rowOperators.length; i++) {
			System.out.println();
			for(int j =0; j < rowOperators[i].length; j++) {
				
				System.out.print(rowOperators[i][j]);
			}
		}
	}
	public void printColOperators() {
		for(int i = 0; i < colOperators.length; i++) {
			System.out.println();
			for(int j =0; j < colOperators[i].length; j++) {
				
				System.out.print(colOperators[i][j]);
			}
		}
	}
	
	
	public String[][] solve() {
		solveRows();
		if(!checkIsSolved()) {
			solveAgain = true;
			if(!solveAll(0)) {
				System.out.println("Not working");
			}
		}
		return solutionFormat();
	}
	
	private String[][] solutionFormat() {
		String[][] solution = new String[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				solution[i][j] = String.valueOf(variableData[i][j].value);
			}
		}
		return solution;
	}

//	private boolean solveAll(int rowIndex) {
//		int[] initialRow = initialValues(variableData[rowIndex]);
//		if(rowIndex<size-1) {
//			if(solveAll(rowIndex + 1)) return true;
//			solveRow(rowIndex,0);
//			while(!equalRows(initialRow, variableData[rowIndex])) {
//				solveRow(rowIndex,0);
//				if(checkIsSolved()) return true;
//				solveAll(rowIndex + 1);
//			}
//		}else {
//			solveRow(rowIndex,0);
//			if(checkIsSolved()) return true;
//			if(!solveAgain&&checkRow(rowIndex)) return true;
//			else solveAgain=false;
//			while(!equalRows(initialRow, variableData[rowIndex])) {
//				solveAgain=true;
//				solveRow(rowIndex,0);
//				if(checkIsSolved()) return true;
//			}
//			
//			return false;
//		}
//		return false;
//		}
	
	private boolean solveAll(int rowIndex) {
		int[] initialRow = initialValues(variableData[rowIndex]);
		if(rowIndex == 0)
		if(rowIndex<size-1) {
			if(solveAll(rowIndex + 1)) return true;
		}
		solveRow(rowIndex,0);
		if(rowIndex<size-1) {
			if(solveAll(rowIndex+1)) return true;
		}
		while(!equalRows(initialRow, variableData[rowIndex])) {
			if(checkIsSolved()) return true;
			solveRow(rowIndex,0);
			if(rowIndex<size-1) {
				if(solveAll(rowIndex+1)) return true;
			}
		}
		return false;
	}
		

	private int[] initialValues(Number[] row) {
		int[] initialValues = new int[row.length];
		for(int i = 0; i < row.length; i++) {
			initialValues[i] = row[i].value;
		}
		return initialValues;
	}
	
	private boolean equalRows(int[] row1, Number[] row2) {
		for(int i = 0; i < row1.length; i++) {
			if(row1[i] != row2[i].value) return false;
		}
		return true;
	}
	
	private void solveRows() {
		for(int i = 0; i < size; i++) {
			solveRow(i,0);
		}
	}
	
	private boolean checkIsSolved() {
		boolean isSolved = true;
		for(int i = 0; i < size; i++) {
			isSolved = isSolved && checkCol(i);
			if(!isSolved) break;
		}
		return isSolved;
		
	}
	
	private boolean solveRow(int row, int index) {
		Number currentNumber = variableData[row][index];
		if(index<variableData.length-1) {
			if(solveRow(row, index +1)) return true;
			for(int i = 0; i < 9; i++) {
				if(!currentNumber.isInmutable()) {
					currentNumber.increase();
					if(checkRow(row)) return true;
					if(solveRow(row, index+1)) return true;
				}
			}
			if(index==0) currentNumber.increase();
			return false;
		}
		
		for(int i = 0; i < 9; i++) {
			if(currentNumber.isInmutable()) break;
			currentNumber.increase();
			if(checkRow(row)) return true;
		}
		return false;
	}
	
	public boolean checkRow(int index) {
		int value = variableData[index][0].value;
		int nextValue;
		String operator;
		for(int i = 0; i < variableData.length-1; i++) {
			operator = rowOperators[index][i];
			nextValue = variableData[index][i+1].value;
			try{
				value = performOperation(value, operator, nextValue);
				if(value==Integer.MAX_VALUE)return false;
			} catch(Exception e) {
				return false;
			}
		}
		return value==Integer.valueOf(data[index*2][2*size]);
	}
	
	public boolean checkCol(int index) {
		int value = variableData[0][index].value;
		int nextValue;
		String operator;
		for(int i = 0; i < variableData.length-1; i++) {
			operator = colOperators[i][index];
			nextValue = variableData[i+1][index].value;
			try{
				value = performOperation(value, operator, nextValue);
				if(value==Integer.MAX_VALUE)return false;
			} catch(Exception e) {
				return false;
			}
		}
		boolean result = value==Integer.valueOf(data[data.length-1][index]);
		return result;
	}
	

	private int performOperation(int value, String operator, int nextValue) {
		switch(operator) {
			case("+"):
				return value + nextValue;
			case("-"):
				return value - nextValue;
			case("*"):
				return value * nextValue;
			case("/"):
				if(value%nextValue!=0) return Integer.MAX_VALUE;
				return value / nextValue;
		}
		throw new IllegalArgumentException("Rare operator");
	}
}
