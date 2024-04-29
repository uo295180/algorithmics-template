package algstudent.s7;

import java.util.PriorityQueue;

public class NumericSquareBaB {
	
	int size;
	String[][] data;
	int[][] variableData;
	int[][] solution;
	boolean[][] inmutables;
	String[][] rowOperators;
	String[][] colOperators;
	boolean foundSolution = false;
	
	PriorityQueue<State> statesHeap = new PriorityQueue<State>(new StatesComparator());
	
	public NumericSquareBaB(String[][] data){
		this.data = data;
		size = data.length-data.length/2-1;
		
		reorderData();
		
		fillUpNumberMatrix();
		fillUpRowOperators();
		fillUpColOperators();
		
	}
	
	public int[][] getSolution(){
		return solution;
	}
	
	public void branchAndBound() {
		int init = 0;
		Pair<Integer, Integer> coords = translateCoords(init);
		while(inmutables[coords.x][coords.y]) {
			init++;
			coords = translateCoords(init);
		}
		for(int i = 0; i < 10; i++) {
			variableData[coords.x][coords.y] = i;
			statesHeap.add(new State(variableData, init+1));
		}
		
		while(!statesHeap.isEmpty()&&!foundSolution) {
			State currentState = statesHeap.poll();
			int[][] currentStateData = currentState.getData();
			int position = currentState.getIndex();
			branchAndBound(currentStateData, position);
		}
		
	}
	
	private void branchAndBound(int[][] values, int index) {
		Pair<Integer, Integer> coords = translateCoords(index);
		int[][] safeCopy = copyOf(values);
		boolean isInmutable = false;
		for(int i = 0; i < 10; i++) {
			if(inmutables[coords.x][coords.y]) {
				isInmutable=true;
				break;
			}
			safeCopy[coords.x][coords.y] = i;
			if(coords.x==size-1) {
				if(checkCol(safeCopy, coords.y)) {
					if(coords.y==size-1) {
						if(checkRow(safeCopy, coords.x)) {
							copySolution(safeCopy);
							foundSolution = true;
						}
					} else {
						statesHeap.add(new State(safeCopy, index+1));
					}
					
				}
			}
			else if(coords.y==size-1) {
				if(checkRow(safeCopy, coords.x)){
					statesHeap.add(new State(safeCopy, index+1));
				}	
			}
			else {
				statesHeap.add(new State(safeCopy, index+1));
			}
		}
		if(isInmutable&&coords.x!=size-1&&coords.y!=size-1) {
			statesHeap.add(new State(safeCopy, index+1));
		}else if(isInmutable&&coords.x==size-1) {
			if(checkCol(safeCopy, coords.y)) {
				if(coords.y==size-1) {
					if(checkRow(safeCopy, coords.x)) {
						copySolution(safeCopy);
						foundSolution = true;
					}
				}
				else {
					statesHeap.add(new State(safeCopy, index+1));
				}
			}
		}else if(isInmutable&&coords.y==size-1) {
			if(checkRow(safeCopy, coords.x)){
				statesHeap.add(new State(safeCopy, index+1));
			}	
		}
	}
	
	
	public void copySolution(int[][] safeCopy) {
		solution = copyOf(safeCopy);
	}
	
	
	public boolean checkCol(int[][] values, int index) {
		int value = values[0][index];
		int nextValue;
		String operator;
		for(int i = 0; i < values.length-1; i++) {
			operator = colOperators[i][index];
			nextValue = values[i+1][index];
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
	
	
	public boolean checkRow(int[][] values, int index) {
		int value = values[index][0];
		int nextValue;
		String operator;
		for(int i = 0; i < values.length-1; i++) {
			operator = rowOperators[index][i];
			nextValue = values[index][i+1];
			try{
				value = performOperation(value, operator, nextValue);
				if(value==Integer.MAX_VALUE)return false;
			} catch(Exception e) {
				return false;
			}
		}
		return value==Integer.valueOf(data[index*2][2*size]);
	}
	
	
	
	private int[][] copyOf(int[][] values){
		int[][] copy = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				copy[i][j] = values[i][j];
			}
		}
		return copy;
	}

	public Pair<Integer, Integer> translateCoords(int value){
		int rowCord = value/size;
		int colCord = value%size;
		return new Pair<Integer, Integer>(rowCord,colCord);
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
	
	public void fillUpNumberMatrix() {
		int rowCounter = 0;
		int colCounter = 0;
		variableData=new int[size][size];
		inmutables = new boolean[size][size];
		for(int i = 0; i < data.length - 2; i+=2) {
			colCounter = 0;
			for(int j = 0; j < data[i].length-2; j+=2) {
				if(data[i][j].equals("?")) variableData[rowCounter][colCounter] = -1;
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
