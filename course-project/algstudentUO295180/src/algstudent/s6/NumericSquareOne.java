package algstudent.s6;

public class NumericSquareOne {
	
	int size;
	String[][] data;
	
	
	public NumericSquareOne(String[][]data) {
		this.data = data;
		size = data.length-data.length/2-1;
		reorderData();
		
		//solve();
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
		System.out.println();
		
	}
}
