package algstudent.s6;

import algstudent.s7.Pair;

public class NumericSquareAll {
	int size;
	String[][] data;
	int[][] variableData;
	boolean[][] inmutables;
	String[][] rowOperators;
	String[][] colOperators;
	int numberOfSolutions;
	
	public NumericSquareAll(String[][]data) {
		this.data = data;
		size = data.length-data.length/2-1;
		reorderData();
		
		fillUpNumberMatrix();
		fillUpRowOperators();
		fillUpColOperators();
		
		//solve();
	}

	public int[][] getSolution(){
		return variableData;
	}
	
	public void backtracking() {
		backtracking(0);
	}
	
	private void backtracking(int index) {
		Pair<Integer, Integer> coords = translateCoords(index);
		boolean isInmutable = false;
		boolean divisionRow = false;
		boolean divisionCol = false;

		for(int i = 0; i < 10; i++) {
			if(inmutables[coords.x][coords.y]) {
				isInmutable=true;
				break;
			}
			variableData[coords.x][coords.y] = i;
			if(coords.x>0&&colOperators[coords.x-1][coords.y]=="/") {
				if(performOperation(variableData[coords.x-1][coords.y], "/", i)==Integer.MAX_VALUE) divisionCol=true;
				else divisionCol=false;
			}if(coords.y>0&&rowOperators[coords.x][coords.y-1]=="/") {
				if(performOperation(variableData[coords.x][coords.y-1], "/", i)==Integer.MAX_VALUE) divisionRow=true;
				else divisionRow=false;
			}
			
			if(coords.x==size-1&&!divisionRow&&!divisionCol) {
				if(checkCol(coords.y)) {
					if(coords.y==size-1) {
						if(checkRow(coords.x)) {
							numberOfSolutions++;
							System.out.println("Solution " + numberOfSolutions);
							printSolution();
						}
					}
					else {
						backtracking(index + 1);
					}
				}
			}
			else if(coords.y==size-1&&!divisionRow&&!divisionCol) {
				if(checkRow(coords.x)){
					backtracking(index + 1);
				}	
			}
			else if(!divisionRow&&!divisionCol){
				backtracking(index + 1);
			}
		}
		if(coords.x>0&&colOperators[coords.x-1][coords.y]=="/") {
			if(performOperation(variableData[coords.x-1][coords.y], "/", variableData[coords.x][coords.y])==Integer.MAX_VALUE) divisionCol=true;
			else divisionCol=false;
		}if(coords.y>0&&rowOperators[coords.x][coords.y-1]=="/") {
			if(performOperation(variableData[coords.x][coords.y-1], "/", variableData[coords.x][coords.y])==Integer.MAX_VALUE) divisionRow=true;
			else divisionRow=false;
		}
		if(isInmutable&&coords.x!=size-1&&coords.y!=size-1&&!divisionRow&&!divisionCol) {
			backtracking(index + 1);
		}else if(isInmutable&&coords.x==size-1&&!divisionRow&&!divisionCol) {
			if(checkCol(coords.y)) {
				if(coords.y==size-1) {
					if(checkRow(coords.x)) {
						numberOfSolutions++;
						System.out.println("Solution " + numberOfSolutions);
						printSolution();
					}
				}
				else {
					backtracking(index + 1);
				}
			}
		}else if(isInmutable&&coords.y==size-1&&!divisionRow&&!divisionCol) {
			if(checkRow(coords.x)){
				backtracking(index + 1);
			}	
		}
	}
	
	public Pair<Integer, Integer> translateCoords(int value){
		int rowCord = value/size;
		int colCord = value%size;
		return new Pair<Integer, Integer>(rowCord,colCord);
	}

	public void fillUpNumberMatrix() {
		int rowCounter = 0;
		int colCounter = 0;
		variableData=new int[size][size];
		inmutables = new boolean[size][size];
		for(int i = 0; i < data.length - 2; i+=2) {
			colCounter = 0;
			for(int j = 0; j < data[i].length-2; j+=2) {
				if(data[i][j].equals("?")) variableData[rowCounter][colCounter] = 0;
				else {
					variableData[rowCounter][colCounter] = Integer.valueOf(data[i][j]);
					inmutables[rowCounter][colCounter] = true;
				}
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
	
	public void printBoard() {
		System.out.println("Current status:");
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(variableData[i][j] + " ");
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
	
	public void printSolution() {
		System.out.println();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(variableData[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printNumberBoard() {
		for(int i = 0; i < variableData.length; i++) {
			System.out.println();
			for(int j =0; j < variableData[i].length; j++) {
				
				System.out.print(variableData[i][j]);
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
	
	
	private String[][] solutionFormat() {
		String[][] solution = new String[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				solution[i][j] = String.valueOf(variableData[i][j]);
			}
		}
		return solution;
	}
	
	private boolean checkIsSolved() {
		boolean isSolved = true;
		for(int i = 0; i < size; i++) {
			isSolved = isSolved && checkCol(i);
			if(!isSolved) break;
		}
		return isSolved;
		
	}
	
	
	
	public boolean checkRow(int index) {
		int value = variableData[index][0];
		int nextValue;
		String operator;
		for(int i = 0; i < variableData.length-1; i++) {
			operator = rowOperators[index][i];
			nextValue = variableData[index][i+1];
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
		int value = variableData[0][index];
		int nextValue;
		String operator;
		for(int i = 0; i < variableData.length-1; i++) {
			operator = colOperators[i][index];
			nextValue = variableData[i+1][index];
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

	public int getNumberOfSolutions() {
		return numberOfSolutions;
	}
}